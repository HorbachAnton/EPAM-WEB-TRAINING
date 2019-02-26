package by.horant.fintask.dao;

import by.horant.fintask.dao.impl.SQLUserDao;

public class DAOProvider {

    private static final DAOProvider instance = new DAOProvider();

    private final UserDAO userDAO = new SQLUserDao();

    private DAOProvider() {
    }

    public static DAOProvider getInstance() {
	return instance;
    }

    public UserDAO getUserDAO() {
	return userDAO;
    }

}
