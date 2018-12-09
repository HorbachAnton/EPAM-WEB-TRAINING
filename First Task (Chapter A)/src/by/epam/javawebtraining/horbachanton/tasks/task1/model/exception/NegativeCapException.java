package by.epam.javawebtraining.horbachanton.tasks.task1.model.exception;

public class NegativeCapException extends Exception {

    private static final long serialVersionUID = -3002361474187005128L;

    public NegativeCapException(String message) {
	super(message);
    }

    public NegativeCapException(String message, Exception exception) {
	super(message, exception);
    }

}
