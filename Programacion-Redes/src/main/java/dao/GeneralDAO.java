package dao;

import java.util.LinkedList;

public interface GeneralDAO<T> {
	
	
	public int add( T item);

	public int add(LinkedList<T> lista);

	public int delete(T aBorrar) ;

	//public int delete(LinkedList<T> aBorrar);

	public int update(T registro) ;

	//public int update(LinkedList<T> registro) ;

	public LinkedList<T> getAll();
	public LinkedList<T> getAllH2();
	public int setAll(LinkedList<T> lista);
	public int setAllH2(LinkedList<T> lista);

	public T getById(int id);
	

	
	
}
