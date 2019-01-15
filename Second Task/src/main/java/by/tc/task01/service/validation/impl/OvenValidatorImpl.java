package by.tc.task01.service.validation.impl;

import org.apache.commons.lang3.math.NumberUtils;

import by.tc.task01.entity.criteria.SearchCriteria.Oven;
import by.tc.task01.service.validation.OvenValidator;

public class OvenValidatorImpl implements OvenValidator {

    @Override
    public boolean validOvenCriteria(String key, String value) {
	boolean isValidated;
	Oven oven = Enum.valueOf(Oven.class, key);
	switch (oven) {
	case DEPTH:
	    isValidated = validNumber(value);
	    break;
	case CAPACITY:
	    isValidated = validNumber(value);
	    break;
	case HEIGHT:
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
