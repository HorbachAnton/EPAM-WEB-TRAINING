package by.tc.task01.service.validation;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria.Laptop;
import by.tc.task01.entity.criteria.SearchCriteria.Oven;
import by.tc.task01.entity.criteria.SearchCriteria.Refrigerator;
import by.tc.task01.entity.criteria.SearchCriteria.Speakers;
import by.tc.task01.entity.criteria.SearchCriteria.TabletPC;
import by.tc.task01.entity.criteria.SearchCriteria.VacuumCleaner;
import by.tc.task01.service.validation.impl.LaptopValidatorImpl;
import by.tc.task01.service.validation.impl.OvenValidatorImpl;
import by.tc.task01.service.validation.impl.RefrigeratorValidatorImpl;
import by.tc.task01.service.validation.impl.SpeakersValidatorImpl;
import by.tc.task01.service.validation.impl.TabletPCValidatorImpl;
import by.tc.task01.service.validation.impl.VacuumCleanerValidatorImpl;

public class CriteriaValidator {

    private static final LaptopValidator laptopValidator = new LaptopValidatorImpl();
    private static final OvenValidator ovenValidator = new OvenValidatorImpl();
    private static final RefrigeratorValidator regrigeratorValidator = new RefrigeratorValidatorImpl();
    private static final SpeakersValidator speakersValidator = new SpeakersValidatorImpl();
    private static final TabletPCValidator tabletPcValidator = new TabletPCValidatorImpl();
    private static final VacuumCleanerValidator vacuumCleanerValidator = new VacuumCleanerValidatorImpl();

    private CriteriaValidator() {

    }

    public static <E> boolean valid(Criteria<E> criteria) {
	boolean isValidated = true;
	Set<Map.Entry<E, Object>> set = criteria.getEntry();
	Iterator<Map.Entry<E, Object>> iterator = set.iterator();
	while (iterator.hasNext()) {
	    Map.Entry<E, Object> entry = iterator.next();
	    isValidated = validProduct(entry);
	}
	return isValidated;
    }

    private static <E> boolean validProduct(Map.Entry<E, Object> entry) {
	boolean isValidated;
	String keyClass = entry.getKey().getClass().getSimpleName();
	String key = entry.getKey().toString();
	String value = entry.getValue().toString();
	if (keyClass.equals(Oven.class.getSimpleName())) {
	    isValidated = ovenValidator.validOvenCriteria(key, value);
	} else if (keyClass.equals(Laptop.class.getSimpleName())) {
	    isValidated = laptopValidator.validLaptopCriteria(key, value);
	} else if (keyClass.equals(Refrigerator.class.getSimpleName())) {
	    isValidated = regrigeratorValidator.validRefrigeratorCriteria(key, value);
	} else if (keyClass.equals(VacuumCleaner.class.getSimpleName())) {
	    isValidated = vacuumCleanerValidator.validVacuumCleanerCriteria(key, value);
	} else if (keyClass.equals(TabletPC.class.getSimpleName())) {
	    isValidated = tabletPcValidator.validTabletPcCriteria(key, value);
	} else if (keyClass.equals(Speakers.class.getSimpleName())) {
	    isValidated = speakersValidator.validSpeakersCriteria(key, value);
	} else {
	    isValidated = false;
	}
	return isValidated;
    }

}
