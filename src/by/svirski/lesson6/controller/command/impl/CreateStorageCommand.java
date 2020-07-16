package by.svirski.lesson6.controller.command.impl;

import by.svirski.lesson6.controller.command.ActionCommand;
import by.svirski.lesson6.model.entity.StorageOfBooks;
import by.svirski.lesson6.model.exception.CustomServiceException;
import by.svirski.lesson6.model.service.impl.AppServiceImpl;
import by.svirski.lesson6.response.CustomResponse;

public class CreateStorageCommand implements ActionCommand{

	@Override
	public CustomResponse execute(String request) {
		CustomResponse response = new CustomResponse();
		AppServiceImpl service = new AppServiceImpl();
		try {
			StorageOfBooks storage = service.createStorage(request);
			response.setResultOfExecution(true);
		} catch (CustomServiceException e) {
			response.setError(true);
		}
		return response;
	}
	
	
}
