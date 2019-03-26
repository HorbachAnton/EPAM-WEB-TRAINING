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
import by.horant.fintask.entity.Medicine;
import by.horant.fintask.service.DataService;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.ServiceProvider;

/**
 * The GoToUserPageCommand class implements the Command interface and represents
 * the command to forward the user to the page of the user.
 * 
 * @author Anton Horbach
 *
 */
public class GoToUserPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger(GoToUserPageCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Can't find any medicine.";

    private static final String ATTRIBUTE_PREV_REQUEST_NAME = "prev_request";
    private static final String ATTRIBUTE_LIST_MEDICINES_NAME = "listMedicines";
    private static final String ATTRIBUTE_PAGES_NUMBER_NAME = "pages_number";

    private static final String USER_MAIN_PAGE = "/WEB-INF/jsp/user_page.jsp";

    /**
     * Forwards the user to the page of the user.
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	ServiceProvider provider = ServiceProvider.getInstance();
	DataService dataService = provider.getDataService();

	try {
	    List<Medicine> medicines = dataService.getMedicines();
	    request.setAttribute(ATTRIBUTE_LIST_MEDICINES_NAME, medicines);
	    request.setAttribute(ATTRIBUTE_PAGES_NUMBER_NAME, medicines.size() / 6);
	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	}

	String url = CreatorFullURL.create(request);
	request.getSession(true).setAttribute(ATTRIBUTE_PREV_REQUEST_NAME, url);

	RequestDispatcher dispatcher = request.getRequestDispatcher(USER_MAIN_PAGE);
	dispatcher.forward(request, response);
    }

}
