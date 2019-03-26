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
import by.horant.fintask.entity.MedicationWithoutRecipes;
import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.service.OrderService;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.ServiceProvider;

/**
 * The GoToOrderPageCommand class implements the Command interface and
 * represents the command to forward the user to the page of the order.
 * 
 * @author Anton Horbach
 *
 */
public class GoToOrderPageCommand implements Command {

    private static final Logger logger = LogManager.getLogger(GoToOrderPageCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Could not check recipes.";

    private static final String ATTRIBUTE_PREV_REQUEST_NAME = "prev_request";

    private static final String ORDER_PAGE_PATH = "/WEB-INF/jsp/order.jsp";

    private static final String ERROR_SERVICE_EXCEPTION_NAME = "error";
    private static final String ERROR_SERVICE_EXCEPTION_MESSAGE = "An error has occurred";

    private Command goUserPage = new GoToUserPageCommand();
    private Command goUnapprovedOrderPage = new GoToUnapprovedOrderPageCommand();

    /**
     * Forwards the user to the page of the order
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<Medicine> medicationWithoutRecipes = null;

	Order order = (Order) request.getSession().getAttribute("order");

	ServiceProvider provider = ServiceProvider.getInstance();
	OrderService service = provider.getOrderService();
	try {
	    medicationWithoutRecipes = service.checkRecipes(order);
	    MedicationWithoutRecipes medicationContainer = new MedicationWithoutRecipes(medicationWithoutRecipes);

	    if (medicationWithoutRecipes.isEmpty()) {
		String url = CreatorFullURL.create(request);
		request.getSession(true).setAttribute(ATTRIBUTE_PREV_REQUEST_NAME, url);

		RequestDispatcher dispatcher = request.getRequestDispatcher(ORDER_PAGE_PATH);
		dispatcher.forward(request, response);
	    } else {
		request.getSession().setAttribute("medication_without_recipes", medicationContainer);
		goUnapprovedOrderPage.execute(request, response);
	    }

	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	    request.setAttribute(ERROR_SERVICE_EXCEPTION_NAME, ERROR_SERVICE_EXCEPTION_MESSAGE);
	    goUserPage.execute(request, response);
	}

    }

}
