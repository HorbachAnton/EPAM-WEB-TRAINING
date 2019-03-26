package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.service.PrescriptionService;
import by.horant.fintask.service.ServiceException;
import by.horant.fintask.service.ServiceProvider;

/**
 * The ApprovePrescriptionCommand class implements the Command interface and
 * contains logic for approving a request for a recipe.
 * 
 * @author Anton Horbach
 *
 */
public class ApprovePrescriptionCommand implements Command {

    private static final Logger logger = LogManager.getLogger(ApprovePrescriptionCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Could not approve prescription.";

    Command goDoctorPage = new GoToDoctorPageCommand();

    /**
     * Approves a request for a recipe.
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int prescriptionId = Integer.parseInt(request.getParameter("idPrescription"));

	ServiceProvider serviceProvider = ServiceProvider.getInstance();
	PrescriptionService prescriptionService = serviceProvider.getPrescriptionService();

	try {
	    prescriptionService.approvePrescription(prescriptionId);
	    goDoctorPage.execute(request, response);
	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	}

    }

}
