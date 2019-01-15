package by.tc.task01.service.validation.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import by.tc.task01.entity.criteria.SearchCriteria.TabletPC;
import by.tc.task01.service.validation.TabletPCValidator;

public class TabletPCValidatorImpl implements TabletPCValidator {

    @Override
    public boolean validTabletPcCriteria(String key, String value) {
	boolean isValidated;
	TabletPC tablet = Enum.valueOf(TabletPC.class, key);
	switch (tablet) {
	case BATTERY_CAPACITY:
	    isValidated = validNumber(value);
	    break;
	case DISPLAY_INCHES:
	    isValidated = validNumber(value);
	    break;
	case FLASH_MEMORY_CAPACITY:
	    isValidated = validNumber(value);
	    break;
	case MEMORY_ROM:
	    isValidated = validNumber(value);
	    break;
	case COLOR:
	    isValidated = validLine(value);
	    break;
	default:
	    isValidated = false;
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
