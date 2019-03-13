package by.horant.fintask.entity.enumeration;

public enum UsedStages {

    UNUSED(0), USED(1);

    private final int identifier;

    private UsedStages(int identifier) {
	this.identifier = identifier;
    }

    public int getIdentifier() {
	return identifier;
    }

}
