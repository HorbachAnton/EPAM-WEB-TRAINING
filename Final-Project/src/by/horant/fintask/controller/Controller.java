package by.horant.fintask.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.controller.command.CommandProvider;

/**
 * The inheritor of the HttpServlet class, which is used to process the
 * request-response pair. Processing the pair is to receive a request.
 * Retrieving from the request a parameter representing the name of the command
 * being called, searching for the corresponding command in the object of the
 * CommandProvider class and calling the method for executing the corresponding
 * command.
 * 
 * @author y50-70
 *
 */
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String PARAMETER_COMMAND = "command";

    private final CommandProvider provider = new CommandProvider();

    public Controller() {
	super();
    }

    /**
     * Called by the server (via the service method) to allow a servlet to handle a
     * GET request.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String commandName = request.getParameter(PARAMETER_COMMAND);
	Command command = provider.getCommand(commandName);
	command.execute(request, response);
    }

    /**
     * Called by the server (via the service method) to allow a servlet to handle a
     * POST request. The HTTP POST method allows the client to send data of
     * unlimited length to the Web server a single time and is useful when posting
     * information such as credit card numbers.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doGet(request, response);
    }

}
