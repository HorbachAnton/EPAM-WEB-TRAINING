package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.controller.command.util.CreatorFullURL;

/**
 * The GoToRegistrationCommand class implements the Command interface and
 * represents the command to forward the user to the page of the registration.
 * 
 * @author Anton Horbach
 *
 */
public class GoToRegistrationCommand implements Command {

    private static final String ATTRIBUTE_PREV_REQUEST_NAME = "prev_request";

    private static final String REGISTRATIION_PAGE_PATH = "/WEB-INF/jsp/registration.jsp";

    /**
     * Forwards the user to the page of the registration.
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String url = CreatorFullURL.create(request);
	request.getSession(true).setAttribute(ATTRIBUTE_PREV_REQUEST_NAME, url);

	RequestDispatcher dispatcher = request.getRequestDispatcher(REGISTRATIION_PAGE_PATH);
	dispatcher.forward(request, response);
    }

}
