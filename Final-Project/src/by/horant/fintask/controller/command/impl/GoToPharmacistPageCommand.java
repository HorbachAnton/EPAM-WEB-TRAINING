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
import by.horant.fintask.entity.RequestedPrescription;
import by.horant.fintask.service.DataService;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.ServiceProvider;

public class GoToPharmacistPageCommand implements Command {

    private static final Logger logger = LogManager.getLogger(GoToPharmacistPageCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Can't find any requested prescription.";

    private static final String ATTRIBUTE_REQUESTED_PRESCRIPTIONS_NAME = "listPrescriptions";
    private static final String ATTRIBUTE_PREV_REQUEST_NAME = "prev_request";
    private static final String ATTRIBUTE_PAGES_NUMBER_NAME = "pages_number";

    private static final String PHARMACIST_MAIN_PAGE = "/WEB-INF/jsp/pharmacist_page.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	ServiceProvider provider = ServiceProvider.getInstance();
	DataService dataService = provider.getDataService();

	try {
	    List<RequestedPrescription> requestedPrescriptons = dataService.getRequestedPrescriptions();
	    request.setAttribute(ATTRIBUTE_REQUESTED_PRESCRIPTIONS_NAME, requestedPrescriptons);
	    request.setAttribute(ATTRIBUTE_PAGES_NUMBER_NAME, requestedPrescriptons.size() / 6);
	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	}

	String url = CreatorFullURL.create(request);
	request.getSession(true).setAttribute(ATTRIBUTE_PREV_REQUEST_NAME, url);

	RequestDispatcher dispatcher = request.getRequestDispatcher(PHARMACIST_MAIN_PAGE);
	dispatcher.forward(request, response);
    }

}
