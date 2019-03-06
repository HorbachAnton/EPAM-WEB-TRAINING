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

public class SQLUserDao implements UserDAO {

    private static final String QUERY_CHECK_CREDENTIONALS = "SELECT * FROM users WHERE user_email=?";
    private static final String QUERY_REGISTRATION_USER = "INSERT INTO  users (`user_email`, `user_password`, `Roles_idRole`) VALUES (?, ?, ?)";

    private static final ConnectionPool pool = ConnectionPool.getInstance();

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

    private User createUser(ResultSet rs) throws SQLException {
	User user = new User();

	user.setId(rs.getInt("idUser"));
	user.setEmail(rs.getString("user_email"));
	user.setPassword(rs.getString("user_password"));
	user.setFirstName(rs.getString("user_firstName"));
	user.setSecondName(rs.getString("user_secondName"));
	user.setRole(defineRole(rs.getInt("Roles_idRole")));

	return user;
    }

    private Roles defineRole(int identifier) {
	return RolesIdentifier.defineByIndex(identifier);
    }

}
