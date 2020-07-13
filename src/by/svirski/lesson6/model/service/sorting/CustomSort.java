package by.svirski.lesson6.model.service.sorting;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import by.svirski.lesson6.model.comparators.BookAuthorComparator;
import by.svirski.lesson6.model.comparators.BookIdComparator;
import by.svirski.lesson6.model.comparators.BookNameComparator;
import by.svirski.lesson6.model.comparators.GenreComparator;
import by.svirski.lesson6.model.comparators.PublishDateComparator;
import by.svirski.lesson6.model.comparators.PublishHouseComparator;
import by.svirski.lesson6.model.entities.CustomBook;

public enum CustomSort {

	BY_ID("id") {

		@Override
		public TreeSet<CustomBook> sort(List<CustomBook> listToSort) {
			Comparator<CustomBook> comp = new BookIdComparator();
			return executeSorting(comp, listToSort);
		}
	},

	BY_NAME("name") {

		@Override
		public TreeSet<CustomBook> sort(List<CustomBook> listToSort) {
			Comparator<CustomBook> comp = new BookNameComparator();
			return executeSorting(comp, listToSort);
		}
	},

	BY_AUTHOR("author") {

		@Override
		public TreeSet<CustomBook> sort(List<CustomBook> listToSort) {
			Comparator<CustomBook> comp = new BookAuthorComparator();
			return executeSorting(comp, listToSort);
		}
	},

	BY_GENRE("genre") {

		@Override
		public TreeSet<CustomBook> sort(List<CustomBook> listToSort) {
			Comparator<CustomBook> comp = new GenreComparator();
			return executeSorting(comp, listToSort);
		}
	},

	BY_DATE("date") {

		@Override
		public TreeSet<CustomBook> sort(List<CustomBook> listToSort) {
			Comparator<CustomBook> comp = new PublishDateComparator();
			return executeSorting(comp, listToSort);
		}
	},

	BY_PUBLISHING_HOUSE("publisher") {

		@Override
		public TreeSet<CustomBook> sort(List<CustomBook> listToSort) {
			Comparator<CustomBook> comp = new PublishHouseComparator();
			return executeSorting(comp, listToSort);
		}
	};
	
	private String typeOfSorting;
	
	

	public String getTypeOfSorting() {
		return typeOfSorting;
	}

	private CustomSort(String typeOfSorting) {
		this.typeOfSorting = typeOfSorting;
	}

	public abstract TreeSet<CustomBook> sort(List<CustomBook> listToSort);

	protected TreeSet<CustomBook> executeSorting(Comparator<CustomBook> comp, List<CustomBook> listToSort) {
		TreeSet<CustomBook> sortedList = new TreeSet<CustomBook>(comp);
		for (CustomBook book : listToSort) {
			sortedList.add(book);
		}
		return sortedList;
	}

}
