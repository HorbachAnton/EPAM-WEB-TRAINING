package by.horant.fintask.service;

import java.util.List;

import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.RequestedPrescription;
import by.horant.fintask.entity.User;

public interface DataService {

    List<User> getUsers();

    List<Order> getOrders();

    List<Medicine> getMedicines() throws ServiceException;
    
    List<RequestedPrescription> getRequestedPrescriptions() throws ServiceException;

}
