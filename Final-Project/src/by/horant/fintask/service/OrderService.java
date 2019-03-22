package by.horant.fintask.service;

import java.util.List;

import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.Prescription;
import by.horant.fintask.entity.User;

public interface OrderService {

    List<Medicine> checkRecipes(Order order) throws ServiceException;

    void deleteMedicine(List<Medicine> orderedMedicine, int deletedMedicineId);
    
    void deleteMedicinesWithoutPrescription(List<Medicine> medicinesWithoutPrescription, Order order);

    void deleteMedicinesPrescription(List<Prescription> prescriptions, int deletedMedicineId);

    boolean addOrder(User user, Order order) throws ServiceException;
    
    boolean completeOrder(int orderId) throws ServiceException;
}
