
public enum FoodCategories {

    COLD_APPETIZER("cold_appetizer"), HOT_SNACK("hot_snack"), BREAKFASTS("breakfasts"), SALADS("salads"),
    SOUPS("soups"), FISH_DISHES("fish_dishes"), MEAT_DISHES("meat_dishes"), SIDE_DISHES("side_dishes"),
    DISHES_ON_GRILL("dishes_on_grill"), FROM_CHEF("from_chef"), ATTACHMENT("attachment"), DESSERT("dessert");

    private final String name;

    FoodCategories(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }
}
