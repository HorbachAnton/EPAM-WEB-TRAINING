package by.horant.fintask.controller.command.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class CreatorFullURL {

    private CreatorFullURL() {

    }

    public static String create(HttpServletRequest request) {
	String url = "";

	Enumeration<String> paramNames2 = request.getParameterNames();

	String paramName;
	String paramValue;
	while (paramNames2.hasMoreElements()) {
	    paramName = paramNames2.nextElement();

	    paramValue = request.getParameter(paramName);
	    url = url + paramName + "=" + paramValue + "&";
	}

	url = request.getRequestURL() + "?" + url;

	return url;

    }
}