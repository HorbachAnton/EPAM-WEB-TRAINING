package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.controller.command.util.CreatorFullURL;

public class GoToUpdateProfilePageCommand implements Command{
    
    private static final String ATTRIBUTE_PREV_REQUEST_NAME = "prev_request";
    private static final String UPDATE_PAGE = "/WEB-INF/jsp/update_profile.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String url = CreatorFullURL.create(request);
	request.getSession(true).setAttribute(ATTRIBUTE_PREV_REQUEST_NAME, url);

	RequestDispatcher dispatcher = request.getRequestDispatcher(UPDATE_PAGE);
	dispatcher.forward(request, response);	
    }

}
