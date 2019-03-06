package by.horant.fintask.dao;

import by.horant.fintask.dao.impl.SQLDataDao;
import by.horant.fintask.dao.impl.SQLUpdateUserDao;
import by.horant.fintask.dao.impl.SQLUserDao;

public class DAOProvider {

    private final UserDAO userDAO = new SQLUserDao();
    private final UpdateUserDao updateDAO = new SQLUpdateUserDao();
    private final DataDAO dataDAO = new SQLDataDao();

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

    public UpdateUserDao getUpdateUserDAO() {
	return updateDAO;
    }
    
    public DataDAO detDataDao() {
	return dataDAO;
	
    }

}
