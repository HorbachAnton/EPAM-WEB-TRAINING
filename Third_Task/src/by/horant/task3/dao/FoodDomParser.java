package by.horant.task3.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.horant.task3.entity.Food;
import by.horant.task3.entity.FoodOption;
import by.horant.task3.entity.GeneralFood;
import by.horant.task3.entity.OptionalFood;
import by.horant.task3.entity.enumeration.FoodType;
import by.horant.task3.entity.enumeration.FoodXmlAttribute;

public class FoodDomParser {

    private static final String REGULAR_EXPRESSION_ID = "[(\\w)]*-";
    private static List<Food> menu = new ArrayList<>();

    public static List<Food> getMenu() {
	return menu;
    }

    public static void parse() throws SAXException, IOException {
	DOMParser parser = new DOMParser();
	parser.parse("Menu.xml");
	Document document = parser.getDocument();

	Element root = document.getDocumentElement();

	NodeList foodNodes = root.getElementsByTagName("mn:food");

	GeneralFood currGenFood = null;
	OptionalFood currOptFood = null;
	for (int i = 0; i < foodNodes.getLength(); i++) {
	    Element foodElement = (Element) foodNodes.item(i);
	    if (foodElement.getAttribute(FoodXmlAttribute.DISHES_TYPE.getName())
		    .equals(FoodType.GENERAL_DISHES.getName())) {
		currGenFood = new GeneralFood();
		parseGeneralFood(currGenFood, foodElement);
	    } else if (foodElement.getAttribute(FoodXmlAttribute.DISHES_TYPE.getName())
		    .equals(FoodType.OPTIONAL_DISHES.getName())) {
		currOptFood = new OptionalFood();
		parseOptionalFood(currOptFood, foodElement);
	    }

	}

    }

    private static void parseGeneralFood(GeneralFood food, Element foodElement) {
	String id = foodElement.getAttribute(FoodXmlAttribute.ID.getName()).replaceFirst(REGULAR_EXPRESSION_ID, "");
	String category = foodElement.getAttribute(FoodXmlAttribute.CATEGORY.getName());
	String photoPath = getSingleChild(foodElement, "fod:photo").getTextContent().trim();
	String title = getSingleChild(foodElement, "fod:title").getTextContent().trim();
	String generalDescription = getSingleChild(foodElement, "fod:general_description").getTextContent().trim();
	String generalPortion = getSingleChild(foodElement, "fod:general_portion").getTextContent().trim();
	String generalPrice = getSingleChild(foodElement, "fod:general_price").getTextContent().trim();

	food.setId(Integer.parseInt(id));
	food.setCategory(category);
	food.setPhotoPath(photoPath);
	food.setTitle(title);
	food.setGeneralDescription(generalDescription);
	food.setGeneralPortion(generalPortion);
	food.setGeneralPrice(Integer.parseInt(generalPrice));

	menu.add(food);
    }

    private static void parseOptionalFood(OptionalFood food, Element foodElement) {
	String id = foodElement.getAttribute(FoodXmlAttribute.ID.getName()).replaceFirst(REGULAR_EXPRESSION_ID, "");
	String category = foodElement.getAttribute(FoodXmlAttribute.CATEGORY.getName());
	String photoPath = getSingleChild(foodElement, "fod:photo").getTextContent().trim();
	String title = getSingleChild(foodElement, "fod:title").getTextContent().trim();
	String generalDescription = getSingleChild(foodElement, "fod:general_description").getTextContent().trim();

	food.setId(Integer.parseInt(id));
	food.setCategory(category);
	food.setPhotoPath(photoPath);
	food.setTitle(title);
	food.setGeneralDescription(generalDescription);

	NodeList list = getChilds(foodElement, "opdes:option");

	for (int i = 0; i < list.getLength(); i++) {
	    FoodOption option = new FoodOption();

	    Element element = (Element) list.item(i);
	    String optionNumber = getSingleChild(element, "opdes:option_number").getTextContent().trim();
	    String optionDescription = getSingleChild(element, "opdes:option_description").getTextContent().trim();
	    String optionPortion = getSingleChild(element, "opdes:option_portion").getTextContent().trim();
	    String optionPrice = getSingleChild(element, "opdes:option_price").getTextContent().trim();

	    option.setOptionNumber(Integer.parseInt(optionNumber));
	    option.setOptionDescription(optionDescription);
	    option.setOptionPortion(optionPortion);
	    option.setOptionPrice(Integer.parseInt(optionPrice));
	    food.addOption(option);
	}

	menu.add(food);

    }

    private static Element getSingleChild(Element element, String childName) {
	NodeList nlist = element.getElementsByTagName(childName);
	return (Element) nlist.item(0);
    }

    private static NodeList getChilds(Element element, String childName) {
	return element.getElementsByTagName(childName);
    }

}
