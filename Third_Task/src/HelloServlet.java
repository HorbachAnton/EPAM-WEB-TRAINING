
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.xml.sax.SAXException;

public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HelloServlet() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");
	String parserType = request.getParameter("parser");
	List<Food> menu = null;

	if (parserType.equals("SAX")) {
	    try {
		menu = parseSax();
	    } catch (SAXException | ParserConfigurationException e) {
		e.printStackTrace();
	    }

	} else if (parserType.equals("StAX")) {
	    try {
		menu = parseStax();
	    } catch (XMLStreamException e) {
		e.printStackTrace();
	    }
	} else if (parserType.equals("DOM")) {
	    try {
		menu = parseDom();
	    } catch (SAXException e) {
		e.printStackTrace();
	    }
	}

	HttpSession session = request.getSession();
	session.setAttribute("menu", menu);
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
	FoodDomParser.parse();
	return FoodDomParser.getMenu();
    }

}
