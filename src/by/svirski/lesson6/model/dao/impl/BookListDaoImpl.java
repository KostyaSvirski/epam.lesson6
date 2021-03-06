package by.svirski.lesson6.model.dao.impl;

import java.util.List;

import by.svirski.lesson6.model.creator.impl.BookCreatorImpl;
import by.svirski.lesson6.model.creator.impl.StorageCreatorImpl;
import by.svirski.lesson6.model.dao.BookListDaoInter;
import by.svirski.lesson6.model.entity.CustomBook;
import by.svirski.lesson6.model.entity.StorageOfBooks;
import by.svirski.lesson6.model.exception.CustomCreationException;
import by.svirski.lesson6.model.exception.CustomDaoException;
import by.svirski.lesson6.model.exception.CustomStorageException;
import by.svirski.lesson6.model.exception.CustomValidationException;

public class BookListDaoImpl implements BookListDaoInter {

	@Override
	public StorageOfBooks createStorage(String capacity) throws CustomDaoException {
		StorageCreatorImpl storageCreator = new StorageCreatorImpl();
		try {
			StorageOfBooks storage = storageCreator.create(capacity);
			return storage;
		} catch (CustomCreationException e) {
			throw new CustomDaoException("error in creation " + e.getMessage());
		}
	}

	@Override
	public boolean addBook(String... parameters) throws CustomDaoException {
		try {
			StorageOfBooks storage = StorageOfBooks.getInstance();
			BookCreatorImpl bookCreator = new BookCreatorImpl();
			try {
				CustomBook book = bookCreator.create(parameters);
				try {
					return storage.addBookToStorage(book);
				} catch (CustomStorageException e) {
					throw new CustomStorageException("error adding: " + e.getMessage());
				}
			} catch (CustomCreationException e) {
				throw new CustomDaoException("error in creation: " + e.getMessage());
			} catch (CustomValidationException e) {
				throw new CustomDaoException("error in validation data" + e.getMessage());
			}
		} catch (CustomStorageException e) {
			throw new CustomDaoException("error in storage: " + e.getMessage());
		}

	}

	@Override
	public boolean removeBookById(int id) throws CustomDaoException {
		try {
			StorageOfBooks storage = StorageOfBooks.getInstance();
			CustomBook bookToRemove = storage.findBookById(id);
			return storage.removeBookFromStorage(bookToRemove);
		} catch (CustomStorageException e) {
			throw new CustomDaoException("error in storage: " + e.getMessage());
		}
	}

	@Override
	public List<CustomBook> sellectBookList() throws CustomDaoException {
		try {
			StorageOfBooks storage = StorageOfBooks.getInstance();
			return storage.getListOfBooks();
		} catch (CustomStorageException e) {
			throw new CustomDaoException("error in storage: " + e.getMessage());
		}
	}

}
