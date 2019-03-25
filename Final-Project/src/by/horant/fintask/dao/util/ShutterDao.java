package by.horant.fintask.dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class designed to close transferred to him ResultSet,
 * PreparedStatement and Connection.
 * 
 * @author Anton Horbach
 *
 */
public class ShutterDao {

    private static final Logger logger = LogManager.getLogger(ShutterDao.class);

    /**
     * Class constructor.
     */
    private ShutterDao() {

    }

    /**
     * Closes the objects passed to it that implement such interfaces as ResultSet,
     * PreparedStatement, Connection.
     * 
     * @param rs  object that implement interface ResultSet.
     * @param st  object that implement interface PreparedStatement.
     * @param con object that implement interface Connection.
     */
    public static void close(ResultSet rs, PreparedStatement st, Connection con) {
	try {
	    if (rs != null) {
		rs.close();
	    }
	} catch (SQLException e) {
	    logger.info(e);
	}
	try {
	    if (st != null) {
		st.close();
	    }
	} catch (SQLException e) {
	    logger.info(e);
	}
	try {
	    if (con != null) {
		con.close();
	    }
	} catch (SQLException e) {
	    logger.info(e);
	}
    }

    /**
     * Closes the objects passed to it that implement such interfaces as
     * PreparedStatement and Connection.
     * 
     * @param st  object that implement interface PreparedStatement.
     * @param con object that implement interface Connection.
     */
    public static void close(PreparedStatement st, Connection con) {
	try {
	    if (st != null) {
		st.close();
	    }
	} catch (SQLException e) {
	    logger.info(e);
	}
	try {
	    if (con != null) {
		con.close();
	    }
	} catch (SQLException e) {
	    logger.info(e);
	}
    }

    /**
     * Closes the objects passed to it that implement such interfaces as
     * PreparedStatement and ResultSet.
     * 
     * @param st object that implement interface PreparedStatement.
     * @param rs object that implement interface ResultSet.
     */
    public static void close(PreparedStatement st, ResultSet rs) {
	try {
	    if (rs != null) {
		rs.close();
	    }
	} catch (SQLException e) {
	    logger.info(e);
	}
	try {
	    if (st != null) {
		st.close();
	    }
	} catch (SQLException e) {
	    logger.info(e);
	}
    }

    /**
     * Closes the object that implement interface Connection.
     * 
     * @param st object that implement interface PreparedStatement.
     */
    public static void close(PreparedStatement st) {
	try {
	    if (st != null) {
		st.close();
	    }
	} catch (SQLException e) {
	    logger.info(e);
	}
    }

}
