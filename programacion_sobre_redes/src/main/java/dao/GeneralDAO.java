package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public interface GeneralDAO<T> {
	
	public int add( T item);

	public int delete(T aBorrar) ;

	public int delete(LinkedList<T> aBorrar);

	public int edit(T registro) ;

	public LinkedList<T> getAll();

	public T getEmpleado(int id);

}

	
	
