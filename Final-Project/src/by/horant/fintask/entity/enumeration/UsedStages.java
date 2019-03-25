package by.horant.fintask.entity.enumeration;

/**
 * Class UsedStages is enumeration class which contains used stages.
 * 
 * @author Anton Horbach
 *
 */
public enum UsedStages {

    UNUSED(0), USED(1);

    private final int identifier;

    /**
     * Class constructor specifying integer identifier of used stage.
     * 
     * @param identifier integer identifier of used stage.
     */
    private UsedStages(int identifier) {
	this.identifier = identifier;
    }

    /**
     * Returns integer identifier of used stage.
     * 
     * @return integer identifier of used stage.
     */
    public int getIdentifier() {
	return identifier;
    }

}
