package by.svirski.lesson6.model.creator.impl;

import by.svirski.lesson6.model.creator.CustomCreatorInter;
import by.svirski.lesson6.model.entity.CustomBook;
import by.svirski.lesson6.model.exception.CustomCreationException;
import by.svirski.lesson6.model.exception.CustomParseException;
import by.svirski.lesson6.model.exception.CustomValidationException;
import by.svirski.lesson6.model.parser.impl.ParserDateImpl;

public class BookCreatorImpl implements CustomCreatorInter<CustomBook> {
	@Override
	public CustomBook create(String... parameters) throws CustomCreationException, CustomValidationException {
	
		CustomBook newBook = new CustomBook();
		newBook.setBookId();
		newBook.setBookName(parameters[0]);
		newBook.setAuthors(parameters[1].split(" "));
		newBook.setGenre(parameters[2]);
		try {
			ParserDateImpl parserDate = new ParserDateImpl();
			newBook.setPublishDate(parserDate.parse(parameters[3]));
		} catch (CustomParseException e) {
			throw new CustomCreationException(e.getMessage());
		}
		newBook.setPublishHouse(parameters[4]);
		return newBook;
	}

}
