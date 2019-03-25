package by.horant.fintask.entity.enumeration;

/**
 * Class Roles is enumeration class which contains user roles.
 * 
 * @author Anton Horbach
 *
 */
public enum Roles {

    ADMIN(1), USER(2), DOCTOR(3), PHARMACIST(4);

    private final int identifier;

    /**
     * Class constructor specifying integer identifier of user role.
     * 
     * @param identifier integer identifier of user role.
     */
    private Roles(int identifier) {
	this.identifier = identifier;
    }

    /**
     * Returns integer identifier of user role.
     * 
     * @return integer identifier of user role.
     */
    public int getIdentifier() {
	return identifier;
    }

}
