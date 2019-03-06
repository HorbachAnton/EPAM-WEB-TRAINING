package by.horant.fintask.service.impl;

import by.horant.fintask.dao.DAOProvider;
import by.horant.fintask.dao.DaoException;
import by.horant.fintask.dao.UserDAO;
import by.horant.fintask.entity.RegistrationData;
import by.horant.fintask.entity.User;
import by.horant.fintask.service.ClientService;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.validation.CredentionalValidator;

public class ClientServiceImpl implements ClientService {

    @Override
    public User authorization(String userLogin, String userPassword) throws ServiceException {

	if (!CredentionalValidator.isCorrect(userLogin, userPassword)) {
	    throw new ServiceException();
	}

	DAOProvider daoProvider = DAOProvider.getInstance();
	UserDAO userDAO = daoProvider.getUserDAO();

	User user = null;

	try {
	    user = userDAO.authentification(userLogin, userPassword);
	} catch (DaoException e) {
	    throw new ServiceException(e);
	}

	return user;
    }

    @Override
    public User registration(RegistrationData userData) throws ServiceException {

	if (!CredentionalValidator.isCorrect(userData.getEmail(), userData.getPassword())) {
	    throw new ServiceException();
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

    private User createUser(RegistrationData userData) {

	User user = new User();

	user.setEmail(userData.getEmail());
	user.setPassword(userData.getPassword());
	user.setRole(userData.getRole());

	return user;
    }

}
