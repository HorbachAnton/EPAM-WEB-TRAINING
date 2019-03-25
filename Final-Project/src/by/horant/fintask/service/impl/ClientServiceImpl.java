package by.horant.fintask.service.impl;

import by.horant.fintask.dao.DAOProvider;
import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.UserDAO;
import by.horant.fintask.entity.RegistrationData;
import by.horant.fintask.entity.User;
import by.horant.fintask.service.ClientService;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.validation.CredentionalValidator;

/**
 * This class is an implementation of the ClientService interface and thus
 * provides client interaction with the application by implementing such methods
 * as authorization and registration.
 * 
 * @author Anton Horbach
 *
 */
public class ClientServiceImpl implements ClientService {

    /**
     * The method of user authorization in the system. It returns an object of
     * authorized user.
     */
    @Override
    public User authorization(String userEmail, String userPassword) throws ServiceException {

	if (!CredentionalValidator.isCorrect(userEmail, userPassword)) {
	    throw new ServiceException("Invalid login or password.");
	}

	DAOProvider daoProvider = DAOProvider.getInstance();
	UserDAO userDAO = daoProvider.getUserDAO();

	User user = null;

	try {
	    user = userDAO.authentification(userEmail, userPassword);
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}

	return user;
    }

    /**
     * The method of user registration in the system. It returns an object of
     * registered user.
     */
    @Override
    public User registration(RegistrationData userData) throws ServiceException {

	if (!CredentionalValidator.isCorrect(userData.getEmail(), userData.getPassword())) {
	    throw new ServiceException("Invalid login or password.");
	}

	DAOProvider daoProvider = DAOProvider.getInstance();
	UserDAO userDAO = daoProvider.getUserDAO();

	User user = null;

	try {
	    if (userDAO.registration(userData)) {
		user = createUser(userData);
	    }
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}

	return user;

    }

    /**
     * Creates user object for registration.
     * 
     * @param userData object of class RegistrationData which encapsulates in itself
     *                 user password, email and role.
     * @return object of class User
     */
    private User createUser(RegistrationData userData) {

	User user = new User();

	user.setEmail(userData.getEmail());
	user.setPassword(userData.getPassword());
	user.setRole(userData.getRole());

	return user;
    }

}
