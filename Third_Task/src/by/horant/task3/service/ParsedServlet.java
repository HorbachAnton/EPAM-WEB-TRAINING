package by.horant.task3.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.xml.sax.SAXException;

import by.horant.task3.dao.FoodDomParser;
import by.horant.task3.dao.FoodSaxHandler;
import by.horant.task3.dao.FoodStaxParser;
import by.horant.task3.entity.Food;

public class ParsedServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public static final String MENU_FOLDER_PATH = "resources\\Menu.xml";
    public static final String MENU_PAGE_URL = "/menu.jsp";

    public static final String REQUEST_DEFAULT_ENCODING = "UTF-8";
    public static final String RESPONSE_DEFAULT_ENCODING = "UTF-8";

    public static final String IDENTIFIER_PARSER = "parser";
    public static final String IDENTIFIER_SAX = "SAX";
    public static final String IDENTIFIER_STAX = "StAX";
    public static final String IDENTIFIER_DOM = "DOM";

    public static final String IDENTIFIER_PAGES_NUMBER = "pages_number";
    public static final String IDENTIFIER_MENU = "menu";

    public ParsedServlet() {
	super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	String appPath = request.getServletContext().getRealPath("");
	String menuPath = appPath + MENU_FOLDER_PATH;

	request.setCharacterEncoding(REQUEST_DEFAULT_ENCODING);
	response.setCharacterEncoding(RESPONSE_DEFAULT_ENCODING);

	String parserType = request.getParameter(IDENTIFIER_PARSER);
	List<Food> menu = null;

	if (parserType.equals(IDENTIFIER_SAX)) {
	    try {
		menu = parseSax(menuPath);
		request.setAttribute(IDENTIFIER_PARSER, IDENTIFIER_SAX);
	    } catch (SAXException | ParserConfigurationException e) {
		e.printStackTrace();
	    }

	} else if (parserType.equals(IDENTIFIER_STAX)) {
	    try {
		menu = parseStax(menuPath);
		request.setAttribute(IDENTIFIER_PARSER, IDENTIFIER_STAX);
	    } catch (XMLStreamException e) {
		e.printStackTrace();
	    }
	} else if (parserType.equals(IDENTIFIER_DOM)) {
	    try {
		menu = parseDom(menuPath);
		request.setAttribute(IDENTIFIER_PARSER, IDENTIFIER_DOM);
	    } catch (SAXException e) {
		e.printStackTrace();
	    }
	} else {
	    try {
		menu = parseSax(menuPath);
	    } catch (SAXException | ParserConfigurationException e) {
		e.printStackTrace();
	    }
	}

	request.setAttribute(IDENTIFIER_MENU, menu);
	request.setAttribute(IDENTIFIER_PAGES_NUMBER, Math.round(menu.size() / 7));
	getServletContext().getRequestDispatcher(MENU_PAGE_URL).forward(request, response);
    }

    private List<Food> parseSax(String path) throws SAXException, IOException, ParserConfigurationException {
	SAXParserFactory spfac = SAXParserFactory.newInstance();
	SAXParser sp = spfac.newSAXParser();
	FoodSaxHandler handler = new FoodSaxHandler();
	sp.parse(path, handler);
	return handler.getFoodList();
    }

    private List<Food> parseStax(String path) throws XMLStreamException, FileNotFoundException {
	XMLInputFactory factory = XMLInputFactory.newInstance();
	XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(path));
	return FoodStaxParser.process(reader);
    }

    private List<Food> parseDom(String menu) throws SAXException, IOException {
	FoodDomParser parserDom = new FoodDomParser();
	parserDom.parse(menu);
	return parserDom.getMenu();
    }

}
