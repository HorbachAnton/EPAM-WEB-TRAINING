package by.horant.fintask.dao;

import by.horant.fintask.entity.RegistrationData;
import by.horant.fintask.entity.User;

/**
 * The user of this interface undertakes to implement interaction with the
 * database, implementing such methods as authorization and registration.
 * Authorization involves searching for a user in the database based on the
 * password and mailbox sent, as well as creating and returning the object that
 * encapsulates this user. Registration implies the transfer of a
 * RegistrationData class object as a parameter and entering all user
 * information into the database.
 * 
 * @author Anton Horbach
 *
 */
public interface UserDAO {

    /**
     * The method of user authorization in the systems. It returns an object of
     * authorized user.
     * 
     * @param userEmail    user email using for authorization in the system.
     * @param userPassword user password using for authorization in the system.
     * @return an object of authorized user.
     * @throws DaoException
     */
    User authentification(String userEmail, String userPassword) throws DaoException;

    /**
     * The method of user registration in the system. It returns an object of
     * registered user.
     * 
     * @param userData an object of the RegistrationData class, which includes data
     *                 from registration form.
     * @return an object of registered user.
     * @throws DaoException
     */
    boolean registration(RegistrationData userData) throws DaoException;

}
