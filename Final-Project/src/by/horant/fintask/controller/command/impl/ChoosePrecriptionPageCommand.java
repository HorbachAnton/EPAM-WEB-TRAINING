package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.controller.command.util.CreatorFullURL;
import by.horant.fintask.service.DataService;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.ServiceProvider;

/**
 * 
 * @author y50-70
 *
 */
public class ChoosePrecriptionPageCommand implements Command {

    private static final Logger logger = LogManager.getLogger(ChoosePrecriptionPageCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Can't find any requested prescription.";

    private static final String PARAMETER_CHOOSED_PAGE_NAME = "choosed_page";

    private static final String ATTRIBUTE_PREV_REQUEST_NAME = "prev_request";
    private static final String ATTRIBUTE_LIST_PRESCRIPTIONS_NAME = "listPrescriptions";
    private static final String ATTRIBUTE_FIRST_PRECRIPTION_NAME = "first_prescription";
    private static final String ATTRIBUTE_LAST_PRESCRIPTION_NAME = "last_prescription";
    private static final String ATTRIBUTE_PAGES_NUMBER_NAME = "pages_number";

    private static final String DOCTOR_MAIN_PAGE = "/WEB-INF/jsp/doctor_page.jsp";

    private static final int PRESCRIPTIONS_NUMBER_ON_PAGE = 6;
    private static final int SUBTRAHEND_LAST_PRESCRIPTION = 1;

    /**
     * 
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int pagesNumber = Integer.parseInt(request.getParameter(PARAMETER_CHOOSED_PAGE_NAME));

	int number = pagesNumber * PRESCRIPTIONS_NUMBER_ON_PAGE;
	int firstNumber = number - PRESCRIPTIONS_NUMBER_ON_PAGE;
	int lastNumber = number - SUBTRAHEND_LAST_PRESCRIPTION;

	request.setAttribute(ATTRIBUTE_FIRST_PRECRIPTION_NAME, firstNumber);
	request.setAttribute(ATTRIBUTE_LAST_PRESCRIPTION_NAME, lastNumber);

	if (pagesNumber != 1) {
	    request.setAttribute(ATTRIBUTE_PAGES_NUMBER_NAME, pagesNumber - 1);
	} else {
	    request.setAttribute(ATTRIBUTE_PAGES_NUMBER_NAME, pagesNumber);
	}

	ServiceProvider provider = ServiceProvider.getInstance();
	DataService dataService = provider.getDataService();

	try {
	    request.setAttribute(ATTRIBUTE_LIST_PRESCRIPTIONS_NAME, dataService.getRequestedPrescriptions());
	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	}

	String url = CreatorFullURL.create(request);
	request.getSession(true).setAttribute(ATTRIBUTE_PREV_REQUEST_NAME, url);

	RequestDispatcher dispatcher = request.getRequestDispatcher(DOCTOR_MAIN_PAGE);
	dispatcher.forward(request, response);
    }

}
