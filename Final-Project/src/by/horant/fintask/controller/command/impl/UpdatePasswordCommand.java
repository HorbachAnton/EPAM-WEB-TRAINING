package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.entity.User;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.ServiceProvider;
import by.horant.fintask.service.UpdateService;

public class UpdatePasswordCommand implements Command {

    private static final Logger logger = LogManager.getLogger(UpdatePasswordCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Could not update password.";

    private static final String PARAMETER_PASSWORD = "new_password";

    private static final String ERROR_SERVICE_EXCEPTION_NAME = "error";
    private static final String ERROR_SERVICE_EXCEPTION_MESSAGE = "Your entered password is invalid.";

    private static final String ATTRIBUTE_USER_NAME = "user";

    private Command goUpdatePassword = new GoToUpdatePasswordPageCommand();
    private Command goUserPage = new GoToUserPageCommand();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String password = null;
	password = request.getParameter(PARAMETER_PASSWORD);

	User user = (User) request.getSession().getAttribute(ATTRIBUTE_USER_NAME);

	ServiceProvider provider = ServiceProvider.getInstance();
	UpdateService service = provider.getUpdateService();

	try {
	    service.updatePassword(user.getEmail(), password);
	    user.setPassword(password);
	    request.getSession().setAttribute(ATTRIBUTE_USER_NAME, user);
	    goUserPage.execute(request, response);
	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	    request.setAttribute(ERROR_SERVICE_EXCEPTION_NAME, ERROR_SERVICE_EXCEPTION_MESSAGE);
	    goUpdatePassword.execute(request, response);
	}

    }

}
