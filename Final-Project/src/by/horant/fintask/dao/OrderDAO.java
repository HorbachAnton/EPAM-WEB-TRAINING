package by.horant.fintask.dao;

import java.util.List;

import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;

public interface OrderDAO {

    List<Medicine> checkRecipes(Order order) throws DaoException;

}
