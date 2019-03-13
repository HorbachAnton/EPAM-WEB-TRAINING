package by.horant.fintask.dao;

import by.horant.fintask.dao.impl.SQLDataDao;
import by.horant.fintask.dao.impl.SQLOrderDao;
import by.horant.fintask.dao.impl.SQLPrescriptionDao;
import by.horant.fintask.dao.impl.SQLUpdateUserDao;
import by.horant.fintask.dao.impl.SQLUserDao;

public class DAOProvider {

    private final UserDAO userDAO = new SQLUserDao();
    private final UpdateUserDao updateDAO = new SQLUpdateUserDao();
    private final DataDAO dataDAO = new SQLDataDao();
    private final OrderDAO orderDAO = new SQLOrderDao();
    private final PrescriptionDAO prescriptionDAO = new SQLPrescriptionDao();

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

    public DataDAO getDataDAO() {
	return dataDAO;

    }

    public OrderDAO getOrderDAO() {
	return orderDAO;
    }

    public PrescriptionDAO getPrescriptionDAO() {
	return prescriptionDAO;
    }

}
