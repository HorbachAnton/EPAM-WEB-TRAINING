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

public class ApprovePrescriptionCommand implements Command {

    private static final Logger logger = LogManager.getLogger(ApprovePrescriptionCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Could not approve prescription.";
    
    Command GoPharmacistPage = new GoToPharmacistPageCommand();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int prescriptionId = Integer.parseInt(request.getParameter("idPrescription"));

	ServiceProvider serviceProvider = ServiceProvider.getInstance();
	PrescriptionService prescriptionService = serviceProvider.getPrescriptionService();

	try {
	    prescriptionService.approvePrescription(prescriptionId);
	    GoPharmacistPage.execute(request, response);
	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	    e.printStackTrace();
	}

    }

}
