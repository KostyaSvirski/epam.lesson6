package by.svirski.lesson6.model.service.impl;

import java.util.List;
import java.util.TreeSet;

import by.svirski.lesson6.model.dao.impl.BookListDaoImpl;
import by.svirski.lesson6.model.entity.CustomBook;
import by.svirski.lesson6.model.entity.StorageOfBooks;
import by.svirski.lesson6.model.exception.CustomDaoException;
import by.svirski.lesson6.model.exception.CustomSelectionException;
import by.svirski.lesson6.model.exception.CustomServiceException;
import by.svirski.lesson6.model.service.CustomSelect;
import by.svirski.lesson6.model.service.CustomServiceInter;
import by.svirski.lesson6.model.service.CustomSort;
import by.svirski.lesson6.model.validator.impl.ValidatorDateImpl;
import by.svirski.lesson6.model.validator.impl.ValidatorNumberImpl;
import by.svirski.lesson6.model.validator.impl.ValidatorStringsImpl;

public class AppServiceImpl implements CustomServiceInter {

	@Override
	public StorageOfBooks createStorage(String capacity) throws CustomServiceException {
		BookListDaoImpl bookListDao = new BookListDaoImpl();
		ValidatorNumberImpl validator = new ValidatorNumberImpl();
		if (capacity.isEmpty()) {
			throw new CustomServiceException("empty input");
		}
		if (validator.validate(capacity)) {
			try {
				StorageOfBooks storage = bookListDao.createStorage(capacity);
				return storage;
			} catch (CustomDaoException e) {
				throw new CustomServiceException("error in dao: " + e.getMessage());
			}
		} else {
			throw new CustomServiceException("error in validation");
		}
	}

	@Override
	public boolean addBook(String... parameters) throws CustomServiceException {
		BookListDaoImpl bookListDao = new BookListDaoImpl();
		ValidatorStringsImpl validatorForStrings = new ValidatorStringsImpl();
		ValidatorDateImpl validatorForDate = new ValidatorDateImpl();

		for (int i = 0; i < parameters.length; i++) {
			if (parameters[i].isEmpty()) {
				throw new CustomServiceException("empty input");
			}
		}
		for (int i = 0; i < parameters.length; i++) {
			if (!validatorForStrings.validate(parameters[i]) && i != 3) {
				throw new CustomServiceException("not valid name");
			} else if (i == 3 && !validatorForDate.validate(parameters[i])) {
				throw new CustomServiceException("not valid date");
			}
		}

		try {
			return bookListDao.addBook(parameters);
		} catch (CustomDaoException e) {
			throw new CustomServiceException("error in dao: " + e.getMessage());
		}
	}

	@Override
	public boolean removeBook(String nameOfBook) throws CustomServiceException {
		ValidatorStringsImpl validator = new ValidatorStringsImpl();
		if (validator.validate(nameOfBook)) {
			BookListDaoImpl bookListDao = new BookListDaoImpl();
			List<CustomBook> listOfBooks;
			try {
				listOfBooks = bookListDao.sellectBookList();
				for (CustomBook book : listOfBooks) {
					if (book.getBookName().equalsIgnoreCase(nameOfBook)) {
						try {
							return bookListDao.removeBookById(book.getBookId());
						} catch (CustomDaoException e) {
							throw new CustomServiceException("error in dao: " + e.getMessage());
						}
					}
				}
			} catch (CustomDaoException e1) {
				throw new CustomServiceException("error in dao: " + e1.getMessage());
			}
		}
		return false;
	}

	@Override
	public TreeSet<CustomBook> sortByTag(String typeOfSortingStr) throws CustomServiceException {
		try {
			ValidatorStringsImpl validator = new ValidatorStringsImpl();
			CustomSort typeOfSorting;
			if (validator.validate(typeOfSortingStr)) {
				typeOfSorting = CustomSort.valueOf(typeOfSortingStr);
			} else {
				throw new CustomServiceException("error in validation");
			}
			BookListDaoImpl bookListDao = new BookListDaoImpl();
			List<CustomBook> listToSort = bookListDao.sellectBookList();
			TreeSet<CustomBook> sortedList;
			sortedList = switch (typeOfSorting) {
				case BY_ID -> CustomSort.BY_ID.sort(listToSort);
				case BY_NAME -> CustomSort.BY_NAME.sort(listToSort);
				case BY_AUTHOR -> CustomSort.BY_AUTHOR.sort(listToSort);
				case BY_GENRE -> CustomSort.BY_GENRE.sort(listToSort);
				case BY_DATE -> CustomSort.BY_DATE.sort(listToSort);
				case BY_PUBLISHING_HOUSE -> CustomSort.BY_PUBLISHING_HOUSE.sort(listToSort);
				default -> throw new CustomServiceException("not valid type of sorting");
			};
			return sortedList;
		} catch (CustomDaoException e) {
			throw new CustomServiceException("error in storage: " + e.getMessage());
		}
	}

	@Override
	public List<CustomBook> findBookByTag(String tag, String parameter) throws CustomServiceException {
		try {
			ValidatorStringsImpl validator = new ValidatorStringsImpl();
			CustomSelect typeOfSelection;
			if (validator.validate(tag)) {
				typeOfSelection = CustomSelect.valueOf(tag);
			} else {
				throw new CustomServiceException("error in validation");
			}
			BookListDaoImpl bookList = new BookListDaoImpl();
			List<CustomBook> listToCheck = bookList.sellectBookList();
			List<CustomBook> foundList;
			foundList = switch (typeOfSelection) {
				case BY_AUTHOR -> CustomSelect.BY_AUTHOR.exectuteSelection(listToCheck, parameter);
				case BY_NAME -> CustomSelect.BY_NAME.exectuteSelection(listToCheck, parameter);
				case BY_GENRE -> CustomSelect.BY_GENRE.exectuteSelection(listToCheck, parameter);
				case BY_DATE -> CustomSelect.BY_DATE.exectuteSelection(listToCheck, parameter);
				case BY_PUBLISHING_HOUSE -> CustomSelect.BY_PUBLISHING_HOUSE.exectuteSelection(listToCheck, parameter);
				default -> throw new CustomServiceException("not valid type of sorting");
			};
			return foundList;
		} catch (CustomDaoException | CustomSelectionException e) {
			throw new CustomServiceException("error in storage: " + e.getMessage());
		}
	}

}
