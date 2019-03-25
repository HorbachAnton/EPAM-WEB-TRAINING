package by.horant.fintask.entity.enumeration;

/**
 * Class ApprovedStages is enumeration class which contains approval stages (for
 * example for prescription).
 * 
 * @author Anton Horbach
 *
 */
public enum ApprovedStages {

    UNAPPROVED(0), APPROVED(1);

    private final int identifier;

    /**
     * Class constructor specifying integer identifier of approval stage.
     * 
     * @param identifier integer identifier of approval stage.
     */
    private ApprovedStages(int identifier) {
	this.identifier = identifier;
    }

    /**
     * Returns integer identifier approval stage.
     * 
     * @return integer identifier approval stage.
     */
    public int getIdentifier() {
	return identifier;
    }

}
