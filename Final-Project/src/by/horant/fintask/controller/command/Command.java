package by.horant.fintask.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The user of this interface undertakes to implement a class that represents a
 * command with the appropriate method responsible for its launch and execution.
 * 
 * @author y50-70
 *
 */
public interface Command {

    /**
     * The method is responsible for executing the command.
     */
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
