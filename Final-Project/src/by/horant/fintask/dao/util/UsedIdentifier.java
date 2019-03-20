package by.horant.fintask.dao.util;

import by.horant.fintask.entity.enumeration.UsedStages;

public class UsedIdentifier {
    
    private UsedIdentifier() {
	
    }

    public static UsedStages defineByIndex(int identifierStage) {
	UsedStages stage = null;
	
	if(UsedStages.UNUSED.getIdentifier() == identifierStage) {
	    stage = UsedStages.UNUSED;
	} else if (UsedStages.USED.getIdentifier() == identifierStage) {
	    stage = UsedStages.USED;
	}

	return stage;
    }
}
