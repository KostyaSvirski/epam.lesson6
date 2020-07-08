package by.svirski.lesson6.model.parser;

import by.svirski.lesson6.model.exception.CustomParseException;

public interface CustomParserInter<T> {
	
	T parse(String sourceValue) throws CustomParseException;
}
