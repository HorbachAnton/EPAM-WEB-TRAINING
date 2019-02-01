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

	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	String parserType = request.getParameter("parser");
	List<Food> menu = null;

	if (parserType.equals("SAX")) {
	    try {
		menu = parseSax();
		request.setAttribute("parser", "SAX");
	    } catch (SAXException | ParserConfigurationException e) {
		e.printStackTrace();
	    }

	} else if (parserType.equals("StAX")) {
	    try {
		menu = parseStax();
		request.setAttribute("parser", "StAX");
	    } catch (XMLStreamException e) {
		e.printStackTrace();
	    }
	} else if (parserType.equals("DOM")) {
	    try {
		menu = parseDom();
		request.setAttribute("parser", "DOM");
	    } catch (SAXException e) {
		e.printStackTrace();
	    }
	} else {
	    try {
		menu = parseSax();
	    } catch (SAXException | ParserConfigurationException e) {
		e.printStackTrace();
	    }
	}

	request.setAttribute("menu", menu);
	request.setAttribute("pages_number", Math.round(menu.size() / 7));
	getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
    }

    private List<Food> parseSax() throws SAXException, IOException, ParserConfigurationException {
	SAXParserFactory spfac = SAXParserFactory.newInstance();
	SAXParser sp = spfac.newSAXParser();
	FoodSaxHandler handler = new FoodSaxHandler();
	sp.parse("Menu.xml", handler);
	return handler.getFoodList();
    }

    private List<Food> parseStax() throws XMLStreamException, FileNotFoundException {
	XMLInputFactory factory = XMLInputFactory.newInstance();
	XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream("Menu.xml"));
	return FoodStaxParser.process(reader);
    }

    private List<Food> parseDom() throws SAXException, IOException {
	FoodDomParser parserDom = new FoodDomParser();
	parserDom.parse();
	return parserDom.getMenu();
    }

}
