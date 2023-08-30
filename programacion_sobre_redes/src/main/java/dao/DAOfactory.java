package dao;

public class DAOfactory {

	private static DAOfactory fabrica = null;

	private static EmpleadoDAO empleado = null;

	private DAOfactory() {

	}

	public static DAOfactory getInstance() {
		if (fabrica == null)
			fabrica = new DAOfactory();

		return fabrica;
	}

	public  GeneralDAO getDAO(String type) {
		switch (type) {
		case "empleado":
			if (empleado == null)
				empleado = new EmpleadoDAO();
			
		return (GeneralDAO) empleado;
		
	}
		return null;
	}
	
}