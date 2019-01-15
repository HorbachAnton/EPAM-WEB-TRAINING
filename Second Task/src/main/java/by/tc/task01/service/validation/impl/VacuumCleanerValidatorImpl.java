package by.tc.task01.service.validation.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner;
import by.tc.task01.service.validation.VacuumCleanerValidator;

public class VacuumCleanerValidatorImpl implements VacuumCleanerValidator {

    @Override
    public boolean validVacuumCleanerCriteria(String key, String value) {
	boolean isValidated;
	VacuumCleaner vacCleaner = Enum.valueOf(VacuumCleaner.class, key);
	switch (vacCleaner) {
	case CLEANING_WIDTH:
	    isValidated = validNumber(value);
	    break;
	case MOTOR_SPEED_REGULATION:
	    isValidated = validNumber(value);
	    break;
	case POWER_CONSUMPTION:
	    isValidated = validNumber(value);
	    break;
	case WAND_TYPE:
	    isValidated = validLine(value);
	    break;
	case FILTER_TYPE:
	    isValidated = validLine(value);
	    break;
	case BAG_TYPE:
	    isValidated = validLine(value);
	    break;
	default:
	    isValidated = false;
	    break;
	}
	return isValidated;
    }

    private static boolean validNumber(String value) {
	boolean isValidated;
	if (NumberUtils.isParsable(value)) {
	    isValidated = true;
	} else {
	    isValidated = false;
	}
	return isValidated;
    }

    private static boolean validLine(String value) {
	boolean isValidated;
	if (StringUtils.isNumeric(value)) {
	    isValidated = false;
	} else {
	    isValidated = true;
	}
	return isValidated;
    }

}
