package by.horant.fintask.entity.enumeration;

public enum Roles {

    ADMIN(1), USER(2), DOCTOR(3), PHARMACIST(4);

    private final int identifier;

    private Roles(int identifier) {
	this.identifier = identifier;
    }

    public int getIdentifier() {
	return identifier;
    }

}
