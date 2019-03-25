package by.horant.fintask.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * This class implements the Filter interface and serves to define the encoding
 * of the request / response pair. If the encoding is different from the UTF-8
 * encoding, the filter sets it up on its own.
 * 
 * @author Anton Horbach
 *
 */
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
