package by.horant.fintask.dao;

import by.horant.fintask.entity.RegistrationData;
import by.horant.fintask.entity.User;

public interface UserDAO {

    User authentification(String userEmail, String userPassword) throws DaoException;

    boolean registration(RegistrationData userData) throws DaoException;

}
