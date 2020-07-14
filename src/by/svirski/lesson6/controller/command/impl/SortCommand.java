package by.svirski.lesson6.controller.command.impl;

import java.util.TreeSet;

import by.svirski.lesson6.controller.command.ActionCommand;
import by.svirski.lesson6.model.entity.CustomBook;
import by.svirski.lesson6.model.exception.CustomServiceException;
import by.svirski.lesson6.model.service.impl.AppServiceImpl;
import by.svirski.lesson6.response.CustomResponse;

public class SortCommand implements ActionCommand{
	
	//TODO 14.07.2020 18:38 switch argument in service
	@Override
	public CustomResponse execute(String request) {
		CustomResponse response = new CustomResponse();
		AppServiceImpl service = new AppServiceImpl();
		try {
			TreeSet<CustomBook> sortedList = service.sortByTag("1");
			response.setSortedList(sortedList);
		} catch (CustomServiceException e) {
			response.setSortedList(null);
		}
		return response;
	}

}
