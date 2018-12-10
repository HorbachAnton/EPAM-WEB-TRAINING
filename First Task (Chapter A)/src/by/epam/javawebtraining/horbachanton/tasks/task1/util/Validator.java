package by.epam.javawebtraining.horbachanton.tasks.task1.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static final String MARKER_START_BALL = "Ball: «";
    public static final String MARKER_END_BALL = "»";
    public static final String REGEX_BALL = "^\\d+\\.\\d+\\s\\d+\\.\\d+\\s\\d+\\.\\d+\\s\\d+\\.\\d+$";
    private int amountObjects;

    public String validateBall(String[] date) {
	Pattern pattern = Pattern.compile(REGEX_BALL);
	Matcher matcher;
	StringBuilder builder = new StringBuilder();
	for (int i = 0; i < date.length; i++) {
	    date[i] = date[i].replaceAll(MARKER_START_BALL, "");
	    date[i] = date[i].replaceAll(MARKER_END_BALL, "");
	    matcher = pattern.matcher(date[i]);
	    if (matcher.matches()) {
		builder.append(date[i] + " ");
		amountObjects += 1;
	    }
	}
	return builder.toString();
    }

    public int getAmountObjects() {
	return amountObjects;
    }

    public void setAmountObjects(int amountObjects) {
	this.amountObjects = amountObjects;
    }

}
