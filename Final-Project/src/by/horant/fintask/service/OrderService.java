package by.horant.fintask.service;

import java.util.List;

import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;

public interface OrderService {

    List<Medicine> checkRecipes(Order order) throws ServiceException;

}
