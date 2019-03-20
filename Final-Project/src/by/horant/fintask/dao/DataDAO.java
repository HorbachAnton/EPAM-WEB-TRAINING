package by.horant.fintask.dao;

import java.util.List;

import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.RequestedPrescription;
import by.horant.fintask.entity.User;

public interface DataDAO {

    List<User> getUsers() throws DaoException;

    List<Order> getOrders() throws DaoException;

    List<Medicine> getMedicines() throws DaoException;
    
    List<RequestedPrescription> getRequestedPrescriptions() throws DaoException;

}
