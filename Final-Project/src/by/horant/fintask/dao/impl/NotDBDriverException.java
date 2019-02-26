package by.horant.fintask.dao.impl;

public class NotDBDriverException extends RuntimeException{

    private static final long serialVersionUID = -6377177049958690611L;
    
    public NotDBDriverException() {
	super();
    }
    
    public NotDBDriverException(String message) {
	
    }
    
    public NotDBDriverException(Exception exception) {
	super(exception);
    }
    
    public NotDBDriverException(String message, Exception exception) {
	super(message, exception);
    }

}
