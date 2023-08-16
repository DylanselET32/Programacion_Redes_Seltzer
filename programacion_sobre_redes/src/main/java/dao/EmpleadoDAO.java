package dao;

import java.io.PrintStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import Principal.ConnectionFactory;
import dto.DTOfactory;
import dto.empleadoDTO;
import dto.generalDTO;

public class EmpleadoDAO {
	//Muy parecido a hacer CRUD pero para un solo DTO (osea tabla)
	
	
	//agregar
	
	//obtener
	
	public empleadoDTO getEmpleadoById(int id) {
		return null;
	}
	
	public static LinkedList<empleadoDTO> getAllEmpleados() {
		
		ConnectionFactory DB = new ConnectionFactory();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PrintStream consola = new PrintStream(System.out);
		LinkedList<empleadoDTO> empleados= new LinkedList<empleadoDTO>();
		
		String consulta = "SELECT * from empleado";
		try {
			ps = DB.conn.prepareStatement(consulta);
			
			rs =  ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String rol = rs.getString("rol");
				empleadoDTO empleado = (empleadoDTO)DTOfactory.getInstance().getDTO("empleado");
				empleado.setId(id);
				empleado.setApellido(apellido);
				empleado.setNombre(nombre);
				empleado.setRol(rol);
				
		
				empleados.add(empleado);
			}
			
		
		return empleados;
		}catch (Exception e) {
			consola.println(e);
			return null;
		}finally {
			try {
				DB.close(rs,ps);
			} catch (Exception e2) {
				consola.println(e2);
			}
			
		}
			
	}
	
	//borrar 
	
	//actualizar
	
	
}
