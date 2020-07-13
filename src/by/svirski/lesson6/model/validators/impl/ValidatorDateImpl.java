package by.svirski.lesson6.model.validators.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.svirski.lesson6.model.validators.AbstractValidator;

public class ValidatorDateImpl extends AbstractValidator {

	@Override
	public boolean validate(String value) {
		Pattern pattern = Pattern.compile(REGEX_DATE);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

}
