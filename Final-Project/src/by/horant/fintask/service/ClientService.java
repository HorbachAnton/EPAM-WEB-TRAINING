package by.horant.fintask.service;

import by.horant.fintask.entity.RegistrationData;
import by.horant.fintask.entity.User;

public interface ClientService {
    
	User authorization(String userLogin, String userPassword) throws ServiceException;
	User registration(RegistrationData userData) throws ServiceException;

}
