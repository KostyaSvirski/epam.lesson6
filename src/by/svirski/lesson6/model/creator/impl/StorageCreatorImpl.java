package by.svirski.lesson6.model.creator.impl;

import by.svirski.lesson6.model.creator.CustomCreatorInter;
import by.svirski.lesson6.model.entity.StorageOfBooks;
import by.svirski.lesson6.model.exception.CustomCreationException;
import by.svirski.lesson6.model.exception.CustomParseException;
import by.svirski.lesson6.model.exception.CustomValidationException;
import by.svirski.lesson6.model.parser.impl.ParserNumberImpl;
import by.svirski.lesson6.model.validator.AbstractValidator;
import by.svirski.lesson6.model.validator.impl.ValidatorNumberImpl;

public class StorageCreatorImpl implements CustomCreatorInter<StorageOfBooks> {

	@Override
	public StorageOfBooks create(String... parameters) throws CustomCreationException, CustomValidationException {
		AbstractValidator validatorForNumbers = new ValidatorNumberImpl();
		for (String par : parameters) {
			if (par.isEmpty()) {
				throw new CustomCreationException("input is empty");
			}
		}
		if(validatorForNumbers.validate(parameters[0])) {
			ParserNumberImpl parser = new ParserNumberImpl();
			StorageOfBooks storageOfBooks;
			try {
				storageOfBooks = StorageOfBooks.createStorage(parser.parse(parameters[0]));
			} catch (CustomParseException e) {
				throw new CustomCreationException(e.getMessage());
			}			
			return storageOfBooks;
		} else {
			throw new CustomValidationException("not valid number");
		}
	}

}
