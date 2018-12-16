package by.epam.javawebtraining.horbachanton.tasks.task1.model.exception;

public class NegativeRadiusException extends Exception {

    private static final long serialVersionUID = -139575604627660201L;

    public NegativeRadiusException(String message) {
	super(message);
    }
    
    public NegativeRadiusException(Exception exception) {
	super(exception);
    }

    public NegativeRadiusException(String message, Exception exception) {
	super(message, exception);
    }
}
