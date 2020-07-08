package by.svirski.lesson6.model.service;

import by.svirski.lesson6.model.entity.CustomBook;

public interface FindServiceInterface {
	
	CustomBook findByTag(String tag);

}
