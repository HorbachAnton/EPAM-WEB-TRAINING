package by.horant.fintask.dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShutterDao {

    private static final Logger logger = LogManager.getLogger(ShutterDao.class);

    private ShutterDao() {

    }

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
