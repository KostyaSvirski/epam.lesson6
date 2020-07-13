package by.svirski.lesson6.model.service;

import java.util.List;
import java.util.TreeSet;

import by.svirski.lesson6.model.entities.CustomBook;
import by.svirski.lesson6.model.entities.StorageOfBooks;
import by.svirski.lesson6.model.exceptions.CustomServiceException;
import by.svirski.lesson6.model.exceptions.CustomValidationException;

public interface CustomServiceInter {
	StorageOfBooks createStorage(String capacity) throws CustomServiceException;

	boolean addBook(String... parameters) throws CustomServiceException;

	boolean removeBookById(int id) throws CustomServiceException;

	TreeSet<CustomBook> sortByTag(String typeOfSorting) throws CustomServiceException, CustomValidationException;

	List<CustomBook> findBookByTag(String tagToFind) throws CustomServiceException;
}