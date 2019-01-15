package by.tc.task01.service.validation.impl;

import org.apache.commons.lang3.math.NumberUtils;

import by.tc.task01.entity.criteria.SearchCriteria.Refrigerator;
import by.tc.task01.service.validation.RefrigeratorValidator;

public class RefrigeratorValidatorImpl implements RefrigeratorValidator {

    @Override
    public boolean validRefrigeratorCriteria(String key, String value) {
	boolean isValidated;
	Refrigerator refrigerator = Enum.valueOf(Refrigerator.class, key);
	switch (refrigerator) {
	case FREEZER_CAPACITY:
	    isValidated = validNumber(value);
	    break;
	case HEIGHT:
	    isValidated = validNumber(value);
	    break;
	case OVERALL_CAPACITY:
	    isValidated = validNumber(value);
	    break;
	case POWER_CONSUMPTION:
	    isValidated = validNumber(value);
	    break;
	case WEIGHT:
	    isValidated = validNumber(value);
	    break;
	case WIDTH:
	    isValidated = validNumber(value);
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

}
