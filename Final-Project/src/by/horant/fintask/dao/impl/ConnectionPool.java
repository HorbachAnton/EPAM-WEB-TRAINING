package by.horant.fintask.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {

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
	} catch (NamingException e) {
	    e.printStackTrace();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return c;
    }

}