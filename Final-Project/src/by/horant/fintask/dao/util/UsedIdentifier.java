package by.horant.fintask.dao.util;

import by.horant.fintask.entity.enumeration.UsedStages;

/**
 * Class utility designed to determine the stage of use (for example, a recipe).
 * 
 * @author Anton Horbach
 *
 */
public class UsedIdentifier {

    /**
     * Class constructor
     */
    private UsedIdentifier() {

    }

    /**
     * Defines the stage of use.
     * 
     * @param identifierStage integer stage identifier.
     * @return the stage of use.
     */
    public static UsedStages defineByIndex(int identifierStage) {
	UsedStages stage = null;

	if (UsedStages.UNUSED.getIdentifier() == identifierStage) {
	    stage = UsedStages.UNUSED;
	} else if (UsedStages.USED.getIdentifier() == identifierStage) {
	    stage = UsedStages.USED;
	}

	return stage;
    }
}
