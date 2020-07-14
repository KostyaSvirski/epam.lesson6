package by.svirski.lesson6.model.comparator;

import java.util.Comparator;

import by.svirski.lesson6.model.entity.CustomBook;

public class BookIdComparator implements Comparator<CustomBook>{

	@Override
	public int compare(CustomBook o1, CustomBook o2) {
		if(o1.getBookId() < o2.getBookId()) {
			return -1;
		} else if(o1.getBookId() > o2.getBookId()) {
			return 1;
		}
		return 0;
	}

}
