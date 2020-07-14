package by.svirski.lesson6.controller.provider;

import by.svirski.lesson6.controller.command.ActionCommand;
import by.svirski.lesson6.controller.command.impl.DefaultCommand;
import by.svirski.lesson6.type.TypeOfCommand;

public class CommandProvider {
	
	public static ActionCommand defineCommand(String command) {
		TypeOfCommand[] values = TypeOfCommand.values();
		for(TypeOfCommand value : values) {
			if(command.equals(value.name())) {
				return value.getCommand();
			}
		}
		return new DefaultCommand();
		
	}

}
