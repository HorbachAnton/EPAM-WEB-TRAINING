package by.horant.task3.entity.enumeration;


public enum FoodType {

    GENERAL_DISHES("general_dishes"), OPTIONAL_DISHES("optional_dishes");

    private final String name;

    FoodType(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

}
