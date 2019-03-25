package by.horant.fintask.entity.enumeration;

/**
 * Class OrderComleteStages is enumeration class which contains order complete
 * stages.
 * 
 * @author Anton Horbach
 *
 */
public enum OrderComleteStages {

    UNCOMPLETED(0), COMPLETED(1);

    private final int identifier;

    /**
     * Class constructor specifying integer identifier of order complete stage.
     * 
     * @param identifier integer identifier of order complete stage.
     */
    private OrderComleteStages(int identifier) {
	this.identifier = identifier;
    }

    /**
     * Returns integer identifier order complete stage.
     * 
     * @return integer identifier order complete stage.
     */
    public int getIdentifier() {
	return identifier;
    }

}
