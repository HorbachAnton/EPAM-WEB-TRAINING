package by.horant.fintask.dao;

import java.util.List;

import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.User;

/**
 * The user of this interface undertakes to implement interaction with the
 * database through the implementation of a functional for working with objects
 * of the order type. includes such features (methods) as checking the
 * availability of all necessary prescriptions for drugs included in this order,
 * adding an order to the database and order completion.
 * 
 * @author Anton Horbach
 *
 */
public interface OrderDAO {

    /**
     * Checks the availability of all necessary prescriptions for drugs included in
     * this order.
     * 
     * @param order order which we check for all required recipes.
     * @return a collection of drugs without the appropriate recipes in the order.
     *         If all recipes are present, returns an empty collection.
     * @throws DaoException
     */
    List<Medicine> checkRecipes(Order order) throws DaoException;

    /**
     * Adds an order to the database.
     * 
     * @param user  user in whose name the order is issued.
     * @param order the order we want to add.
     * @return true - if order was added, false - if order wasn't added.
     * @throws DaoException
     */
    boolean addOrder(User user, Order order) throws DaoException;

    /**
     * Completes order.
     * 
     * @param orderId order id that we want to add.
     * @return true - if order was completed, false - if order wasn't completed.
     * @throws DaoException
     */
    boolean completeOrder(int orderId) throws DaoException;

}
