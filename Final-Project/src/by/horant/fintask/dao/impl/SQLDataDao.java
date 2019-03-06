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
import by.horant.fintask.entity.User;

public class SQLDataDao implements DataDAO {

    private static final String QUERY_GET_ALL_USERS = "SELECT * FROM users";
    private static final String QUERY_GET_ALL_ORDERS = "";
    private static final String QUERY_GET_ALL_MEDICINES = "SELECT * FROM medicines";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public List<User> getUsers() throws DaoException {
	List<User> users = new ArrayList<>();
	;

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
    public List<Order> getOrders() {
	return null;
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

}
