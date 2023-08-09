package dto;


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
		
		switch(type) {
		case "empleado":
			dto = new empleadoDTO(0,type,type,type);
			break;
		}
		return null;
	}
}
