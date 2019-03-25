package by.horant.fintask.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.UserDAO;
import by.horant.fintask.dao.util.RolesIdentifier;
import by.horant.fintask.dao.util.ShutterDao;
import by.horant.fintask.entity.RegistrationData;
import by.horant.fintask.entity.User;
import by.horant.fintask.entity.enumeration.Roles;

/**
 * This class is an implementation of the UserDAO interface and thus provides
 * interaction with the MySQL database implementing such methods as
 * authorization and registration. Authorization involves searching for a user
 * in the database based on the password and mailbox sent, as well as creating
 * and returning the object that encapsulates this user. Registration implies
 * the transfer of a RegistrationData class object as a parameter and entering
 * all user information into the database.
 * 
 * @author Anton Horbach
 *
 */
public class SQLUserDao implements UserDAO {

    private static final String QUERY_CHECK_CREDENTIONALS = "SELECT * FROM users WHERE user_email=?";
    private static final String QUERY_REGISTRATION_USER = "INSERT INTO  users (`user_email`, `user_password`, `Roles_idRole`) VALUES (?, ?, ?)";

    private static final String COLUMN_USER_ID_NAME = "idUser";
    private static final String COLUMN_USER_EMAIL_NAME = "user_email";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

    /**
     * The method of user authorization in the systems. It returns an object of
     * authorized user.
     */
    @Override
    public User authentification(String userEmail, String userPassword) throws DaoException {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	User user = null;

	try {
	    con = pool.getConnection();
	    st = con.prepareStatement(QUERY_CHECK_CREDENTIONALS);

	    String hashedPassword = BCrypt.hashpw(userPassword, BCrypt.gensalt(12));

	    st.setString(1, userEmail);

	    rs = st.executeQuery();

	    if (rs.next() && BCrypt.checkpw(userPassword, hashedPassword)) {
		user = createUser(rs);
	    }
	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(rs, st, con);
	}

	return user;
    }

    /**
     * The method of user registration in the system. It returns an object of
     * registered user.
     */
    @Override
    public boolean registration(RegistrationData userData) throws DaoException {

	Connection con = null;
	PreparedStatement st = null;

	boolean result = false;

	try {
	    con = pool.getConnection();
	    st = con.prepareStatement(QUERY_REGISTRATION_USER);

	    String hashedPassword = BCrypt.hashpw(userData.getPassword(), BCrypt.gensalt());

	    st.setString(1, userData.getEmail());
	    st.setString(2, hashedPassword);
	    st.setInt(3, userData.getRole().getIdentifier());

	    st.executeUpdate();

	    result = true;

	} catch (SQLException e) {
	    throw new DaoException(e);
	} finally {
	    ShutterDao.close(st, con);
	}

	return result;
    }

    /**
     * Creates and returns user object.
     * 
     * @param rs object that implement interface ResultSet.
     * @return user object.
     * @throws SQLException
     */
    private User createUser(ResultSet rs) throws SQLException {
	User user = new User();

	user.setId(rs.getInt(COLUMN_USER_ID_NAME));
	user.setEmail(rs.getString(COLUMN_USER_EMAIL_NAME));
	user.setPassword(rs.getString("user_password"));
	user.setFirstName(rs.getString("user_firstName"));
	user.setSecondName(rs.getString("user_secondName"));
	user.setRole(defineRole(rs.getInt("Roles_idRole")));

	return user;
    }

    /**
     * Defines user role by identifier.
     * 
     * @param identifier integer role identifier.
     * @return user role.
     */
    private Roles defineRole(int identifier) {
	return RolesIdentifier.defineByIndex(identifier);
    }

}
