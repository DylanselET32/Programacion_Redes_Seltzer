package Principal;

import java.io.PrintStream;
import java.util.LinkedList;

import dao.EmpleadoDAO;
import dto.empleadoDTO;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintStream ps = new PrintStream(System.out);
		ConnectionFactory DB = new ConnectionFactory();
		DB.agregar("juan", "montiel", "empleado");
		
		LinkedList<empleadoDTO> empleados =  EmpleadoDAO.getAllEmpleados();
		for(empleadoDTO e: empleados) {
			ps.println(e.toString());
		}
	
	}
	

}
