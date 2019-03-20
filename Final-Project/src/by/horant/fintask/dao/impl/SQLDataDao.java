package by.horant.fintask.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.DataDAO;
import by.horant.fintask.dao.util.RolesIdentifier;
import by.horant.fintask.dao.util.ShutterDao;
import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.Prescription;
import by.horant.fintask.entity.RequestedPrescription;
import by.horant.fintask.entity.User;

public class SQLDataDao implements DataDAO {

    private static final String QUERY_GET_ALL_USERS = "SELECT * FROM users";
    private static final String QUERY_GET_ALL_ORDERS = "SELECT DISTINCT h.idOrder, h.isCompleted, h.idUser, h.user_email, h.user_firstName, h.user_secondName, h.Roles_idRole, h.Medicines_idMedicine, medicines.medicine_name, h.OrdersHasMedicines_count, h.prescriptions_idPrescription FROM (SELECT DISTINCT d.idOrder, d.isCompleted, d.Medicines_idMedicine, d.OrdersHasMedicines_count, d.prescriptions_idPrescription, users.idUser, users.user_email, users.user_firstName, users.user_secondName, users.Roles_idRole FROM (SELECT DISTINCT e.idOrder, e.isCompleted, e.Users_idUser, e.Medicines_idMedicine, e.OrdersHasMedicines_count, orders_has_prescriptions.prescriptions_idPrescription FROM (SELECT DISTINCT orders.*, orders_has_medicines.* FROM orders INNER JOIN orders_has_medicines WHERE orders.idOrder = orders_has_medicines.Orders_idOrder) as e INNER JOIN orders_has_prescriptions WHERE e.Orders_idOrder = orders_has_prescriptions.orders_idOrder) as d INNER JOIN users WHERE d.Users_idUser = users.idUser) as h INNER JOIN medicines WHERE h.Medicines_idMedicine = medicines.idMedicine;";
    private static final String QUERY_GET_ALL_MEDICINES = "SELECT * FROM medicines";
    private static final String QUERY_GET_ALL_REQUESTED_PRESCRIPTIONS = "SELECT b.Prescriptions_idPrescription, b.user_firstName, b.user_secondName, medicines.medicine_name FROM (SELECT a.Prescriptions_idPrescription, users.user_firstName,users.user_secondName, a.Medicines_idMedicine FROM (SELECT prescriptions_has_medicines.*, prescriptions.isApproved FROM prescriptions_has_medicines INNER JOIN prescriptions WHERE prescriptions_has_medicines.Prescriptions_idPrescription = prescriptions.idPrescription AND ISNULL(prescriptions.isApproved) ) as a INNER JOIN users WHERE a.Prescriptions_Users_idUser = users.idUser) as b INNER JOIN medicines WHERE b.Medicines_idMedicine = medicines.idMedicine";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public List<User> getUsers() throws DaoException {
	List<User> users = new ArrayList<>();

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	try {
	    con = pool.getConnection();
	    st = con.prepareStatement(QUERY_GET_ALL_USERS);
	    rs = st.executeQuery();

	    while (rs.next()) {
		User user = new User();
		user.setId(rs.getInt("idUser"));
		user.setEmail(rs.getString("user_email"));
		user.setPassword(rs.getString("user_password"));
		user.setFirstName(rs.getString("user_firstName"));
		user.setSecondName(rs.getString("user_secondName"));
		user.setRole(RolesIdentifier.defineByIndex(rs.getInt("Roles_idRole")));
		users.add(user);
	    }
	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(rs, st, con);
	}

	return users;
    }

    @Override
    public List<Order> getOrders() throws DaoException {
	List<Order> orders = new ArrayList<>();

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	try {
	    con = pool.getConnection();
	    st = con.prepareStatement(QUERY_GET_ALL_ORDERS);
	    rs = st.executeQuery();

	    Order order = null;

	    while (rs.next()) {

		int orderId = rs.getInt("idOrder");

		if (order == null || order.getId() != orderId) {
		    order = new Order();
		    order.setId(orderId);
		    User user = createUser(rs);
		    order.setCustomer(user);
		}

		Prescription prescription = createPrescription(rs);

		if (!order.getPrescriptions().contains(prescription)) {
		    order.getPrescriptions().add(prescription);
		}

		Medicine medicine = createMedicine(rs);

		if (!order.getPurchasedMedications().contains(medicine)) {
		    int count = rs.getInt("OrdersHasMedicines_count");
		    while (count > 0) {
			order.getPurchasedMedications().add(medicine);
			count--;
		    }
		}

	    }
	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(rs, st, con);
	}

	return orders;
    }

    private User createUser(ResultSet rs) throws SQLException {
	User user = new User();

	user.setId(rs.getInt("idUser"));
	user.setEmail(rs.getString("user_email"));
	user.setFirstName(rs.getString("user_firstName"));
	user.setSecondName(rs.getString("user_secondName"));
	user.setRole(RolesIdentifier.defineByIndex(rs.getInt("Roles_idRole")));

	return user;
    }

    private Prescription createPrescription(ResultSet rs) throws SQLException {
	Prescription prescription = new Prescription();
	prescription.setId(rs.getInt("prescriptions_idPrescription"));
	return prescription;
    }

    private Medicine createMedicine(ResultSet rs) throws SQLException {
	Medicine medicine = new Medicine();
	medicine.setId(rs.getInt("Medicines_idMedicine"));
	medicine.setName(rs.getString("medicine_name"));
	return medicine;
    }

    @Override
    public List<Medicine> getMedicines() throws DaoException {
	List<Medicine> medicines = new ArrayList<>();

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	try {
	    con = pool.getConnection();
	    st = con.prepareStatement(QUERY_GET_ALL_MEDICINES);
	    rs = st.executeQuery();

	    while (rs.next()) {
		Medicine medicine = new Medicine();
		medicine.setId(rs.getInt("idMedicine"));
		medicine.setName(rs.getString("medicine_name"));
		medicine.setType(rs.getString("medicine_type"));
		medicine.setDescription(rs.getString("medicine_description"));
		medicine.setDosage(rs.getString("medicine_dosage"));

		int needRecipe = rs.getInt("medicine_isNeedPrescription");

		if (needRecipe == 0) {
		    medicine.setNeedPrescription(false);
		} else {
		    medicine.setNeedPrescription(true);
		}

		medicines.add(medicine);
	    }
	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(rs, st, con);
	}

	return medicines;
    }

    @Override
    public List<RequestedPrescription> getRequestedPrescriptions() throws DaoException {
	List<RequestedPrescription> requestedPrescriptons = new ArrayList<>();

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	try {
	    con = pool.getConnection();
	    st = con.prepareStatement(QUERY_GET_ALL_REQUESTED_PRESCRIPTIONS);
	    rs = st.executeQuery();

	    while (rs.next()) {
		RequestedPrescription requestedPrescription = new RequestedPrescription();

		requestedPrescription.setId(rs.getInt("Prescriptions_idPrescription"));
		requestedPrescription.setUserFirstName(rs.getString("user_firstName"));
		requestedPrescription.setUserSecondName(rs.getString("user_secondName"));
		requestedPrescription.setMedicineName(rs.getString("medicine_name"));

		requestedPrescriptons.add(requestedPrescription);
	    }
	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(rs, st, con);
	}

	return requestedPrescriptons;
    }

}
