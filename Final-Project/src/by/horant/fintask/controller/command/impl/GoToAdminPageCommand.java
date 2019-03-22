package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.controller.command.util.CreatorFullURL;

/**
 * 
 * @author y50-70
 *
 */
public class GoToAdminPageCommand implements Command {

    private static final String ADMIN_MAIN_PAGE = "/WEB-INF/jsp/admin_page.jsp";

    private static final String ATTRIBUTE_PREV_REQUEST_NAME = "prev_request";

    /**
     * 
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String url = CreatorFullURL.create(request);
	request.getSession(true).setAttribute(ATTRIBUTE_PREV_REQUEST_NAME, url);

	RequestDispatcher dispatcher = request.getRequestDispatcher(ADMIN_MAIN_PAGE);
	dispatcher.forward(request, response);
    }

}
