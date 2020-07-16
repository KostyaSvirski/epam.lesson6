package by.svirski.lesson6.controller.command.impl;

import by.svirski.lesson6.controller.command.ActionCommand;
import by.svirski.lesson6.model.exception.CustomServiceException;
import by.svirski.lesson6.model.service.impl.AppServiceImpl;
import by.svirski.lesson6.response.CustomResponse;

public class RemoveCommand implements ActionCommand{

	@Override
	public CustomResponse execute(String request) {
		AppServiceImpl service = new AppServiceImpl();
		CustomResponse response = new CustomResponse();
		try {
			boolean result = service.removeBook(request);
			response.setResultOfExecution(result);
		} catch (CustomServiceException e) {
			response.setError(true);
		}
		return response;
	}

}
