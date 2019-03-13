package by.horant.fintask.service.impl;

import java.util.List;

import by.horant.fintask.dao.DAOProvider;
import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.OrderDAO;
import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.service.OrderService;
import by.horant.fintask.service.ServiceException;

public class OrderServiceImpl implements OrderService {

    @Override
    public List<Medicine> checkRecipes(Order order) throws ServiceException {
	List<Medicine> medicationWithoutRecipes = null;

	DAOProvider daoProvider = DAOProvider.getInstance();
	OrderDAO orderDao = daoProvider.getOrderDAO();

	try {
	    medicationWithoutRecipes = orderDao.checkRecipes(order);
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}

	return medicationWithoutRecipes;
    }

}
