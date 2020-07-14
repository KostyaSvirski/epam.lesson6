package by.svirski.lesson6.model.creator.impl;

import by.svirski.lesson6.model.creator.CustomCreatorInter;
import by.svirski.lesson6.model.entity.StorageOfBooks;
import by.svirski.lesson6.model.exception.CustomCreationException;
import by.svirski.lesson6.model.exception.CustomParseException;
import by.svirski.lesson6.model.parser.impl.ParserNumberImpl;

public class StorageCreatorImpl implements CustomCreatorInter<StorageOfBooks> {

	@Override
	public StorageOfBooks create(String... parameters) throws CustomCreationException {
		
		ParserNumberImpl parser = new ParserNumberImpl();
		StorageOfBooks storageOfBooks;
		try {
			storageOfBooks = StorageOfBooks.createStorage(parser.parse(parameters[0]));
		} catch (CustomParseException e) {
			throw new CustomCreationException(e.getMessage());
		}
		return storageOfBooks;
	}

}
