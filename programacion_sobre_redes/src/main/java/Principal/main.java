package Principal;

import java.io.PrintStream;
import java.util.LinkedList;

import dao.DAOfactory;
import dao.EmpleadoDAO;
import dto.DTOfactory;
import dto.empleadoDTO;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintStream ps = new PrintStream(System.out);
		empleadoDTO empleado = (empleadoDTO)DTOfactory.getInstance().getDTO("empleado");
		empleado.setId(0);
		empleado.setNombre("Dylan");
		empleado.setApellido("Sel");
		empleado.setRol("2");
		DAOfactory.getInstance().getDAO("empleado").add(empleado);
		
		LinkedList<empleadoDTO> empleados =  DAOfactory.getInstance().getDAO("empleado").getAll();
		for(empleadoDTO e: empleados) {
			ps.println(e.toString());
		}
	
	}
	

}
