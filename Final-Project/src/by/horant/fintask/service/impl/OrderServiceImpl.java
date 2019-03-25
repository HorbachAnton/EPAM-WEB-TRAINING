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

/**
 * This class is an implementation of the OrderService interface and thus
 * provides interaction with the order. It includes such opportunities (methods)
 * as checking the availability of all necessary prescriptions for drugs
 * included in this order, removing drugs from an order, removing drugs without
 * the necessary prescriptions for purchasing them, deleting a prescription for
 * the appropriate drug, adding an order to the database and completing an
 * order.
 * 
 * @author Anton Horbach
 *
 */
public class OrderServiceImpl implements OrderService {

    /**
     * Checks the availability of all necessary prescriptions for drugs included in
     * this order
     */
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

    /**
     * Removes drugs from an order.
     */
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

    /**
     * Removes drugs without the necessary prescriptions for purchasing them.
     */
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

    /**
     * Removes a prescription for the appropriate drug.
     */
    @Override
    public void deleteMedicinesWithoutPrescription(List<Medicine> medicinesWithoutPrescription, Order order) {
	List<Medicine> purchasedMedicine = order.getPurchasedMedications();
	purchasedMedicine.removeAll(medicinesWithoutPrescription);
    }

    /**
     * Adds an order to the database
     */
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

    /**
     * Completes order.
     */
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
