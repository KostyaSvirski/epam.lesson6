package by.svirski.lesson6.controller.command.impl;

import java.util.TreeSet;

import by.svirski.lesson6.controller.command.ActionCommand;
import by.svirski.lesson6.model.entity.CustomBook;
import by.svirski.lesson6.model.exception.CustomServiceException;
import by.svirski.lesson6.model.service.impl.AppServiceImpl;
import by.svirski.lesson6.response.CustomResponse;

public class SortCommand implements ActionCommand{
	
	@Override
	public CustomResponse execute(String request) {
		CustomResponse response = new CustomResponse();
		AppServiceImpl service = new AppServiceImpl();
		try {
			TreeSet<CustomBook> sortedList = service.sortByTag(request);
			response.setSortedList(sortedList);
		} catch (CustomServiceException e) {
			response.setError(true);
		}
		return response;
	}

}
