package by.svirski.lesson6.model.comparator;

import java.util.Comparator;

import by.svirski.lesson6.model.entity.CustomBook;

public class PublishDateComparator implements Comparator<CustomBook>{

	@Override
	public int compare(CustomBook o1, CustomBook o2) {
		return o1.getPublishDate().compareTo(o2.getPublishDate());
		
	}

}
