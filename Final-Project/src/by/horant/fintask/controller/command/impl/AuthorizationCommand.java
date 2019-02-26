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
import by.horant.fintask.entity.User;
import by.horant.fintask.service.ClientService;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.ServiceProvider;

public class AuthorizationCommand implements Command {
    
    private static final Logger logger = LogManager.getLogger(AuthorizationCommand.class);

    private static final String PARAMETER_EMAIL = "email";
    private static final String PARAMETER_PASSWORD = "password";

    private static final String MAIN_PAGE = "/WEB-INF/jsp/main.jsp";
    private static final String INDEX_PAGE = "/WEB-INF/jsp/default.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String email;
	String password;

	email = request.getParameter(PARAMETER_EMAIL);
	password = request.getParameter(PARAMETER_PASSWORD);

	ServiceProvider provider = ServiceProvider.getInstance();
	ClientService service = provider.getClientService();

	User user = null;
	String page;
	try {
	    user = service.authorization(email, password);

	    if (user == null) {
		request.setAttribute("error", "email or password error");
		page = INDEX_PAGE;
	    } else {
		request.setAttribute("user", user);
		page = MAIN_PAGE;
	    }
	} catch (ServiceException e) {
	    logger.info("Could not log in.", e);
	    request.setAttribute("error", "Login or Password Error");
	    page = INDEX_PAGE;
	}

	String url = CreatorFullURL.create(request);
	request.getSession(true).setAttribute("prev_request", url);

	RequestDispatcher dispatcher = request.getRequestDispatcher(page);
	dispatcher.forward(request, response);

    }

}
