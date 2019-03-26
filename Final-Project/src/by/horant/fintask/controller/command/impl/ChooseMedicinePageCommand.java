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
 * The ChooseMedicinePageCommand class implements the Command interface and
 * determines which next section of drugs to display on the page. The total
 * number of section depends on the number of drugs displayed on the page.
 * 
 * @author Anton Horbach
 *
 */
public class ChooseMedicinePageCommand implements Command {

    private static final Logger logger = LogManager.getLogger(ChooseMedicinePageCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Can't find any medicine.";

    private static final String PARAMETER_CHOOSED_PAGE_NAME = "choosed_page";

    private static final String ATTRIBUTE_PREV_REQUEST_NAME = "prev_request";
    private static final String ATTRIBUTE_LIST_MEDICINES_NAME = "listMedicines";
    private static final String ATTRIBUTE_FIRST_MEDICINES_NAME = "first_medicine";
    private static final String ATTRIBUTE_LAST_MEDICINES_NAME = "last_medicine";
    private static final String ATTRIBUTE_PAGES_NUMBER_NAME = "pages_number";

    private static final String USER_MAIN_PAGE = "/WEB-INF/jsp/user_page.jsp";

    private static final int MEDICINES_NUMBER_ON_PAGE = 6;
    private static final int SUBTRAHEND_LAST_MEDICINE = 1;

    /**
     * Determines which next section of drugs to display on the page.
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int pagesNumber = Integer.parseInt(request.getParameter(PARAMETER_CHOOSED_PAGE_NAME));

	int number = pagesNumber * MEDICINES_NUMBER_ON_PAGE;
	int firstNumber = number - MEDICINES_NUMBER_ON_PAGE;
	int lastNumber = number - SUBTRAHEND_LAST_MEDICINE;

	request.setAttribute(ATTRIBUTE_FIRST_MEDICINES_NAME, firstNumber);
	request.setAttribute(ATTRIBUTE_LAST_MEDICINES_NAME, lastNumber);

	if (pagesNumber != 1) {
	    request.setAttribute(ATTRIBUTE_PAGES_NUMBER_NAME, pagesNumber - 1);
	} else {
	    request.setAttribute(ATTRIBUTE_PAGES_NUMBER_NAME, pagesNumber);
	}

	ServiceProvider provider = ServiceProvider.getInstance();
	DataService dataService = provider.getDataService();

	try {
	    request.setAttribute(ATTRIBUTE_LIST_MEDICINES_NAME, dataService.getMedicines());
	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	}

	String url = CreatorFullURL.create(request);
	request.getSession(true).setAttribute(ATTRIBUTE_PREV_REQUEST_NAME, url);

	RequestDispatcher dispatcher = request.getRequestDispatcher(USER_MAIN_PAGE);
	dispatcher.forward(request, response);
    }
}
