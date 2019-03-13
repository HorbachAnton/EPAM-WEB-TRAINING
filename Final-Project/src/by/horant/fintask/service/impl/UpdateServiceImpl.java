package by.horant.fintask.service.impl;

import by.horant.fintask.dao.DAOProvider;
import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.UpdateUserDao;
import by.horant.fintask.entity.UpdateProfileData;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.UpdateService;

public class UpdateServiceImpl implements UpdateService{

    @Override
    public boolean updateProfile(String email, UpdateProfileData updateData) throws ServiceException {
	
	DAOProvider daoProvider = DAOProvider.getInstance();
	UpdateUserDao updateDAO = daoProvider.getUpdateUserDAO();
	
	boolean result = false;

	try {
	    result = updateDAO.updateProfile(email, updateData);
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}
	
	return result;
    }

    @Override
    public boolean updatePassword(String email, String password) throws ServiceException {
	
	DAOProvider daoProvider = DAOProvider.getInstance();
	UpdateUserDao updateDAO = daoProvider.getUpdateUserDAO();	
	
	boolean result = false;
	
	try {
	    result = updateDAO.updatePassword(email, password);
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}
	
	return result;
    }

    @Override
    public boolean updateEmail(String newEmail, String oldEmail) throws ServiceException {

	DAOProvider daoProvider = DAOProvider.getInstance();
	UpdateUserDao updateDAO = daoProvider.getUpdateUserDAO();
	
	boolean result = false;
	try {
	    result = updateDAO.updateEmail(newEmail, oldEmail);
	}catch (DaoException e) {
	    throw new ServiceException(e);
	}
	
	return result;
    }

}
