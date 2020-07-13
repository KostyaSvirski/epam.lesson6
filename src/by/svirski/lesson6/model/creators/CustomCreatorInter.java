package by.svirski.lesson6.model.creators;

import by.svirski.lesson6.model.exceptions.CustomCreationException;
import by.svirski.lesson6.model.exceptions.CustomValidationException;

public interface CustomCreatorInter<T> {
	
	T create(String... parameters) throws CustomCreationException, CustomValidationException;

}
