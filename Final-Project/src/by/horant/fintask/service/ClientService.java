package by.horant.fintask.service;

import by.horant.fintask.entity.RegistrationData;
import by.horant.fintask.entity.User;

/**
 * The user of this interface undertakes to implement client interaction with
 * the application by implementing such methods as authorization and
 * registration. Authorization implies passing as login and password parameters.
 * Registration implies passing an object of the RegistrationData class as a
 * parameter.
 * 
 * @author Anton Horbach
 *
 */
public interface ClientService {

    /**
     * The method of user authorization in the system. It returns an object of
     * authorized user.
     * 
     * @param userEmail    user email using for authorization in the system.
     * @param userPassword user password using for authorization in the system.
     * @return an object of authorized user.
     * @throws ServiceException
     */
    User authorization(String userEmail, String userPassword) throws ServiceException;

    /**
     * The method of user registration in the system. It returns an object of
     * registered user.
     * 
     * @param userData an object of the RegistrationData class, which includes data
     *                 from registration form.
     * @return an object of registered user.
     * @throws ServiceException
     */
    User registration(RegistrationData userData) throws ServiceException;

}
