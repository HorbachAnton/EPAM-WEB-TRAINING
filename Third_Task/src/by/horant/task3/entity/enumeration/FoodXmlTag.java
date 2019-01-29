package by.horant.task3.entity.enumeration;


public enum FoodXmlTag {

    MENUS("MENUS"), MENU("menu"), FOOD("food"), PHOTO("photo"), TITLE("title"),
    GENERAL_DESCRIPTION("general_description"), GENERAL_PORTION("general_portion"), GENERAL_PRICE("general_price"),
    OPTION("option"), OPTIONS_DESCRIPTION("options_description"), OPTION_NUMBER("option_number"),
    OPTION_DESCRIPTION("option_description"), OPTION_PORTION("option_portion"), OPTION_PRICE("option_price");

    private final String name;

    FoodXmlTag(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

}
