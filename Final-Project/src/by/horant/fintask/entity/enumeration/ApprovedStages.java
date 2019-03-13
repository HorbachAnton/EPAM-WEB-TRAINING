package by.horant.fintask.entity.enumeration;

public enum ApprovedStages {

    UNAPPROVED(0), APPROVED(1);

    private final int identifier;

    private ApprovedStages(int identifier) {
	this.identifier = identifier;
    }

    public int getIdentifier() {
	return identifier;
    }

}
