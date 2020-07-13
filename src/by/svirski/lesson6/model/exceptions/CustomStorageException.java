package by.svirski.lesson6.model.exceptions;

public class CustomStorageException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public CustomStorageException() {

	}

	public CustomStorageException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomStorageException(Throwable cause) {
		super(cause);
	}

	public CustomStorageException(String message) {
		super(message);
	}
	
}
