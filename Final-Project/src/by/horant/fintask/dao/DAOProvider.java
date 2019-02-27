package by.horant.fintask.dao;

import by.horant.fintask.dao.impl.SQLUserDao;

public class DAOProvider {

    private final UserDAO userDAO = new SQLUserDao();

    private DAOProvider() {

    }

    private static class DAOProviderHolder {
	private static final DAOProvider instance = new DAOProvider();
    }

    public static DAOProvider getInstance() {
	return DAOProviderHolder.instance;
    }

    protected Object readResolve() {
	return getInstance();
    }

    public UserDAO getUserDAO() {
	return userDAO;
    }

}
