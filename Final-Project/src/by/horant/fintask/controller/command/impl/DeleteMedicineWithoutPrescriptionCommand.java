package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.controller.command.util.CreatorFullURL;
import by.horant.fintask.entity.MedicationWithoutRecipes;
import by.horant.fintask.entity.Order;
import by.horant.fintask.service.OrderService;
import by.horant.fintask.service.ServiceProvider;

/**
 * 
 * @author y50-70
 *
 */
public class DeleteMedicineWithoutPrescriptionCommand implements Command {

    private static final String ATTRIBUTE_PREV_REQUEST_NAME = "prev_request";
    private static final String ATTRIBUTE_MEDICINE_WITHOUT_RECIPES = "medication_without_recipes";

    private static final String ORDER_PAGE_PATH = "/WEB-INF/jsp/order.jsp";

    /**
     * 
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Order order = (Order) request.getSession().getAttribute("order");
	MedicationWithoutRecipes medicinesWithoutPrescription = (MedicationWithoutRecipes) request.getSession()
		.getAttribute(ATTRIBUTE_MEDICINE_WITHOUT_RECIPES);

	ServiceProvider serviceProvider = ServiceProvider.getInstance();
	OrderService orderService = serviceProvider.getOrderService();

	orderService.deleteMedicinesWithoutPrescription(medicinesWithoutPrescription.getMedicinesWithoutRecipes(),
		order);

	String url = CreatorFullURL.create(request);
	request.getSession(true).setAttribute(ATTRIBUTE_PREV_REQUEST_NAME, url);

	RequestDispatcher dispatcher = request.getRequestDispatcher(ORDER_PAGE_PATH);
	dispatcher.forward(request, response);
    }

}
