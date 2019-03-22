package by.horant.fintask.service.impl;

import java.util.List;

import by.horant.fintask.dao.DAOProvider;
import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.DataDAO;
import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.RequestedPrescription;
import by.horant.fintask.entity.User;
import by.horant.fintask.service.DataService;
import by.horant.fintask.service.ServiceException;

public class DataServiceImpl implements DataService {

    @Override
    public List<User> getUsers() throws ServiceException {

	DAOProvider daoProvider = DAOProvider.getInstance();
	DataDAO dataDao = daoProvider.getDataDAO();

	List<User> users = null;

	try {
	    users = dataDao.getUsers();
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}

	return users;
    }

    @Override
    public List<Order> getOrders() throws ServiceException {

	DAOProvider daoProvider = DAOProvider.getInstance();
	DataDAO dataDao = daoProvider.getDataDAO();

	List<Order> orders = null;

	try {
	    orders = dataDao.getOrders();
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}

	return orders;
    }

    @Override
    public List<Medicine> getMedicines() throws ServiceException {

	DAOProvider daoProvider = DAOProvider.getInstance();
	DataDAO dataDao = daoProvider.getDataDAO();

	List<Medicine> medicines = null;

	try {
	    medicines = dataDao.getMedicines();
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}

	return medicines;
    }

    @Override
    public List<RequestedPrescription> getRequestedPrescriptions() throws ServiceException {

	DAOProvider daoProvider = DAOProvider.getInstance();
	DataDAO dataDao = daoProvider.getDataDAO();

	List<RequestedPrescription> requestedPrescriptions = null;

	try {
	    requestedPrescriptions = dataDao.getRequestedPrescriptions();
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}

	return requestedPrescriptions;
    }

}
