package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.controller.command.util.CreatorFullURL;
import by.horant.fintask.entity.Order;
import by.horant.fintask.service.OrderService;
import by.horant.fintask.service.ServiceProvider;

public class DeleteOrderedMedicineCommand implements Command {

    private static final String ATTRIBUTE_PREV_REQUEST_NAME = "prev_request";

    private static final String ORDER_PAGE_PATH = "/WEB-INF/jsp/order.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	Order order = (Order) request.getSession().getAttribute("order");

	int deletedMedicineId = Integer.parseInt(request.getParameter("deleted_medicine_id"));

	ServiceProvider serviceProvider = ServiceProvider.getInstance();
	OrderService orderService = serviceProvider.getOrderService();

	orderService.deleteMedicine(order.getPurchasedMedications(), deletedMedicineId);
	orderService.deleteMedicinesPrescription(order.getPrescriptions(), deletedMedicineId);

	request.getSession(false).setAttribute("order", order);

	String url = CreatorFullURL.create(request);
	request.getSession(true).setAttribute(ATTRIBUTE_PREV_REQUEST_NAME, url);

	RequestDispatcher dispatcher = request.getRequestDispatcher(ORDER_PAGE_PATH);
	dispatcher.forward(request, response);
    }

}
