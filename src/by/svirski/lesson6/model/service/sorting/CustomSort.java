package by.svirski.lesson6.model.service.sorting;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import by.svirski.lesson6.model.comparator.BookNameComparator;
import by.svirski.lesson6.model.comparator.GenreComparator;
import by.svirski.lesson6.model.comparator.PublishDateComparator;
import by.svirski.lesson6.model.comparator.PublishHouseComparator;
import by.svirski.lesson6.model.entity.CustomBook;

public enum CustomSort {

	BY_ID {

		@Override
		public TreeSet<CustomBook> sort(List<CustomBook> listToSort) {
			return null;
		}
	},

	BY_NAME {

		@Override
		public TreeSet<CustomBook> sort(List<CustomBook> listToSort) {
			Comparator<CustomBook> comp = new BookNameComparator();
			return sortingList(comp, listToSort);
		}
	},

	BY_AUTHOR {

		@Override
		public TreeSet<CustomBook> sort(List<CustomBook> listToSort) {
			//TODO 08.07.2020 19:14 author sorting
			return null;
		}
	},

	BY_GENRE {

		@Override
		public TreeSet<CustomBook> sort(List<CustomBook> listToSort) {
			Comparator<CustomBook> comp = new GenreComparator();
			return sortingList(comp, listToSort);
		}
	},

	BY_DATE {

		@Override
		public TreeSet<CustomBook> sort(List<CustomBook> listToSort) {
			Comparator<CustomBook> comp = new PublishDateComparator();
			return sortingList(comp, listToSort);
		}
	},

	BY_PUBLISHING_HOUSE {

		@Override
		public TreeSet<CustomBook> sort(List<CustomBook> listToSort) {
			Comparator<CustomBook> comp = new PublishHouseComparator();
			return sortingList(comp, listToSort);
		}
	};

	public abstract TreeSet<CustomBook> sort(List<CustomBook> listToSort);

	protected TreeSet<CustomBook> sortingList(Comparator<CustomBook> comp, List<CustomBook> listToSort) {
		TreeSet<CustomBook> sortedList = new TreeSet<CustomBook>(comp);
		for (CustomBook book : listToSort) {
			sortedList.add(book);
		}
		return sortedList;
	}

}
