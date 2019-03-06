package by.horant.fintask.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.horant.fintask.controller.command.Command;
import by.horant.fintask.entity.Medicine;
import by.horant.fintask.entity.Order;

public class AddToOrderCommand implements Command {

    GoToUserPageCommand goUserPage = new GoToUserPageCommand();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html; charset=UTF-8");
	request.setCharacterEncoding("UTF-8");

	Order order = (Order) request.getSession().getAttribute("order");

	if (order == null) {
	    order = new Order();
	}

	Medicine medicine = new Medicine();
	medicine.setId(Integer.parseInt(request.getParameter("selected_medicine_id")));
	String name = new String(request.getParameter("selected_medicine_name").getBytes("ISO-8859-1"), "UTF-8");
	medicine.setName(name);
	String type = new String(request.getParameter("selected_medicine_type").getBytes("ISO-8859-1"), "UTF-8");
	medicine.setType(type);
	String description = new String(request.getParameter("selected_medicine_description").getBytes("ISO-8859-1"),
		"UTF-8");
	medicine.setDescription(description);
	medicine.setDosage(request.getParameter("selected_medicine_dosage"));
	String isNeedPrescription = new String(
		request.getParameter("selected_medicine_need_prescription").getBytes("ISO-8859-1"), "UTF-8");

	if (isNeedPrescription.equals("Необходим рецепт.")) {
	    medicine.setNeedPrescription(false);
	} else {
	    medicine.setNeedPrescription(true);
	}

	order.addMedicine(medicine);
	request.getSession(false).setAttribute("order", order);
	goUserPage.execute(request, response);
    }

}
