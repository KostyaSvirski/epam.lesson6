package by.svirski.lesson6.model.exception;

public class CustomDaoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public CustomDaoException() {

	}

	public CustomDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomDaoException(Throwable cause) {
		super(cause);
	}

	public CustomDaoException(String message) {
		super(message);
	}
	
}
