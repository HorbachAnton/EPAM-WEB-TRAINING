package by.horant.fintask.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is a utility class to verify compliance with the password and
 * email sent by the user.
 * 
 * @author Anton Horbach
 *
 */
public class CredentionalValidator {

    private static final Pattern CORRECT_EMAIL_EXPRESSION = Pattern.compile(
	    "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    private static final Pattern CORRECT_PASSWORD_EXPRESSION = Pattern
	    .compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");

    private CredentionalValidator() {

    }

    /**
     * Checks password and email for compliance.
     * 
     * @param email    email we want to check.
     * @param password password we want to check.
     * @return true - if email and password are correct, false if they aren't
     *         correct.
     */
    public static boolean isCorrect(String email, String password) {
	return isEmailCorrect(email) && isPasswordCorrect(password);
    }

    /**
     * Checks email for compliance.
     * 
     * @param email email we want to check.
     * @return true - if email is correct, false - if email isn't correct.
     */
    private static boolean isEmailCorrect(String email) {
	Matcher m = CORRECT_EMAIL_EXPRESSION.matcher(email);
	return m.matches();
    }

    /**
     * Checks password for compliance.
     * 
     * @param password password we want to check.
     * @return true - if password is correct, false - if password isn't correct.
     */
    private static boolean isPasswordCorrect(String password) {
	Matcher m = CORRECT_PASSWORD_EXPRESSION.matcher(password);
	return m.matches();
    }

}
