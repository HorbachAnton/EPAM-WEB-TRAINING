package by.horant.fintask.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.controller.command.util.CreatorFullURL;
import by.horant.fintask.entity.Order;
import by.horant.fintask.service.DataService;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.ServiceProvider;

/**
 * The GoToPharmacistPageCommand class implements the Command interface and
 * represents the command to forward the user to the page of the pharmacist.
 * 
 * @author Anton Horbach
 *
 */
public class GoToPharmacistPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger(GoToPharmacistPageCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Can't find any orders.";

    private static final String ATTRIBUTE_LIST_ORDERS_NAME = "listOrders";
    private static final String ATTRIBUTE_PAGES_NUMBER_NAME = "pages_number";
    private static final String ATTRIBUTE_PREV_REQUEST_NAME = "prev_request";

    private static final String PHARMACIST_MAIN_PAGE = "/WEB-INF/jsp/pharmacist_page.jsp";

    /**
     * Forward the user to the page of the pharmacist.
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	ServiceProvider provider = ServiceProvider.getInstance();
	DataService dataService = provider.getDataService();

	try {
	    List<Order> orders = dataService.getOrders();
	    request.setAttribute(ATTRIBUTE_LIST_ORDERS_NAME, orders);
	    request.setAttribute(ATTRIBUTE_PAGES_NUMBER_NAME, orders.size() / 6);
	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	}

	String url = CreatorFullURL.create(request);
	request.getSession(true).setAttribute(ATTRIBUTE_PREV_REQUEST_NAME, url);

	RequestDispatcher dispatcher = request.getRequestDispatcher(PHARMACIST_MAIN_PAGE);
	dispatcher.forward(request, response);

    }

}
