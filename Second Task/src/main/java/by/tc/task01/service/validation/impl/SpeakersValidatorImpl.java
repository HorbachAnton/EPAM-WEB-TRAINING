package by.tc.task01.service.validation.impl;

import org.apache.commons.lang3.math.NumberUtils;

import by.tc.task01.entity.criteria.SearchCriteria.Speakers;
import by.tc.task01.service.validation.SpeakersValidator;

public class SpeakersValidatorImpl implements SpeakersValidator {

    public boolean validSpeakersCriteria(String key, String value) {
	boolean isValidated;
	Speakers speaker = Enum.valueOf(Speakers.class, key);
	switch (speaker) {
	case CORD_LENGTH:
	    isValidated = validNumber(value);
	    break;
	case FREQUENCY_RANGE:
	    isValidated = validNumber(value);
	    break;
	case NUMBER_OF_SPEAKERS:
	    isValidated = validNumber(value);
	    break;
	case POWER_CONSUMPTION:
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
