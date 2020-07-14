package by.svirski.lesson6.controller.command;

import by.svirski.lesson6.response.CustomResponse;

public interface ActionCommand {
	
	CustomResponse execute(String request);
}
