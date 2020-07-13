package by.svirski.lesson6.model.creators.impl;

import by.svirski.lesson6.model.creators.CustomCreatorInter;
import by.svirski.lesson6.model.entities.CustomBook;
import by.svirski.lesson6.model.exceptions.CustomCreationException;
import by.svirski.lesson6.model.exceptions.CustomParseException;
import by.svirski.lesson6.model.exceptions.CustomValidationException;
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
