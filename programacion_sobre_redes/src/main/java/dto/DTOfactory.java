package dto;

import java.sql.ResultSet;
import java.util.ArrayList;

//SINGLETON
//nos asegura una unica instancia de un objeto 
public class DTOfactory {
	
	private static DTOfactory factory = null;
	private generalDTO dto = null;
	private DTOfactory() {
		
	}
	
	public static DTOfactory getInstance() {  //crea la clase
		if(factory == null) {
			factory =  new DTOfactory();
		}
		return factory;
		
	}
	public generalDTO getDTO(String type) {
		try {
			switch(type) {
			case "empleado":
				dto = new empleadoDTO();			
				return dto;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public generalDTO getDTO(String type, ResultSet rs) {
		try {
			switch(type) {
			case "empleado":
				dto = new empleadoDTO(rs.getInt("id"), rs.getString("nombre"), rs.getString("dni"), rs.getString("rol"));			
				return dto;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public generalDTO getDTO(String type, ArrayList<Object>arr) {
		try {
			switch(type) {
			case "empleado":
				dto = new empleadoDTO((int)arr.get(0) , (String)arr.get(1) , (String)arr.get(2) , (String)arr.get(3));			
				return dto;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
