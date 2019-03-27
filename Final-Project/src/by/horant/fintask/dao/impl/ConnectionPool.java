package by.horant.fintask.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool {

    private static final Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static final String LOGGER_ERROR_MESSAGE = "Failed get connection.";

    private ConnectionPool() {

    }

    private static class ConectionPoolHolder {
	public static final ConnectionPool instance = new ConnectionPool();
    }

    public static ConnectionPool getInstance() {
	return ConectionPoolHolder.instance;
    }

    protected Object readResolve() {
	return getInstance();
    }

    public Connection getConnection() {
	Context ctx = null;
	Connection c = null;
	try {
	    ctx = new InitialContext();
	    DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/fintask");
	    c = ds.getConnection();
	} catch (NamingException | SQLException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	}
	return c;
    }

}