package by.svirski.lesson6.model.creator.impl;

import by.svirski.lesson6.model.creator.CustomCreatorInter;
import by.svirski.lesson6.model.entity.CustomBook;
import by.svirski.lesson6.model.exception.CustomCreationException;
import by.svirski.lesson6.model.exception.CustomParseException;
import by.svirski.lesson6.model.exception.CustomValidationException;
import by.svirski.lesson6.model.parser.ParserDate;
import by.svirski.lesson6.model.validator.impl.ValidatorDate;
import by.svirski.lesson6.model.validator.impl.ValidatorStrings;

public class BookCreator implements CustomCreatorInter<CustomBook> {

	private ValidatorDate validatorForDate;
	private ValidatorStrings validatorForStrings;

	// TODO 08.07.2020 22:42 fix maybe
	@Override
	public CustomBook create(String... parameters) throws CustomCreationException, CustomValidationException {
		for (int i = 0; i < parameters.length; i++) {
			if (parameters[i].isEmpty()) {
				throw new CustomCreationException("empty input");
			}
		}
		for (int i = 0; i < parameters.length; i++) {
			if (!validatorForStrings.validate(parameters[i]) && i != 3) {
				throw new CustomValidationException("not valid name");
			} else if(i == 3 && !validatorForDate.validate(parameters[i])) {
				throw new CustomValidationException("not valid date");
			}
		}
		CustomBook newBook = new CustomBook();
		newBook.setBookId();
		newBook.setBookName(parameters[0]);
		newBook.setAuthors(parameters[1].split(" "));
		newBook.setGenre(parameters[2]);
		try {
			newBook.setPublishDate(ParserDate.parseDate(parameters[3]));
		} catch (CustomParseException e) {
			throw new CustomCreationException(e.getMessage());
		}
		newBook.setPublishHouse(parameters[4]);
		return newBook;
	}

}
