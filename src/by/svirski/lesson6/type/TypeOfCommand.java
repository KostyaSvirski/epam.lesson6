package by.svirski.lesson6.type;

import by.svirski.lesson6.controller.command.ActionCommand;
import by.svirski.lesson6.controller.command.impl.AddCommand;
import by.svirski.lesson6.controller.command.impl.FindCommand;
import by.svirski.lesson6.controller.command.impl.RemoveCommand;
import by.svirski.lesson6.controller.command.impl.SortCommand;

public enum TypeOfCommand {
	
	ADD_COMMAND(new AddCommand()),
	REMOVE_COMMANAD(new SortCommand()),
	SORT_COMMAND(new RemoveCommand()),
	FIND_COMMAND(new FindCommand());
	
	private ActionCommand command;

	private TypeOfCommand(ActionCommand command) {
		this.command = command;
	}

	public ActionCommand getCommand() {
		return command;
	}

}
