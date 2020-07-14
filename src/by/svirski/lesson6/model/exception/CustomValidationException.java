package by.svirski.lesson6.model.exception;

public class CustomValidationException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public CustomValidationException() {

	}

	public CustomValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomValidationException(Throwable cause) {
		super(cause);
	}

	public CustomValidationException(String message) {
		super(message);
	}
}
