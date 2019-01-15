package by.tc.task01.service.validation.impl;

import org.apache.commons.lang3.math.NumberUtils;

import by.tc.task01.entity.criteria.SearchCriteria.Laptop;
import by.tc.task01.service.validation.LaptopValidator;

public class LaptopValidatorImpl implements LaptopValidator {

    @Override
    public boolean validLaptopCriteria(String key, String value) {
	boolean isValidated;
	Laptop laptop = Enum.valueOf(Laptop.class, key);
	switch (laptop) {
	case BATTERY_CAPACITY:
	    isValidated = validNumber(value);
	    break;
	case CPU:
	    isValidated = validNumber(value);
	    break;
	case DISPLAY_INCHS:
	    isValidated = validNumber(value);
	    break;
	case MEMORY_ROM:
	    isValidated = validNumber(value);
	    break;
	case OS:
	    isValidated = validNumber(value);
	    break;
	case SYSTEM_MEMORY:
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
