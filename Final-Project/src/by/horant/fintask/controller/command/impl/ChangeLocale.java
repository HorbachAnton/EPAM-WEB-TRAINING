package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.horant.fintask.controller.command.Command;

public class ChangeLocale implements Command {

    private static final String PARAMETER_LOCALE_NAME = "locale";

    private static final String ATTRIBUTE_LOCALE_NAME = "locale";
    private static final String ATTRIBUTE_PREV_REQUEST_NAME = "prev_request";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String newLocale;
	HttpSession session;

	newLocale = request.getParameter(PARAMETER_LOCALE_NAME);

	session = request.getSession(true);
	session.setAttribute(ATTRIBUTE_LOCALE_NAME, newLocale);

	String url = (String) request.getSession(false).getAttribute(ATTRIBUTE_PREV_REQUEST_NAME);
	response.sendRedirect(url);
    }

}
