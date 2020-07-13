package by.svirski.lesson6.model.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.svirski.lesson6.model.exceptions.CustomStorageException;


public class StorageOfBooks {
	
	private static StorageOfBooks instance = null;
	private List<CustomBook> listOfBooks;
	private final int maxCountOfBooks;
	
	private StorageOfBooks(int maxCountOfBooks) {
		this.listOfBooks = new ArrayList<CustomBook>();
		this.maxCountOfBooks = maxCountOfBooks;
	}
	
	public static StorageOfBooks createStorage(int maxCountOfBooks) {
		if(!isExist()){
			instance = new StorageOfBooks(maxCountOfBooks);			
		}
		return instance;
	}
	
	public static StorageOfBooks getInstance() throws CustomStorageException {
		if(instance == null) {
			throw new CustomStorageException("storage is not exist");
		} 
		return instance;
	}
	
	private static boolean isExist() {
		return (instance != null) ? true : false;
	}
	
	public boolean addBookToStorage(CustomBook book) throws CustomStorageException {
		if(book != null) {			
			if(listOfBooks.contains(book)) {
				throw new CustomStorageException("book is already exist");
			}
			if(listOfBooks.size() + 1 <= maxCountOfBooks) {
				listOfBooks.add(book);
				return true;
			}
		} 
		return false;
	}
	
	public boolean removeBookFromStorage(CustomBook book) {
		if(book != null) {
			listOfBooks.remove(book);
			return true;
		}
		return false;
	}

	public List<CustomBook> getListOfBooks() {
		List<CustomBook> listOfBooksReadOnly = Collections.unmodifiableList(listOfBooks);
		return listOfBooksReadOnly;
	}
	
	public CustomBook findBookById(int id) throws CustomStorageException {
		for (CustomBook book : listOfBooks) {
			if(book.getBookId() == id) {
				return book;
			}
		}
		throw new CustomStorageException("book doesn't exist");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StorageOfBooks [listOfBooks=");
		builder.append(listOfBooks);
		builder.append(", maxCountOfBooks=");
		builder.append(maxCountOfBooks);
		builder.append("]");
		return builder.toString();
	}

}
