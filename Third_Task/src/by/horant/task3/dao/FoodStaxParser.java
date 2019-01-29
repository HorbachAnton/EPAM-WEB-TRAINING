package by.horant.task3.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.horant.task3.entity.Food;
import by.horant.task3.entity.FoodOption;
import by.horant.task3.entity.GeneralFood;
import by.horant.task3.entity.OptionalFood;
import by.horant.task3.entity.enumeration.FoodType;
import by.horant.task3.entity.enumeration.FoodXmlTag;

public class FoodStaxParser {

    public static final String DEFAULT_NAMESPACE = null;
    public static final String REGULAR_EXPRESSION_ID = "[(\\w)]*-";

    private static List<Food> foodList;
    private static GeneralFood currGenFood;
    private static OptionalFood currOptFood;
    private static FoodOption option;
    private static String tagContent;

    private static FoodType currentType;

    public static List<Food> process(XMLStreamReader reader) throws XMLStreamException {

	while (reader.hasNext()) {
	    int event = reader.next();

	    switch (event) {

	    case XMLStreamConstants.START_ELEMENT:
		if (FoodXmlTag.MENU.getName().equalsIgnoreCase(reader.getLocalName())) {
		    foodList = new ArrayList<>();
		} else if (FoodXmlTag.FOOD.getName().equalsIgnoreCase(reader.getLocalName())) {
		    if (FoodType.GENERAL_DISHES.getName()
			    .equals(reader.getAttributeValue(DEFAULT_NAMESPACE, "dishes_type"))) {
			currentType = FoodType.GENERAL_DISHES;
			currGenFood = new GeneralFood();
			currGenFood.setCategory(reader.getAttributeValue(DEFAULT_NAMESPACE, "category"));
			String id = reader.getAttributeValue(DEFAULT_NAMESPACE, "id")
				.replaceFirst(REGULAR_EXPRESSION_ID, "");
			currGenFood.setId(Integer.parseInt(id));
		    } else if (FoodType.OPTIONAL_DISHES.getName()
			    .equals(reader.getAttributeValue(DEFAULT_NAMESPACE, "dishes_type"))) {
			currentType = FoodType.OPTIONAL_DISHES;
			currOptFood = new OptionalFood();
			currOptFood.setCategory(reader.getAttributeValue(DEFAULT_NAMESPACE, "category"));
			String id = reader.getAttributeValue(DEFAULT_NAMESPACE, "id")
				.replaceFirst(REGULAR_EXPRESSION_ID, "");
			currOptFood.setId(Integer.parseInt(id));
		    }
		} else if (FoodXmlTag.OPTION.getName().equalsIgnoreCase(reader.getLocalName())) {
		    option = new FoodOption();
		}
		break;

	    case XMLStreamConstants.CHARACTERS:
		tagContent = reader.getText().trim();
		break;

	    case XMLStreamConstants.END_ELEMENT:
		FoodXmlTag tag = FoodXmlTag.valueOf(reader.getLocalName().toUpperCase());
		switch (tag) {

		case FOOD:
		    if (currentType.equals(FoodType.GENERAL_DISHES)) {
			foodList.add(currGenFood);
		    } else if (currentType.equals(FoodType.OPTIONAL_DISHES)) {
			foodList.add(currOptFood);
		    }
		    break;

		case PHOTO:
		    if (currentType.equals(FoodType.GENERAL_DISHES)) {
			currGenFood.setPhotoPath(tagContent);
		    } else if (currentType.equals(FoodType.OPTIONAL_DISHES)) {
			currOptFood.setPhotoPath(tagContent);
		    }
		    break;

		case TITLE:
		    if (currentType.equals(FoodType.GENERAL_DISHES)) {
			currGenFood.setTitle(tagContent);
		    } else if (currentType.equals(FoodType.OPTIONAL_DISHES)) {
			currOptFood.setTitle(tagContent);
		    }
		    break;

		case GENERAL_DESCRIPTION:
		    if (currentType.equals(FoodType.GENERAL_DISHES)) {
			currGenFood.setGeneralDescription(tagContent);
		    } else if (currentType.equals(FoodType.OPTIONAL_DISHES)) {
			currOptFood.setGeneralDescription(tagContent);
		    }
		    break;

		case GENERAL_PORTION:
		    currGenFood.setGeneralPortion(tagContent);
		    break;

		case GENERAL_PRICE:
		    currGenFood.setGeneralPrice(Integer.parseInt(tagContent));
		    break;

		case OPTION:
		    currOptFood.addOption(option);
		    break;

		case OPTION_NUMBER:
		    option.setOptionNumber(Integer.parseInt(tagContent));
		    break;

		case OPTION_DESCRIPTION:
		    option.setOptionDescription(tagContent);
		    break;

		case OPTION_PORTION:
		    option.setOptionPortion(tagContent);
		    break;

		case OPTION_PRICE:
		    option.setOptionPrice(Integer.parseInt(tagContent));
		    break;

		default:
		    break;
		}
	    }
	}
	return foodList;
    }
}