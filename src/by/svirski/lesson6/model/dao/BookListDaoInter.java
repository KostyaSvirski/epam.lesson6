package by.svirski.lesson6.model.dao;

import java.util.List;

import by.svirski.lesson6.model.entity.CustomBook;
import by.svirski.lesson6.model.entity.StorageOfBooks;
import by.svirski.lesson6.model.exception.CustomDaoException;
import by.svirski.lesson6.model.exception.CustomStorageException;

public interface BookListDaoInter {
	
	StorageOfBooks createStorage(String capacity) throws CustomDaoException;
	boolean addBook(String...parameters) throws CustomDaoException, CustomStorageException;
	boolean removeBookById(int id) throws CustomDaoException;
	List<CustomBook> sellectBookList() throws CustomDaoException;
	
}
