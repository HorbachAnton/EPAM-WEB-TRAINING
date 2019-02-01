package by.horant.task3.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChoosedPageServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final int DISHES_NUMBER_ON_PAGE = 7;
    private static final int SUBTRAHEND_LAST_FOOD = 1;

    public ChoosedPageServlet() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	int pagesNmber = Integer.parseInt(request.getParameter("choosed_page"));
	int number = pagesNmber * DISHES_NUMBER_ON_PAGE;
	int firstNumber = number - DISHES_NUMBER_ON_PAGE;
	int lastNumber = number - SUBTRAHEND_LAST_FOOD;

	request.setAttribute("first_food", firstNumber);
	request.setAttribute("last_food", lastNumber);

	getServletContext().getRequestDispatcher("/welcome").forward(request, response);
    }

}
