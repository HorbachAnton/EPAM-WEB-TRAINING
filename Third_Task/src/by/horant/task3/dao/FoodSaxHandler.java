package by.horant.task3.dao;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.horant.task3.entity.Food;
import by.horant.task3.entity.FoodOption;
import by.horant.task3.entity.GeneralFood;
import by.horant.task3.entity.OptionalFood;
import by.horant.task3.entity.enumeration.FoodType;
import by.horant.task3.entity.enumeration.FoodXmlAttribute;
import by.horant.task3.entity.enumeration.FoodXmlTag;

public class FoodSaxHandler extends DefaultHandler {

    public static final String REGULAR_EXPRESSION_NAMESPACE = "[(\\w)]*:";
    public static final String REGULAR_EXPRESSION_ID = "[(\\w)]*-";

    private FoodOption option;
    private StringBuilder text;
    private GeneralFood genFood;
    private OptionalFood optFood;
    private ArrayList<Food> foodList = new ArrayList<>();

    private FoodType currentType;

    public List<Food> getFoodList() {
	return foodList;
    }

    @Override
    public void characters(char[] buffer, int start, int length) {
	text.append(buffer, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	text = new StringBuilder();
	if (qName.replaceFirst(REGULAR_EXPRESSION_NAMESPACE, "").equalsIgnoreCase(FoodXmlTag.FOOD.getName())) {
	    String type = attributes.getValue(FoodXmlAttribute.DISHES_TYPE.getName());
	    if (type.equals(FoodType.GENERAL_DISHES.getName())) {
		currentType = FoodType.GENERAL_DISHES;
		genFood = new GeneralFood();
		genFood.setCategory(attributes.getValue(FoodXmlAttribute.CATEGORY.getName()));
		String id = attributes.getValue(FoodXmlAttribute.ID.getName()).replaceFirst(REGULAR_EXPRESSION_ID, "");
		genFood.setId(Integer.parseInt(id));
	    } else if (type.replaceFirst(REGULAR_EXPRESSION_NAMESPACE, "").equals(FoodType.OPTIONAL_DISHES.getName())) {
		currentType = FoodType.OPTIONAL_DISHES;
		optFood = new OptionalFood();
		optFood.setCategory(attributes.getValue(FoodXmlAttribute.CATEGORY.getName()));
		String id = attributes.getValue(FoodXmlAttribute.ID.getName()).replaceFirst(REGULAR_EXPRESSION_ID, "");
		optFood.setId(Integer.parseInt(id));
	    }
	} else if (qName.replaceFirst(REGULAR_EXPRESSION_NAMESPACE, "").equalsIgnoreCase(FoodXmlTag.OPTION.getName())) {
	    option = new FoodOption();
	}
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
	FoodXmlTag tag = FoodXmlTag.valueOf(qName.toUpperCase().replaceFirst(REGULAR_EXPRESSION_NAMESPACE, ""));
	switch (tag) {
	case FOOD:
	    if (currentType.equals(FoodType.GENERAL_DISHES)) {
		foodList.add(genFood);
	    } else if (currentType.equals(FoodType.OPTIONAL_DISHES)) {
		foodList.add(optFood);
	    }
	    break;
	case PHOTO:
	    if (currentType.equals(FoodType.GENERAL_DISHES)) {
		genFood.setPhotoPath(text.toString());
	    } else if (currentType.equals(FoodType.OPTIONAL_DISHES)) {
		optFood.setPhotoPath(text.toString());
	    }
	    break;
	case TITLE:
	    if (currentType.equals(FoodType.GENERAL_DISHES)) {
		genFood.setTitle(text.toString());
	    } else if (currentType.equals(FoodType.OPTIONAL_DISHES)) {
		optFood.setTitle(text.toString());
	    }
	    break;
	case GENERAL_DESCRIPTION:
	    if (currentType.equals(FoodType.GENERAL_DISHES)) {
		genFood.setGeneralDescription(text.toString());
	    } else if (currentType.equals(FoodType.OPTIONAL_DISHES)) {
		optFood.setGeneralDescription(text.toString());
	    }
	    break;
	case GENERAL_PORTION:
	    genFood.setGeneralPortion(text.toString());
	    break;
	case GENERAL_PRICE:
	    genFood.setGeneralPrice(Integer.parseInt(text.toString()));
	    break;
	case OPTION:
	    optFood.addOption(option);
	    break;
	case OPTION_NUMBER:
	    option.setOptionNumber(Integer.parseInt(text.toString()));
	    break;
	case OPTION_DESCRIPTION:
	    option.setOptionDescription(text.toString());
	    break;
	case OPTION_PORTION:
	    option.setOptionPortion(text.toString());
	    break;
	case OPTION_PRICE:
	    option.setOptionPrice(Integer.parseInt(text.toString()));
	    break;
	default:
	    break;
	}
    }

}
