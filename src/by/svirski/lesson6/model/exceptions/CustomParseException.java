package by.svirski.lesson6.model.exceptions;

public class CustomParseException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CustomParseException() {

	}

	public CustomParseException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CustomParseException(Throwable cause) {
		super(cause);
	}

	public CustomParseException(String message) {
		super(message);
	}	
}
