
public enum FoodXmlAttribute {

    CATEGORY("category"), DISHES_TYPE("dishes_type"), ID("id");

    private final String name;

    FoodXmlAttribute(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

}
