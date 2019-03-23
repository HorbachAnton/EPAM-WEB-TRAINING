package by.horant.fintask.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

    private static final String DEFAULT_ENCODING = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	    throws IOException, ServletException {
	String encoding = request.getCharacterEncoding();

	if (!DEFAULT_ENCODING.equalsIgnoreCase(encoding)) {
	    request.setCharacterEncoding(DEFAULT_ENCODING);
	    response.setCharacterEncoding(DEFAULT_ENCODING);
	}

	chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}