package by.horant.task3.service;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocalisationServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    public LocalisationServlet() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String localeType = request.getParameter("locale");

	if (localeType.equals("RUS")) {
	    Locale locale = new Locale("ru", "RU");
	    response.setLocale(locale);
	} else if (localeType.equals("EN")) {
	    Locale locale = new Locale("en", "EN");
	    response.setLocale(locale);
	}

	getServletContext().getRequestDispatcher("/welcome").forward(request, response);
    }

}
