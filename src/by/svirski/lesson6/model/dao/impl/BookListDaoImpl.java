package by.svirski.lesson6.model.dao.impl;

import java.util.List;
import java.util.TreeSet;

import by.svirski.lesson6.model.creator.impl.BookCreatorImpl;
import by.svirski.lesson6.model.creator.impl.StorageCreatorImpl;
import by.svirski.lesson6.model.dao.BookListDaoInter;
import by.svirski.lesson6.model.entity.CustomBook;
import by.svirski.lesson6.model.entity.StorageOfBooks;
import by.svirski.lesson6.model.exception.CustomCreationException;
import by.svirski.lesson6.model.exception.CustomDaoException;
import by.svirski.lesson6.model.exception.CustomStorageException;
import by.svirski.lesson6.model.exception.CustomValidationException;
import by.svirski.lesson6.model.service.sorting.CustomSort;

//TODO 08.07.2020 22:43 dao
public class BookListDaoImpl implements BookListDaoInter {

	@Override
	public StorageOfBooks createStorage(String capacity) throws CustomDaoException {
		StorageCreatorImpl storageCreator = new StorageCreatorImpl();
		try {
			StorageOfBooks storage = storageCreator.create(capacity);
			return storage;
		} catch (CustomCreationException e) {
			throw new CustomDaoException("error in creation" + e.getMessage());
		} catch (CustomValidationException e) {
			throw new CustomDaoException("error in validation data" + e.getMessage());
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
	public TreeSet<CustomBook> sortByTag(int typeOfSorting) throws CustomDaoException {
		try {
			StorageOfBooks storage = StorageOfBooks.getInstance();
			List<CustomBook> listToSort = storage.getListOfBooks();
			TreeSet<CustomBook> sortedList;
			switch (typeOfSorting) {
			case 1: {
				sortedList = CustomSort.BY_ID.sort(listToSort);
				return sortedList;
			}
			case 2: {
				sortedList = CustomSort.BY_NAME.sort(listToSort);
				return sortedList;
			}
			case 3: {
				sortedList = CustomSort.BY_AUTHOR.sort(listToSort);
				return sortedList;
			}
			case 4: {
				sortedList = CustomSort.BY_GENRE.sort(listToSort);
				return sortedList;
			}
			case 5: {
				sortedList = CustomSort.BY_DATE.sort(listToSort);
				return sortedList;
			}
			case 6: {
				sortedList = CustomSort.BY_PUBLISHING_HOUSE.sort(listToSort);
				return sortedList;
			}
			default: {
				throw new CustomDaoException("not valid type of sorting");
			}
			}
		} catch (CustomStorageException e) {
			throw new CustomDaoException("error in storage: " + e.getMessage());
		}
	}

	@Override
	public List<CustomBook> findBookByTag(int tagToFind) {
		// TODO 09.07.2020 1:42 find book by tag
		return null;
	}

}
