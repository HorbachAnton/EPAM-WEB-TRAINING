package by.horant.fintask.service;

import java.util.List;

import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.Prescription;
import by.horant.fintask.entity.User;

/**
 * The user of this interface undertakes to implement the service part of the
 * interaction with the order. It includes such opportunities (methods) as
 * checking the availability of all necessary prescriptions for drugs included
 * in this order, removing drugs from an order, removing drugs without the
 * necessary prescriptions for purchasing them, deleting a prescription for the
 * appropriate drug, adding an order to the database and completing an order.
 * 
 * @author Anton Horbach
 *
 */
public interface OrderService {
    /**
     * Checks the availability of all necessary prescriptions for drugs included in
     * this order
     * 
     * @param order which we check for all required recipes.
     * @return a collection of drugs without the appropriate recipes in the order.
     *         If all recipes are present, returns an empty collection.
     * @throws ServiceException
     */
    List<Medicine> checkRecipes(Order order) throws ServiceException;

    /**
     * Removes drugs from an order.
     * 
     * @param orderedMedicine   the list from which you want to remove the medicine.
     * @param deletedMedicineId id medicine that we want to remove.
     */
    void deleteMedicine(List<Medicine> orderedMedicine, int deletedMedicineId);

    /**
     * Removes drugs without the necessary prescriptions for purchasing them.
     * 
     * @param medicinesWithoutPrescription list containing medicines without the
     *                                     necessary prescriptions
     * @param order                        order from which you need to remove drugs
     *                                     without the necessary prescriptions
     */
    void deleteMedicinesWithoutPrescription(List<Medicine> medicinesWithoutPrescription, Order order);

    /**
     * Removes a prescription for the appropriate drug.
     * 
     * @param prescriptions     the recipe list from which we want to delete the
     *                          recipe.
     * @param deletedMedicineId id prescription that we want to remove.
     */
    void deleteMedicinesPrescription(List<Prescription> prescriptions, int deletedMedicineId);

    /**
     * Adds an order to the database
     * 
     * @param user  user in whose name the order is issued.
     * @param order the order we want to add.
     * @return true - if order was added, false - if order wasn't added.
     * @throws ServiceException
     */
    boolean addOrder(User user, Order order) throws ServiceException;

    /**
     * Completes order.
     * 
     * @param orderId order id that we want to add.
     * @return true - if order was completed, false - if order wasn't completed.
     * @throws ServiceException
     */
    boolean completeOrder(int orderId) throws ServiceException;
}
