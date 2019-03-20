package by.horant.fintask.entity.enumeration;

public enum OrderComleteStages {

    UNCOMPLETED(0), COMPLETED(1);

    private final int identifier;

    private OrderComleteStages(int identifier) {
	this.identifier = identifier;
    }

    public int getIdentifier() {
	return identifier;
    }

}
