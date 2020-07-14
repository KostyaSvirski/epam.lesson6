package by.svirski.lesson6.model.service.impl;

import java.util.List;
import java.util.TreeSet;

import by.svirski.lesson6.model.dao.impl.BookListDaoImpl;
import by.svirski.lesson6.model.entity.CustomBook;
import by.svirski.lesson6.model.entity.StorageOfBooks;
import by.svirski.lesson6.model.exception.CustomDaoException;
import by.svirski.lesson6.model.exception.CustomParseException;
import by.svirski.lesson6.model.exception.CustomServiceException;
import by.svirski.lesson6.model.parser.impl.ParserNumberImpl;
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

	//TODO 14.07.2020 18:42 parameters remove
	@Override
	public boolean removeBookById(int id) throws CustomServiceException {
		BookListDaoImpl bookListDao = new BookListDaoImpl();
		try {
			return bookListDao.removeBookById(id);
		} catch (CustomDaoException e) {
			throw new CustomServiceException("error in dao: " + e.getMessage());
		}
	}
	
	//TODO 13.07.2020 15:36 switch arguments to commands
	@Override
	public TreeSet<CustomBook> sortByTag(String typeOfSortingStr) throws CustomServiceException {
		try {
			ValidatorNumberImpl validator = new ValidatorNumberImpl();

			ParserNumberImpl parser = new ParserNumberImpl();
			int typeOfSorting;
			try {
				if (validator.validate(typeOfSortingStr)) {
					typeOfSorting = parser.parse(typeOfSortingStr);
				} else {
					throw new CustomServiceException("error in validation");
				}
			} catch (CustomParseException e) {
				throw new CustomServiceException("error in parsing: " + e.getMessage());
			}
			BookListDaoImpl bookListDao = new BookListDaoImpl();
			List<CustomBook> listToSort = bookListDao.sellectBookList();
			TreeSet<CustomBook> sortedList;
			switch (typeOfSorting) {
			case 1: {
				sortedList = CustomSort.BY_ID.sort(listToSort);
				break;
			}
			case 2: {
				sortedList = CustomSort.BY_NAME.sort(listToSort);
				break;
			}
			case 3: {
				sortedList = CustomSort.BY_AUTHOR.sort(listToSort);
				break;
			}
			case 4: {
				sortedList = CustomSort.BY_GENRE.sort(listToSort);
				break;
			}
			case 5: {
				sortedList = CustomSort.BY_DATE.sort(listToSort);
				break;
			}
			case 6: {
				sortedList = CustomSort.BY_PUBLISHING_HOUSE.sort(listToSort);
				break;
			}
			default: {
				throw new CustomServiceException("not valid type of sorting");
			}
			}
			return sortedList;
		} catch (CustomDaoException e) {
			throw new CustomServiceException("error in storage: " + e.getMessage());
		}
	}
	
	//TODO 13.07.2020 15:37 switch arguments to commands
	@Override
	public List<CustomBook> findBookByTag(String tag) throws CustomServiceException {
		//TODO 13.07.2020 15:40 find book by tag
		return null;
	}

}
