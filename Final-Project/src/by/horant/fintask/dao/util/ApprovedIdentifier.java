package by.horant.fintask.dao.util;

import by.horant.fintask.entity.enumeration.ApprovedStages;

public class ApprovedIdentifier {

    private ApprovedIdentifier() {

    }

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
