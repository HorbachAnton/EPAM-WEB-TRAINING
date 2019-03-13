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

public class RequestPrescriptionCommand implements Command {

    private static final Logger logger = LogManager.getLogger(RequestPrescriptionCommand.class);
    private static final String LOGGER_ERROR_MESSAGE = "Can't request a prescription.";

    private static final String PARAMETER_USER_ID_NAME = "userId";
    private static final String PARAMETER_MEDICINE_ID_NAME = "medicineId";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	ServiceProvider serviceProvider = ServiceProvider.getInstance();
	PrescriptionService prescriptionService = serviceProvider.getPrescriptionService();

	try {
	    int userId = Integer.parseInt(request.getParameter(PARAMETER_USER_ID_NAME));
	    int medicineId = Integer.parseInt(request.getParameter(PARAMETER_MEDICINE_ID_NAME));
	    prescriptionService.requestPrescription(userId, medicineId);
	} catch (ServiceException e) {
	    logger.info(LOGGER_ERROR_MESSAGE, e);
	}

    }

}
