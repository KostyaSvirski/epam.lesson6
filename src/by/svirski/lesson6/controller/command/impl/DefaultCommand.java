package by.svirski.lesson6.controller.command.impl;

import by.svirski.lesson6.controller.command.ActionCommand;
import by.svirski.lesson6.response.CustomResponse;

public class DefaultCommand implements ActionCommand{

	@Override
	public CustomResponse execute(String request) {
		return new CustomResponse();
	}

}
