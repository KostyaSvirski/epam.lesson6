package by.svirski.lesson6.model.validators;

public abstract class AbstractValidator {
	
	protected static final String REGEX_STRING = "[A-Za-z1-9 ]{0,256}";
	protected static final String REGEX_DATE = "[0-9]{1,2}.[0-9]{1,2}.[0-9]{4}";
	protected static final String REGEX_NUMBER = "[0-9]{1,3}";
	
	public abstract boolean validate(String value);
}
