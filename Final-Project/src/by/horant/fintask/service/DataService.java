package by.horant.fintask.service;

import java.util.List;

import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.RequestedPrescription;
import by.horant.fintask.entity.User;

public interface DataService {

    List<User> getUsers() throws ServiceException;

    List<Order> getOrders() throws ServiceException;

    List<Medicine> getMedicines() throws ServiceException;
    
    List<RequestedPrescription> getRequestedPrescriptions() throws ServiceException;

}
