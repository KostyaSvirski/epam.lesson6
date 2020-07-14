package by.svirski.lesson6.controller.invoker;

import by.svirski.lesson6.controller.command.ActionCommand;
import by.svirski.lesson6.controller.provider.CommandProvider;
import by.svirski.lesson6.response.CustomResponse;

public class Invoker {

	public CustomResponse executeRequest(String request) {
		String[] parsedRequest = request.split(" ", 2);
		ActionCommand command = CommandProvider.defineCommand(parsedRequest[0].toUpperCase());
		CustomResponse response = command.execute(parsedRequest[1]);
		return response;
	}
}
