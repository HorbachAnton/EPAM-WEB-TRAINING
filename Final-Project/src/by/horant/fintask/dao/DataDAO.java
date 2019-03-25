package by.horant.fintask.dao;

import java.util.List;

import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.RequestedPrescription;
import by.horant.fintask.entity.User;

/**
 * The user of this interface undertakes to implement interaction with the
 * database for obtaining various list of entity objects, implementing such
 * methods as obtaining users, receiving orders, obtaining drugs and obtaining
 * the requested recipes.
 * 
 * @author Anton Horbach
 *
 */
public interface DataDAO {

    /**
     * Returns users list.
     * 
     * @return users list.
     * @throws DaoException
     */
    List<User> getUsers() throws DaoException;

    /**
     * Returns orders list.
     * 
     * @return orders list.
     * @throws DaoException
     */
    List<Order> getOrders() throws DaoException;

    /**
     * Returns medicines list.
     * 
     * @return medicines list.
     * @throws DaoException
     */
    List<Medicine> getMedicines() throws DaoException;

    /**
     * Returns requested prescriptions list.
     * 
     * @return requested prescriptions list.
     * @throws DaoException
     */
    List<RequestedPrescription> getRequestedPrescriptions() throws DaoException;

}
