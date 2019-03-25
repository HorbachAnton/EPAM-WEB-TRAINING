package by.horant.fintask.service;

import java.util.List;

import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.RequestedPrescription;
import by.horant.fintask.entity.User;

/**
 * The user of this interface undertakes to implement interaction with several
 * types of entity classes, implementing such methods as obtaining users,
 * receiving orders, receiving medicines and obtaining the requested
 * prescriptions.
 * 
 * @author Anton Horbach
 *
 */
public interface DataService {

    /**
     * Returns users list.
     * 
     * @return users list.
     * @throws ServiceException
     */
    List<User> getUsers() throws ServiceException;

    /**
     * Returns orders list.
     * 
     * @return orders list.
     * @throws ServiceException
     */
    List<Order> getOrders() throws ServiceException;

    /**
     * Returns medicines list.
     * 
     * @return medicines list.
     * @throws ServiceException
     */
    List<Medicine> getMedicines() throws ServiceException;

    /**
     * Returns requested prescriptions list.
     * 
     * @return requested prescriptions list.
     * @throws ServiceException
     */
    List<RequestedPrescription> getRequestedPrescriptions() throws ServiceException;

}
