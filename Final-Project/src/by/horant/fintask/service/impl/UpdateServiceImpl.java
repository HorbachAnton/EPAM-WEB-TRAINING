package by.horant.fintask.service.impl;

import by.horant.fintask.dao.DAOProvider;
import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.UpdateUserDao;
import by.horant.fintask.entity.UpdateProfileData;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.UpdateService;

/**
 * This class is an implementation of the UpdateService interface and thus
 * provides updating user data. These include updating the password, email and
 * personal data (for example, first and second name).
 * 
 * @author Anton Horbach
 *
 */
public class UpdateServiceImpl implements UpdateService {

    /**
     * Updates user profile(for example, first and second name).
     */
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

    /**
     * Updates user password.
     */
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

    /**
     * Updates user email.
     */
    @Override
    public boolean updateEmail(String newEmail, String oldEmail) throws ServiceException {

	DAOProvider daoProvider = DAOProvider.getInstance();
	UpdateUserDao updateDAO = daoProvider.getUpdateUserDAO();

	boolean result = false;
	try {
	    result = updateDAO.updateEmail(newEmail, oldEmail);
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}

	return result;
    }

}
