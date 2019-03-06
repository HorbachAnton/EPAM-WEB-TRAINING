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
import by.horant.fintask.entity.RegistrationData;
import by.horant.fintask.entity.User;
import by.horant.fintask.entity.enumeration.Roles;
import by.horant.fintask.service.ClientService;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.ServiceProvider;

public class RegistrationCommand implements Command {

    private static final Logger logger = LogManager.getLogger(RegistrationCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Register failed.";

    private static final String ATTRIBUTE_PREV_REQUEST_NAME = "prev_request";
    private static final String ATTRIBUTE_USER_NAME = "user";

    private static final Roles DEFAULT_USERS_ROLE = Roles.USER;

    private static final String PARAMETER_EMAIL = "email";
    private static final String PARAMETER_PASSWORD = "password";

    private static final String UPDATE_PROFILE_PAGE = "/WEB-INF/jsp/update_profile.jsp";
    private static final String REGISTRATION_PAGE = "/WEB-INF/jsp/registration.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String page = null;
	String email;
	String password;
	Roles role;

	email = request.getParameter(PARAMETER_EMAIL);
	password = request.getParameter(PARAMETER_PASSWORD);
	role = DEFAULT_USERS_ROLE;

	RegistrationData userData = new RegistrationData(email, password, role);

	ServiceProvider provider = ServiceProvider.getInstance();
	ClientService service = provider.getClientService();

	User user = null;

	try {
	    user = service.registration(userData);
	    request.getSession().setAttribute(ATTRIBUTE_USER_NAME, user);
	    page = UPDATE_PROFILE_PAGE;
	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	    page = REGISTRATION_PAGE;
	}

	String url = CreatorFullURL.create(request);
	request.getSession(true).setAttribute(ATTRIBUTE_PREV_REQUEST_NAME, url);

	RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	dispatcher.forward(request, response);

    }

}
