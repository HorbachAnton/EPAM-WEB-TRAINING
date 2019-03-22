package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.service.OrderService;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.ServiceProvider;

public class CompleteOrderCommand implements Command {
    
    private static final Logger logger = LogManager.getLogger(CompleteOrderCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Could not complete order.";

    Command goPharmacistPage = new GoToPharmacistPageCommand();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int orderId = Integer.parseInt(request.getParameter("id_order"));

	ServiceProvider serviceProvider = ServiceProvider.getInstance();
	OrderService orderService = serviceProvider.getOrderService();

	try {
	    orderService.completeOrder(orderId);
	    goPharmacistPage.execute(request, response);
	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	}
    }

}
