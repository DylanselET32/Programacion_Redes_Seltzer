package dto;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DTOfactory {

	private static DTOfactory factory = null;
	private generalDTO dto = null;

	private DTOfactory() {
		super();
	}
	
	//patron SINGLENTON
	//nos asegura una unica instancia de un objeto
	public static DTOfactory getInstance() {
		if (factory == null)
			factory = new DTOfactory();

		return factory;
	}

	// Patron FACTORY
	public generalDTO getDTO(String type, ResultSet rs) {
		try {
			switch (type) {
			case "stock":
				dto = new stockDTO(rs.getInt("id"), rs.getString("nombre"), rs.getString("descripcion"), rs.getDouble("precio_compra"),rs.getDouble("precio_venta"),rs.getInt("cantidad"),rs.getBoolean("discontinuo"));					
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dto;
	}

	
	// Patron FACTORY
	public generalDTO getDTO(String type) {
		switch (type) {
		case "stock":
				dto = new stockDTO();
			break;

		}

		return dto;
	}

}
