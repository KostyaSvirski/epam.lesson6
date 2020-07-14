package by.svirski.lesson6.response;

import java.util.List;
import java.util.TreeSet;

import by.svirski.lesson6.model.entity.CustomBook;

public class CustomResponse {

	private String command;
	private TreeSet<CustomBook> sortedList;
	private List<CustomBook> listFound;
	private boolean resultOfCommand;

	public CustomResponse() {
		command = "";
		sortedList = null;
		listFound = null;
		resultOfCommand = false;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public void setSortedList(TreeSet<CustomBook> sortedList) {
		this.sortedList = sortedList;
	}

	public void setListFound(List<CustomBook> listFound) {
		this.listFound = listFound;
	}

	public void setResultOfCommand(boolean resultOfCommand) {
		this.resultOfCommand = resultOfCommand;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomResponse [command=");
		builder.append(command);
		if (sortedList != null) {
			builder.append(", sortedList=");
			builder.append(sortedList);
		}
		if (listFound != null) {
			builder.append(", listFound=");
			builder.append(listFound);
		}
		if (resultOfCommand != false) {
			builder.append(", resultOfCommand=");
			builder.append(resultOfCommand);
		}
		builder.append("]");
		return builder.toString();
	}

}
