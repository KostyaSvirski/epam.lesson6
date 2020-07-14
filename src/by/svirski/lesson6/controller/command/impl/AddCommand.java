package by.svirski.lesson6.controller.command.impl;

import by.svirski.lesson6.controller.command.ActionCommand;
import by.svirski.lesson6.model.exception.CustomServiceException;
import by.svirski.lesson6.model.service.impl.AppServiceImpl;
import by.svirski.lesson6.response.CustomResponse;

public class AddCommand implements ActionCommand{

	@Override
	public CustomResponse execute(String request) {
		CustomResponse response = new CustomResponse();
		AppServiceImpl service = new AppServiceImpl();
		try {
			boolean result = service.addBook(request.split(" "));
			response.setResultOfCommand(result);
		} catch (CustomServiceException e) {
			response.setResultOfCommand(false);
		}
		return response;
	}
 
}
