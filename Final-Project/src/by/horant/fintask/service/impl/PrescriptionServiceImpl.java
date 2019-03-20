package by.horant.fintask.service.impl;

import by.horant.fintask.dao.DAOProvider;
import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.PrescriptionDAO;
import by.horant.fintask.service.PrescriptionService;
import by.horant.fintask.service.ServiceException;

public class PrescriptionServiceImpl implements PrescriptionService {

    @Override
    public boolean requestPrescription(int userId, int medicineId) throws ServiceException {
	boolean result = false;

	DAOProvider daoProvider = DAOProvider.getInstance();
	PrescriptionDAO prescriptionDao = daoProvider.getPrescriptionDAO();

	try {
	    result = prescriptionDao.requestPrescription(userId, medicineId);
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}

	return result;
    }

    @Override
    public boolean approvePrescription(int prescriptionId) throws ServiceException {
	boolean result = false;

	DAOProvider daoProvider = DAOProvider.getInstance();
	PrescriptionDAO prescriptionDao = daoProvider.getPrescriptionDAO();

	try {
	    result = prescriptionDao.approvePrescription(prescriptionId);
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}

	return result;
    }

    @Override
    public boolean unapprovePrescription(int prescriptionId) throws ServiceException {
	boolean result = false;

	DAOProvider daoProvider = DAOProvider.getInstance();
	PrescriptionDAO prescriptionDao = daoProvider.getPrescriptionDAO();

	try {
	    result = prescriptionDao.unapprovePrescription(prescriptionId);
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}

	return result;
    }

}
