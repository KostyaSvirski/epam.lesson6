package by.svirski.lesson6.model.creator;

import by.svirski.lesson6.model.exception.CustomCreationException;
import by.svirski.lesson6.model.exception.CustomValidationException;

public interface CustomCreatorInter<T> {
	
	T create(String... parameters) throws CustomCreationException, CustomValidationException;

}
