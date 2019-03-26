package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.entity.UpdateProfileData;
import by.horant.fintask.entity.User;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.ServiceProvider;
import by.horant.fintask.service.UpdateService;

/**
 * The UpdateProfileCommand class implements the Command interface and
 * represents a command to update user profile.
 * 
 * @author Anton Horbach
 *
 */
public class UpdateProfileCommand implements Command {

    private static final Logger logger = LogManager.getLogger(UpdateProfileCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Could not update profile.";

    private static final String ERROR_SERVICE_EXCEPTION_NAME = "error";
    private static final String ERROR_SERVICE_EXCEPTION_MESSAGE = "First name or Second name invalid.";

    private static final String ATTRIBUTE_USER_NAME = "user";

    private static final String PARAMETER_FIRST_NAME = "first_name";
    private static final String PARAMETER_SECOND_NAME = "second_name";

    private final GoToUserPageCommand goUserPage = new GoToUserPageCommand();
    private final GoToUpdateProfilePageCommand goUpdateProfile = new GoToUpdateProfilePageCommand();

    /**
     * Updates user profile.
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String firstName = null;
	String secondName = null;

	firstName = request.getParameter(PARAMETER_FIRST_NAME);
	secondName = request.getParameter(PARAMETER_SECOND_NAME);

	UpdateProfileData updateData = new UpdateProfileData(firstName, secondName);

	ServiceProvider provider = ServiceProvider.getInstance();
	UpdateService service = provider.getUpdateService();

	User user = (User) request.getSession().getAttribute(ATTRIBUTE_USER_NAME);

	try {
	    service.updateProfile(user.getEmail(), updateData);
	    user.setFirstName(firstName);
	    user.setSecondName(secondName);
	    request.getSession().setAttribute(ATTRIBUTE_USER_NAME, user);
	    goUserPage.execute(request, response);
	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	    request.setAttribute(ERROR_SERVICE_EXCEPTION_NAME, ERROR_SERVICE_EXCEPTION_MESSAGE);
	    goUpdateProfile.execute(request, response);
	}

    }

}
