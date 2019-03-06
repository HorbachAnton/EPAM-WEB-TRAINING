package by.horant.fintask.dao;

import java.util.List;

import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.User;

public interface DataDAO {

    List<User> getUsers() throws DaoException;

    List<Order> getOrders();

    List<Medicine> getMedicines() throws DaoException;

}
