package by.horant.task3.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChoosedPageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

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
	int number = pagesNmber * 7;
	int firstNumber = number - 7;
	int lastNumber = number - 1;

	request.setAttribute("first_food", firstNumber);
	request.setAttribute("last_food", lastNumber);

	getServletContext().getRequestDispatcher("/welcome").forward(request, response);
    }

}
