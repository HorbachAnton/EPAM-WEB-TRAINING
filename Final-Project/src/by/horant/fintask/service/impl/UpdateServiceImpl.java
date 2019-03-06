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
    public boolean updatePassword() {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean updateEmail() {
	// TODO Auto-generated method stub
	return false;
    }

}
