package by.svirski.lesson6.model.parser;

import java.util.Calendar;
import java.util.GregorianCalendar;

import by.svirski.lesson6.model.exception.CustomParseException;

public class ParserDate {

	public static Calendar parseDate(String sourceValue) throws CustomParseException {
		String[] values = sourceValue.split(".");
		if (Integer.parseInt(values[2]) <= 2020 && Integer.parseInt(values[2]) >= 1800) {
			if (Integer.parseInt(values[1]) > 0 && Integer.parseInt(values[2]) <= 12) {
				if (Integer.parseInt(values[0]) >= 1 && Integer.parseInt(values[0]) <= 31) {
					Calendar date = new GregorianCalendar(Integer.parseInt(values[2]), Integer.parseInt(values[1]),
							Integer.parseInt(values[0]));
					return date;
				}
			}
		}
		throw new CustomParseException("error in parsing of date"); 
	}

}
