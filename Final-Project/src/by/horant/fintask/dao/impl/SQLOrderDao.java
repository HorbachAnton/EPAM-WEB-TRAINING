package by.horant.fintask.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.OrderDAO;
import by.horant.fintask.dao.util.ApprovedIdentifier;
import by.horant.fintask.dao.util.ShutterDao;
import by.horant.fintask.dao.util.UsedIdentifier;
import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.Prescription;
import by.horant.fintask.entity.User;
import by.horant.fintask.entity.enumeration.ApprovedStages;
import by.horant.fintask.entity.enumeration.OrderComleteStages;
import by.horant.fintask.entity.enumeration.UsedStages;

public class SQLOrderDao implements OrderDAO {

    private static final String QUERRY_GET_PRESCRIPTION = "SELECT * FROM prescriptions WHERE idPrescription IN (SELECT Prescriptions_idPrescription FROM prescriptions_has_medicines WHERE Prescriptions_Users_idUser = ? AND Medicines_idMedicine = ?) AND isApproved = ? AND isUsed = ?;";
    private static final String QUERRY_INSERT_MEDICINE_IN_ORDER = "INSERT INTO orders_has_medicines (`Orders_idOrder`, `Medicines_idMedicine`, `OrdersHasMedicines_count`) VALUES (?, ?, ?)";
    private static final String QUERRY_GET_ID_UNUSED_PRESCRIPTION = "SELECT idPrescription FROM (SELECT prescriptions.*, prescriptions_has_medicines.* FROM prescriptions INNER JOIN prescriptions_has_medicines ON prescriptions.idPrescription = prescriptions_has_medicines.Prescriptions_idPrescription WHERE  prescriptions.isApproved = ? AND prescriptions.isUsed = ? AND prescriptions_has_medicines.Prescriptions_Users_idUser = ? AND prescriptions_has_medicines.Medicines_idMedicine = ?) as b";
    private static final String QUERRY_UPDATE_PRESCRIPTION_TO_USED = "UPDATE prescriptions SET prescriptions.isUsed = ? WHERE prescriptions.idPrescription = ?";
    private static final String QUERRY_ADD_PRESCRIPTION_TO_ORDER = "INSERT INTO orders_has_prescriptions (`orders_idOrder`, `prescriptions_idPrescription`) VALUES (?, ?)";
    private static final String QUERRY_ADD_ORDER = "INSERT INTO orders (`isCompleted`, `Users_idUser`) VALUES (?, ?);";
    private static final String QUERRY_COMPLETE_ORDER = "UPDATE orders SET orders.isCompleted = ? WHERE idOrder = ?";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    /**
     * Checks the availability of all necessary prescriptions for drugs included in
     * this order.
     */
    @Override
    public List<Medicine> checkRecipes(Order order) throws DaoException {
	List<Medicine> medicationWithoutRecipes = null;

	if (order != null) {
	    List<Medicine> purshasedMedication = order.getPurchasedMedications();
	    List<Prescription> orderPrescription = order.getPrescriptions();
	    medicationWithoutRecipes = new ArrayList<>();

	    orderPrescription.clear();

	    Connection con = null;
	    PreparedStatement st = null;
	    ResultSet rs = null;

	    try {
		con = pool.getConnection();
		st = con.prepareStatement(QUERRY_GET_PRESCRIPTION);

		st.setInt(1, order.getCustomer().getId());
		st.setInt(3, ApprovedStages.APPROVED.getIdentifier());
		st.setInt(4, UsedStages.UNUSED.getIdentifier());

		for (Medicine medication : purshasedMedication) {
		    st.setInt(2, medication.getId());
		    rs = st.executeQuery();

		    rs.last();
		    int rowCount = rs.getRow();
		    rs.beforeFirst();

		    if (!rs.next() && medication.isNeedPrescription()) {
			medicationWithoutRecipes.add(medication);
		    } else if (medication.isNeedPrescription()) {
			Prescription prescription = createPrescription(rs, medication, order);
			if (orderPrescription.contains(prescription)) {
			    boolean isAdded = false;
			    for (int i = 0; i < rowCount - 1; i++) {
				rs.next();
				Prescription newPrescription = createPrescription(rs, medication, order);
				if (!orderPrescription.contains(newPrescription)) {
				    order.addPrescription(newPrescription);
				    isAdded = true;
				    break;
				}
			    }
			    if (!isAdded) {
				medicationWithoutRecipes.add(medication);
			    }
			} else {
			    order.addPrescription(prescription);
			}
		    }
		}
	    } catch (SQLException e) {
		throw new DaoException(e);
	    } finally {
		ShutterDao.close(rs, st, con);
	    }
	} else {
	    medicationWithoutRecipes = new ArrayList<>();
	}

	return medicationWithoutRecipes;
    }

    /**
     * Creates a prescription for the appropriate medicine.
     * 
     * @param rs         object that implement interface ResultSet.
     * @param medication the medicine for which the prescription is written.
     * @param order      order to which this recipe will apply
     * @return prescription for the appropriate medicine.
     * @throws SQLException
     */
    private Prescription createPrescription(ResultSet rs, Medicine medication, Order order) throws SQLException {
	Prescription prescription = new Prescription();

	prescription.setId(rs.getInt("idPrescription"));
	prescription.setIssueDate(rs.getDate("prescription_issueDate").toLocalDate());
	prescription.setRecipient(order.getCustomer());
	prescription.setApprovedStage(ApprovedIdentifier.debineByIndex(rs.getInt("isApproved")));
	prescription.setUsedStage(UsedIdentifier.defineByIndex(rs.getInt("isUsed")));
	prescription.setPrescribedMedication(medication);

	return prescription;
    }

