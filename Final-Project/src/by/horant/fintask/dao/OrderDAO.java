package by.horant.fintask.dao;

import java.util.List;

import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.User;

public interface OrderDAO {

    List<Medicine> checkRecipes(Order order) throws DaoException;

    boolean addOrder(User user, Order order) throws DaoException;

}
