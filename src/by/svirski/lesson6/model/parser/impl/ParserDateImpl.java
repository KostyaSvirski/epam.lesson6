package by.svirski.lesson6.model.parser.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;

import by.svirski.lesson6.model.exceptions.CustomParseException;
import by.svirski.lesson6.model.parser.CustomParserInter;

public class ParserDateImpl implements CustomParserInter<Calendar>{

	@Override
	public Calendar parse(String sourceValue) throws CustomParseException {
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
	//TODO 09.07.2020 0:49 correct number in date
	

}
