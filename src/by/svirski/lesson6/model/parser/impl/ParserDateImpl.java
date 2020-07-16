package by.svirski.lesson6.model.parser.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;

import by.svirski.lesson6.model.exception.CustomParseException;
import by.svirski.lesson6.model.parser.CustomParserInter;

public class ParserDateImpl implements CustomParserInter<Calendar> {

	@Override
	public Calendar parse(String sourceValue) throws CustomParseException {
		String[] values = sourceValue.split(".");
		Calendar date = new GregorianCalendar();
		if (Integer.parseInt(values[2]) <= 2020 && Integer.parseInt(values[2]) >= 1800) {
			date.set(Calendar.YEAR, Integer.parseInt(values[2]));
			if (Integer.parseInt(values[1]) >= date.getActualMinimum(Calendar.MONTH)
					&& Integer.parseInt(values[1]) <= date.getActualMaximum(Calendar.MONTH)) {
				date.set(Calendar.MONTH, Integer.parseInt(values[1]));
				if (Integer.parseInt(values[0]) >= date.getActualMinimum(Calendar.DAY_OF_MONTH)
						&& Integer.parseInt(values[0]) <= date.getActualMaximum(Calendar.DAY_OF_MONTH)) {
					date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(values[0]));
					return date;
				}

			}
		}
		throw new CustomParseException("error in parsing");
	}

}
