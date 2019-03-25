package by.horant.fintask.dao.util;

import by.horant.fintask.entity.enumeration.ApprovedStages;

/**
 * Utility class to determine the stage of approval or disapproval (for example,
 * the stage of approval of a request for a prescription).
 * 
 * @author Anton Horbach
 *
 */
public class ApprovedIdentifier {

    /**
     * Class constructor.
     */
    private ApprovedIdentifier() {

    }

    /**
     * Defines approval stage by identifier.
     * 
     * @param identifierStage integer stage identifier.
     * @return approval stage.
     */
    public static ApprovedStages debineByIndex(int identifierStage) {
	ApprovedStages stage = null;

	if (ApprovedStages.APPROVED.getIdentifier() == identifierStage) {
	    stage = ApprovedStages.APPROVED;
	} else if (ApprovedStages.UNAPPROVED.getIdentifier() == identifierStage) {
	    stage = ApprovedStages.UNAPPROVED;
	}

	return stage;
    }

}