    /**
     * Adds an order to the database.
     */
    @Override
    public boolean addOrder(User user, Order order) throws DaoException {
	boolean result = false;

	List<Medicine> purchasedMedicines = order.getPurchasedMedications();
	List<Medicine> copyMedicines = new ArrayList<>();

	try {
	    Connection con = pool.getConnection();
	    con.setAutoCommit(false);

	    for (int i = 0; i < purchasedMedicines.size(); i++) {
		Medicine currentMedicine = purchasedMedicines.get(i);
		copyMedicines.add(currentMedicine);
		int earlySize = purchasedMedicines.size();
		purchasedMedicines.removeAll(copyMedicines);
		int amount = earlySize - purchasedMedicines.size();

		int orderId = addOrderSQL(user.getId(), con);
		addMedicineToOrder(orderId, currentMedicine.getId(), amount, con);
		addPrescriptionToOrder(orderId, user.getId(), currentMedicine.getId(), con);

		result = true;
	    }

	    con.commit();
	} catch (SQLException e) {
	    throw new DaoException(e);
	}

	return result;
    }

    /**
     * Adds the medicine to the appropriate order by its id.
     * 
     * @param orderId    order id to which the medicine is added.
     * @param medicineId medicine id which is added to the order.
     * @param amount     amount of medicine added.
     * @param con        object that implement interface Connection.
     * @throws DaoException
     */
    private void addMedicineToOrder(int orderId, int medicineId, int amount, Connection con) throws DaoException {

	PreparedStatement st = null;

	try {
	    st = con.prepareStatement(QUERRY_INSERT_MEDICINE_IN_ORDER);

	    st.setInt(1, orderId);
	    st.setInt(2, medicineId);
	    st.setInt(3, amount);

	    st.executeUpdate();
	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(st);
	}
    }

    /**
     * Adds the prescription to the appropriate order by its id.
     * 
     * @param orderId    order id to which the prescription is added.
     * @param userId     user id on whose face prescription is written.
     * @param medicineId medicine id for which the prescription is written.
     * @param con        object that implement interface Connection.
     * @throws DaoException
     */
    private void addPrescriptionToOrder(int orderId, int userId, int medicineId, Connection con) throws DaoException {

	PreparedStatement st = null;
	ResultSet rs = null;

	try {
	    st = con.prepareStatement(QUERRY_GET_ID_UNUSED_PRESCRIPTION);

	    st.setInt(1, ApprovedStages.APPROVED.getIdentifier());
	    st.setInt(2, UsedStages.UNUSED.getIdentifier());
	    st.setInt(3, userId);
	    st.setInt(4, medicineId);

	    rs = st.executeQuery();

	    while (rs.next()) {
		int prescriptionId = rs.getInt("idPrescription");
		updatePrescriptionToUsed(prescriptionId, con);
		addPrescriptionOrder(orderId, prescriptionId, con);
	    }

	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(st, rs);
	}
    }

    /**
     * Updates prescription status to 'used' in database.
     * 
     * @param prescriptionId id prescription we want to update.
     * @param con            object that implement interface Connection.
     * @throws DaoException
     */
    private void updatePrescriptionToUsed(int prescriptionId, Connection con) throws DaoException {

	PreparedStatement st = null;

	try {
	    st = con.prepareStatement(QUERRY_UPDATE_PRESCRIPTION_TO_USED);

	    st.setInt(1, UsedStages.USED.getIdentifier());
	    st.setInt(2, prescriptionId);

	    st.executeUpdate();

	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(st);
	}
    }

    /**
     * Adds prescription to oder in database.
     * 
     * @param orderId        the recipe id we want to add.
     * @param prescriptionId id prescription we want to add.
     * @param con            object that implement interface Connection.
     * @throws DaoException
     */
    private void addPrescriptionOrder(int orderId, int prescriptionId, Connection con) throws DaoException {

	PreparedStatement st = null;

	try {
	    st = con.prepareStatement(QUERRY_ADD_PRESCRIPTION_TO_ORDER);

	    st.setInt(1, orderId);
	    st.setInt(2, prescriptionId);

	    st.executeUpdate();
	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(st);
	}

    }

    /**
     * Adds order in database.
     * 
     * @param userId id of the user who placed the order.
     * @param con    object that implement interface Connection.
     * @return the generated key of the added order.
     * @throws DaoException
     */
    private int addOrderSQL(int userId, Connection con) throws DaoException {
	int orderId = 0;

	PreparedStatement st = null;
	ResultSet rs = null;

	try {
	    st = con.prepareStatement(QUERRY_ADD_ORDER, Statement.RETURN_GENERATED_KEYS);

	    st.setInt(1, OrderComleteStages.UNCOMPLETED.getIdentifier());
	    st.setInt(2, userId);

	    st.executeUpdate();

	    rs = st.getGeneratedKeys();

	    if (rs.next()) {
		orderId = rs.getInt(1);
	    }

	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(st, rs);
	}

	return orderId;
    }

    /**
     * Completes order.
     */
    @Override
    public boolean completeOrder(int orderId) throws DaoException {
	boolean result = false;

	Connection con = null;
	PreparedStatement st = null;

	try {
	    con = pool.getConnection();
	    st = con.prepareStatement(QUERRY_COMPLETE_ORDER);

	    st.setInt(1, OrderComleteStages.COMPLETED.getIdentifier());
	    st.setInt(2, orderId);

	    st.executeUpdate();
	    result = true;
	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(st, con);
	}

	return result;
    }
}
