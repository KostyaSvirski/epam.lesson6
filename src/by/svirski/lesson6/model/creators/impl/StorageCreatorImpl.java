package by.svirski.lesson6.model.creators.impl;

import by.svirski.lesson6.model.creators.CustomCreatorInter;
import by.svirski.lesson6.model.entities.StorageOfBooks;
import by.svirski.lesson6.model.exceptions.CustomCreationException;
import by.svirski.lesson6.model.exceptions.CustomParseException;
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
