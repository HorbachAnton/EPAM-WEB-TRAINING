package by.horant.fintask.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.UpdateUserDao;
import by.horant.fintask.dao.util.ShutterDao;
import by.horant.fintask.entity.UpdateProfileData;

public class SQLUpdateUserDao implements UpdateUserDao {

    private static final String QUERY_UPDATE_PROFILE = "UPDATE users SET user_firstName = ?, user_secondName = ? WHERE user_email = ?";
    private static final String QUERY_UPDATE_PASSWORD = "UPDATE users SET user_password = ? WHERE user_email = ?";
    private static final String QUERY_UPDATE_EMAIL = "UPDATE users SET user_email = ? WHERE user_email = ?";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    @Override
    public boolean updateProfile(String email, UpdateProfileData updateData) throws DaoException {
	boolean result = false;

	Connection con = null;
	PreparedStatement st = null;

	try {
	    con = pool.getConnection();
	    st = con.prepareStatement(QUERY_UPDATE_PROFILE);

	    st.setString(1, updateData.getFirstName());
	    st.setString(2, updateData.getSecondName());
	    st.setString(3, email);

	    st.executeUpdate();
	    result = true;

	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(st, con);
	}

	return result;
    }

    @Override
    public boolean updatePassword(String email, String password) throws DaoException {
	boolean result = false;

	Connection con = null;
	PreparedStatement st = null;

	try {
	    con = pool.getConnection();
	    st = con.prepareStatement(QUERY_UPDATE_PASSWORD);

	    String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

	    st.setString(1, hashedPassword);
	    st.setString(2, email);

	    st.executeUpdate();
	    result = true;

	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(st, con);
	}

	return result;
    }

    @Override
    public boolean updateEmail(String newEmail, String oldEmail) throws DaoException {
	boolean result = false;

	Connection con = null;
	PreparedStatement st = null;

	try {
	    con = pool.getConnection();
	    st = con.prepareStatement(QUERY_UPDATE_EMAIL);

	    st.setString(1, newEmail);
	    st.setString(2, oldEmail);

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
