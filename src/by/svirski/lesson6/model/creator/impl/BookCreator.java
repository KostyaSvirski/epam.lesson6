package by.svirski.lesson6.model.creator.impl;

import by.svirski.lesson6.model.creator.CustomCreatorInter;
import by.svirski.lesson6.model.entity.CustomBook;
import by.svirski.lesson6.model.validator.impl.ValidatorDate;
import by.svirski.lesson6.model.validator.impl.ValidatorNumber;
import by.svirski.lesson6.model.validator.impl.ValidatorStrings;

public class BookCreator implements CustomCreatorInter<CustomBook>{
	
	private ValidatorDate validatorForDate;
	private ValidatorNumber validatorForNumbers;
	private ValidatorStrings validatorForStrings;

	@Override
	public CustomBook create(String... parameters) {
		for(int i = 0; i < parameters.length; i++) {
			if(i == 1) {
				 
			}
		}
		return null;
	}
	
}
