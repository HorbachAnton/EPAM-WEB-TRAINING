package by.horant.fintask.dao.util;

import by.horant.fintask.entity.enumeration.OrderComleteStages;

public class CompleteOrderIdentifier {

    private CompleteOrderIdentifier() {

    }

    public static OrderComleteStages defineByIndex(int identifierStage) {
	OrderComleteStages orderStage = null;

	if (OrderComleteStages.UNCOMPLETED.getIdentifier() == identifierStage) {
	    orderStage = OrderComleteStages.UNCOMPLETED;
	} else if (OrderComleteStages.COMPLETED.getIdentifier() == identifierStage) {
	    orderStage = OrderComleteStages.COMPLETED;
	}

	return orderStage;
    }

}
