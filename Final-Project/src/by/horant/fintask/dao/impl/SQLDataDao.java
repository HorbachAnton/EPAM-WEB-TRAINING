package by.horant.fintask.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.DataDAO;
import by.horant.fintask.dao.util.CompleteOrderIdentifier;
import by.horant.fintask.dao.util.RolesIdentifier;
import by.horant.fintask.dao.util.ShutterDao;
import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.RequestedPrescription;
import by.horant.fintask.entity.User;

/**
 * This class is an implementation of the DataDAO interface and thus provides
 * interaction with the database for obtaining various list of entity objects,
 * implementing such methods as obtaining users, receiving orders, obtaining
 * drugs and obtaining the requested recipes.
 * 
 * @author Anton Horbach
 *
 */
public class SQLDataDao implements DataDAO {

    private static final String QUERY_GET_ALL_USERS = "SELECT * FROM users";
    private static final String QUERY_GET_ALL_ORDERS = "SELECT orders.idOrder, orders.isCompleted, users.user_firstName, users.user_secondName FROM orders INNER JOIN users WHERE orders.Users_idUser = users.idUser";
    private static final String QUERY_GET_ALL_MEDICINES = "SELECT * FROM medicines";
    private static final String QUERY_GET_ALL_REQUESTED_PRESCRIPTIONS = "SELECT b.Prescriptions_idPrescription, b.user_firstName, b.user_secondName, medicines.medicine_name FROM (SELECT a.Prescriptions_idPrescription, users.user_firstName,users.user_secondName, a.Medicines_idMedicine FROM (SELECT prescriptions_has_medicines.*, prescriptions.isApproved FROM prescriptions_has_medicines INNER JOIN prescriptions WHERE prescriptions_has_medicines.Prescriptions_idPrescription = prescriptions.idPrescription AND ISNULL(prescriptions.isApproved) ) as a INNER JOIN users WHERE a.Prescriptions_Users_idUser = users.idUser) as b INNER JOIN medicines WHERE b.Medicines_idMedicine = medicines.idMedicine";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    /**
     * Returns users list.
     */
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

    /**
     * Returns orders list.
     */
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

	    while (rs.next()) {
		Order order = createOrder(rs);
		orders.add(order);
	    }

	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(rs, st, con);
	}

	return orders;
    }

    /**
     * Creates and returns object of Order.
     * 
     * @param rs object that implement interface ResultSet.
     * @return object of Order.
     * @throws SQLException
     */
    private Order createOrder(ResultSet rs) throws SQLException {
	Order order = new Order();

	order.setId(rs.getInt("idOrder"));
	order.setCompleteStage(CompleteOrderIdentifier.defineByIndex(rs.getInt("isCompleted")));
	order.setCustomer(createUser(rs));

	return order;
    }

    /**
     * Creates and returns object of User.
     * 
     * @param rs object that implement interface ResultSet.
     * @return object of User.
     * @throws SQLException
     */
    private User createUser(ResultSet rs) throws SQLException {
	User user = new User();

	user.setFirstName(rs.getString("user_firstName"));
	user.setSecondName(rs.getString("user_secondName"));

	return user;
    }

    /**
     * Returns medicines list.
     */
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

    /**
     * Returns requested prescriptions list.
     */
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
