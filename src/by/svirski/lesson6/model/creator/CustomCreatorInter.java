package by.svirski.lesson6.model.creator;

public interface CustomCreatorInter<T> {
	
	T create(String... parameters);

}
