package by.horant.fintask.service;

public class ServiceException extends Exception {

    private static final long serialVersionUID = 2871715511446888080L;

    public ServiceException() {
	super();
    }

    public ServiceException(String message) {
	super(message);
    }

    public ServiceException(Exception exception) {
	super(exception);
    }

    public ServiceException(String message, Exception exception) {
	super(message, exception);
    }

}
