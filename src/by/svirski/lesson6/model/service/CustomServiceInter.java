package by.svirski.lesson6.model.service;

import java.util.List;
import java.util.TreeSet;

import by.svirski.lesson6.model.entity.CustomBook;
import by.svirski.lesson6.model.entity.StorageOfBooks;
import by.svirski.lesson6.model.exception.CustomServiceException;
import by.svirski.lesson6.model.exception.CustomValidationException;

public interface CustomServiceInter {
	StorageOfBooks createStorage(String capacity) throws CustomServiceException;

	boolean addBook(String... parameters) throws CustomServiceException;

	boolean removeBookById(int id) throws CustomServiceException;

	TreeSet<CustomBook> sortByTag(String typeOfSorting) throws CustomServiceException, CustomValidationException;

	List<CustomBook> findBookByTag(String tagToFind) throws CustomServiceException;
}