package by.horant.fintask.dao.util;

import by.horant.fintask.entity.enumeration.OrderComleteStages;

/**
 * Class utility designed to determine the stage of completion of the order.
 * 
 * @author Anton Horbach
 *
 */
public class CompleteOrderIdentifier {

    /**
     * Class constructor
     */
    private CompleteOrderIdentifier() {

    }

    /**
     * Defines the stage of completion of the order by identifier.
     * 
     * @param identifierStage integer stage identifier.
     * @return the stage of completion of the order.
     */
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
