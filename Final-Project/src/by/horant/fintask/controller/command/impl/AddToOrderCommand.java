package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;
import by.horant.fintask.entity.User;

public class AddToOrderCommand implements Command {

    private static final String SELECTED_MEDICINE_ID_PARAMETER = "selected_medicine_id";
    private static final String SELECTED_MEDICINE_NAME_PARAMETER = "selected_medicine_name";
    private static final String SELECTED_MEDICINE_TYPE_PARAMETER = "selected_medicine_type";
    private static final String SELECTED_MEDICINE_DESCRIPTION_PARAMETER = "selected_medicine_description";
    private static final String SELECTED_MEDICINE_DOSAGE_PARAMETER = "selected_medicine_dosage";
    private static final String SELECTED_MEDICINE_NEED_PRESCRIPTION_PARAMETER = "selected_medicine_need_prescription";

    private static final String NEED_A_RECIPE = "true";

    private Command goUserPage = new GoToUserPageCommand();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	Order order = (Order) request.getSession().getAttribute("order");

	if (order == null) {
	    order = new Order();
	    User customer = (User) request.getSession().getAttribute("user");
	    order.setCustomer(customer);
	}

	Medicine medicine = new Medicine();
	medicine.setId(Integer.parseInt(request.getParameter(SELECTED_MEDICINE_ID_PARAMETER)));

	String name = request.getParameter(SELECTED_MEDICINE_NAME_PARAMETER);
	medicine.setName(name);

	String type = request.getParameter(SELECTED_MEDICINE_TYPE_PARAMETER);
	medicine.setType(type);

	String description = request.getParameter(SELECTED_MEDICINE_DESCRIPTION_PARAMETER);
	medicine.setDescription(description);

	medicine.setDosage(request.getParameter(SELECTED_MEDICINE_DOSAGE_PARAMETER));

	String flagNeedPrescription = request.getParameter(SELECTED_MEDICINE_NEED_PRESCRIPTION_PARAMETER);
	medicine.setNeedPrescription(isNeedPrescription(flagNeedPrescription));

	order.addMedicine(medicine);
	request.getSession(false).setAttribute("order", order);
	goUserPage.execute(request, response);
    }

    private boolean isNeedPrescription(String flagNeedPrescription) {
	boolean result = true;

	if (!flagNeedPrescription.equals(NEED_A_RECIPE)) {
	    result = false;
	}

	return result;
    }

}
