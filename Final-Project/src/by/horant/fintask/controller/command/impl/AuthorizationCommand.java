package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.entity.User;
import by.horant.fintask.entity.enumeration.Roles;
import by.horant.fintask.service.ClientService;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.ServiceProvider;

public class AuthorizationCommand implements Command {

    private static final Logger logger = LogManager.getLogger(AuthorizationCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Could not log in.";

    private static final String PARAMETER_EMAIL_NAME = "email";
    private static final String PARAMETER_PASSWORD_NAME = "password";

    private static final String ATTRIBUTE_USER_NAME = "user";

    private static final String ERROR_NULL_USER_NAME = "error";
    private static final String ERROR_NULL_USER_MESSAGE = "email or password error";

    private static final String ERROR_SERVICE_EXCEPTION_NAME = "error";
    private static final String ERROR_SERVICE_EXCEPTION_MESSAGE = "Login or Password Error";

    private Command goToAdminPage = new GoToAdminPageCommand();
    private Command goToUserPage = new GoToUserPageCommand();
    private Command goToIndexPage = new GoToIndexPageCommand();
    private Command goToPharmacistPage = new GoToPharmacistPageCommand();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String email;
	String password;

	email = request.getParameter(PARAMETER_EMAIL_NAME);
	password = request.getParameter(PARAMETER_PASSWORD_NAME);

	ServiceProvider provider = ServiceProvider.getInstance();
	ClientService service = provider.getClientService();

	User user = null;

	try {
	    user = service.authorization(email, password);

	    if (user == null) {
		request.setAttribute(ERROR_NULL_USER_NAME, ERROR_NULL_USER_MESSAGE);
		goToIndexPage.execute(request, response);
	    } else {
		request.getSession().setAttribute(ATTRIBUTE_USER_NAME, user);
		definePage(user.getRole(), request, response);
	    }
	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	    request.setAttribute(ERROR_SERVICE_EXCEPTION_NAME, ERROR_SERVICE_EXCEPTION_MESSAGE);
	    goToIndexPage.execute(request, response);
	}

    }

    private void definePage(Roles role, HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	switch (role) {
	case ADMIN:
	    goToAdminPage.execute(request, response);
	    break;
	case USER:
	    goToUserPage.execute(request, response);
	    break;
	case PHARMACIST:
	    goToPharmacistPage.execute(request, response);
	    break;
	default:
	    goToUserPage.execute(request, response);
	    break;
	}

    }

}
