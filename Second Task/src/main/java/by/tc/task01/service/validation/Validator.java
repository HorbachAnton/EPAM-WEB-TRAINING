package by.tc.task01.service.validation;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria.Laptop;
import by.tc.task01.entity.criteria.SearchCriteria.Oven;
import by.tc.task01.entity.criteria.SearchCriteria.Refrigerator;
import by.tc.task01.entity.criteria.SearchCriteria.Speakers;
import by.tc.task01.entity.criteria.SearchCriteria.TabletPC;
import by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner;

public class Validator {

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {
	boolean isValidated = true;
	Set<Map.Entry<E, Object>> set = criteria.getEntry();
	Iterator<Map.Entry<E, Object>> iterator = set.iterator();
	while (iterator.hasNext()) {
	    Map.Entry<E, Object> entry = iterator.next();
	    isValidated = checkEntry(entry, isValidated);
	}

	return isValidated;
    }

    private static <E> boolean checkEntry(Map.Entry<E, Object> entry, boolean isValidated) {
	String keyClass = entry.getKey().getClass().getSimpleName();
	if (keyClass.equals(Oven.class.getSimpleName())) {
	    isValidated = chekOven(entry, isValidated);
	} else if (keyClass.equals(Laptop.class.getSimpleName())) {
	    isValidated = chekLaptop(entry, isValidated);
	} else if (keyClass.equals(Refrigerator.class.getSimpleName())) {
	    isValidated = chekRefrigerator(entry, isValidated);
	} else if (keyClass.equals(VacuumCleaner.class.getSimpleName())) {
	    isValidated = checkVacuumCleaner(entry, isValidated);
	} else if (keyClass.equals(TabletPC.class.getSimpleName())) {
	    isValidated = checkTabletPC(entry, isValidated);
	} else if (keyClass.equals(Speakers.class.getSimpleName())) {
	    isValidated = checkSpeakers(entry, isValidated);
	} else {
	    isValidated = false;
	}
	return isValidated;
    }

    private static <E> boolean checkSpeakers(Entry<E, Object> entry, boolean isValidated) {
	String key = entry.getKey().toString();
	String value = entry.getValue().toString();
	if (Speakers.CORD_LENGTH.getName().equals(key) || Speakers.FREQUENCY_RANGE.getName().equals(key)
		|| Speakers.NUMBER_OF_SPEAKERS.getName().equals(key)
		|| Speakers.POWER_CONSUMPTION.getName().equals(key)) {
	    checkNumber(value, isValidated);
	} else {
	    isValidated = false;
	}
	return isValidated;
    }

    private static <E> boolean checkTabletPC(Entry<E, Object> entry, boolean isValidated) {
	String key = entry.getKey().toString();
	String value = entry.getValue().toString();
	if (TabletPC.BATTERY_CAPACITY.getName().equals(key) || TabletPC.DISPLAY_INCHES.getName().equals(key)
		|| TabletPC.FLASH_MEMORY_CAPACITY.getName().equals(key) || TabletPC.MEMORY_ROM.getName().equals(key)) {
	    checkNumber(value, isValidated);
	} else if (TabletPC.COLOR.getName().equals(key)) {
	    checkString(value, isValidated);
	} else {
	    isValidated = false;
	}
	return isValidated;

    }

    private static <E> boolean checkVacuumCleaner(Entry<E, Object> entry, boolean isValidated) {
	String key = entry.getKey().toString();
	String value = entry.getValue().toString();
	if (VacuumCleaner.BAG_TYPE.getName().equals(key) || VacuumCleaner.CLEANING_WIDTH.getName().equals(key)
		|| VacuumCleaner.FILTER_TYPE.getName().equals(key)
		|| VacuumCleaner.MOTOR_SPEED_REGULATION.getName().equals(key)
		|| VacuumCleaner.POWER_CONSUMPTION.getName().equals(key)) {

	} else if (VacuumCleaner.WAND_TYPE.getName().equals(key)) {
	    checkString(value, isValidated);
	}
	return isValidated;

    }

    private static <E> boolean chekRefrigerator(Entry<E, Object> entry, boolean isValidated) {
	String key = entry.getKey().toString();
	String value = entry.getValue().toString();
	if (Refrigerator.FREEZER_CAPACITY.getName().equals(key) || Refrigerator.HEIGHT.getName().equals(key)
		|| Refrigerator.OVERALL_CAPACITY.getName().equals(key)
		|| Refrigerator.POWER_CONSUMPTION.getName().equals(key) || Refrigerator.WEIGHT.getName().equals(key)
		|| Refrigerator.WIDTH.getName().equals(key)) {
	    checkNumber(value, isValidated);
	} else {
	    isValidated = false;
	}
	return isValidated;

    }

    private static <E> boolean chekLaptop(Entry<E, Object> entry, boolean isValidated) {
	String key = entry.getKey().toString();
	String value = entry.getValue().toString();
	if (Laptop.BATTERY_CAPACITY.getName().equals(key) || Laptop.CPU.getName().equals(key)
		|| Laptop.DISPLAY_INCHS.getName().equals(key) || Laptop.MEMORY_ROM.getName().equals(key)
		|| Laptop.OS.getName().equals(key) || Laptop.SYSTEM_MEMORY.getName().equals(key)) {
	    checkNumber(value, isValidated);
	} else {
	    isValidated = false;
	}
	return isValidated;

    }

    private static <E> boolean chekOven(Entry<E, Object> entry, boolean isValidated) {
	String key = entry.getKey().toString();
	String value = entry.getValue().toString();
	if (Oven.DEPTH.getName().equals(key) || Oven.CAPACITY.getName().equals(key) || Oven.HEIGHT.getName().equals(key)
		|| Oven.POWER_CONSUMPTION.getName().equals(key) || Oven.WEIGHT.getName().equals(key)
		|| Oven.WIDTH.getName().equals(key)) {
	    checkNumber(value, isValidated);
	} else {
	    isValidated = false;
	}
	return isValidated;
    }

    private static boolean checkNumber(String value, boolean isValidated) {
	if (NumberUtils.isParsable(value)) {
	    if (!(NumberUtils.toDouble(value) > 0)) {
		isValidated = false;
	    }
	} else {
	    isValidated = false;
	}
	return isValidated;
    }

    private static boolean checkString(String value, boolean isValidated) {
	if (StringUtils.isNumeric(value)) {
	    isValidated = false;
	}
	return isValidated;
    }

}
