package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.User;
import by.horant.fintask.service.OrderService;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.ServiceProvider;

/**
 * The AddOrderCommand class implements the Command interface and adds a new
 * order to the database.
 * 
 * @author Anton Horbach
 *
 */
public class AddOrderCommand implements Command {

    Command goUserPage = new GoToUserPageCommand();

    private static final Logger logger = LogManager.getLogger(AddOrderCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Could not add order.";

    private static final String ERROR_SERVICE_EXCEPTION_NAME = "error";
    private static final String ERROR_SERVICE_EXCEPTION_MESSAGE = "Could not add order.";

    /**
     * Adds a new order to the database.
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	Order order = (Order) request.getSession().getAttribute("order");
	User customer = (User) request.getSession().getAttribute("user");

	ServiceProvider serviceProvider = ServiceProvider.getInstance();
	OrderService orderService = serviceProvider.getOrderService();

	try {
	    orderService.addOrder(customer, order);
	    goUserPage.execute(request, response);
	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	    request.setAttribute(ERROR_SERVICE_EXCEPTION_NAME, ERROR_SERVICE_EXCEPTION_MESSAGE);
	    goUserPage.execute(request, response);
	}

    }

}
