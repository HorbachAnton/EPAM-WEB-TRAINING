package by.horant.fintask.service.impl;

import java.util.Iterator;
import java.util.List;

import by.horant.fintask.dao.DAOProvider;
import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.OrderDAO;
import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.Prescription;
import by.horant.fintask.entity.User;
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

    @Override
    public void deleteMedicine(List<Medicine> orderedMedicine, int deletedMedicineId) {
	Iterator<Medicine> iterator = orderedMedicine.iterator();
	Medicine medicine = null;

	while (iterator.hasNext()) {
	    medicine = iterator.next();
	    if (medicine.getId() == deletedMedicineId) {
		iterator.remove();
		break;
	    }
	}
    }

    @Override
    public void deleteMedicinesPrescription(List<Prescription> prescriptions, int deletedMedicineId) {
	Iterator<Prescription> iterator = prescriptions.iterator();
	Prescription prescription = null;

	while (iterator.hasNext()) {
	    prescription = iterator.next();
	    if (prescription.getPrescribedMedication().getId() == deletedMedicineId) {
		iterator.remove();
		break;
	    }
	}
    }

    @Override
    public void deleteMedicinesWithoutPrescription(List<Medicine> medicinesWithoutPrescription, Order order) {
	List<Medicine> purchasedMedicine = order.getPurchasedMedications();

	for (Medicine medicine : medicinesWithoutPrescription) {
	    purchasedMedicine.remove(medicine);
	}

    }

    @Override
    public boolean addOrder(User user, Order order) throws ServiceException {
	boolean result = false;

	DAOProvider daoProvider = DAOProvider.getInstance();
	OrderDAO orderDao = daoProvider.getOrderDAO();

	try {
	    result = orderDao.addOrder(user, order);
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}

	return result;
    }

    @Override
    public boolean completeOrder(int orderId) throws ServiceException {
	boolean result = false;

	DAOProvider daoProvider = DAOProvider.getInstance();
	OrderDAO orderDao = daoProvider.getOrderDAO();

	try {
	    result = orderDao.completeOrder(orderId);
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}

	return result;
    }

}
