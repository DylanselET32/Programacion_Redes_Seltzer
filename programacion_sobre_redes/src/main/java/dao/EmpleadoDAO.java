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
	
	 ConnectionFactory.getInstance()
	
	
	//obtener
	
	public empleadoDTO getEmpleadoById(int id) {
		return null;
	}
	
	public static LinkedList<empleadoDTO> getAllEmpleados() {
		
		
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

	
	//agregar 
public static int addEmpleado(empleadoDTO empleado) {
		
		ConnectionFactory DB = new ConnectionFactory();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PrintStream consola = new PrintStream(System.out);
		
		String consulta = "INSERT INTO `empleado`(`nombre`, `apellido`, `rol`) VALUES (?,?,?)";
		
		try {
			ps = DB.conn.prepareStatement(consulta);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido());
			ps.setString(3, empleado.getRol());
			
		return  ps.executeUpdate();
		
			
		}catch (Exception e) {
			consola.println(e);
			return 0;
		}finally {
			try {
				DB.close(rs,ps);
			} catch (Exception e2) {
				consola.println(e2);
			}
			
		}
			
	}


	//borrar 
public static int deleteEmpleado(empleadoDTO empleado) {
	
	ConnectionFactory DB = new ConnectionFactory();
	PreparedStatement ps = null;
	ResultSet rs = null;
	PrintStream consola = new PrintStream(System.out);
	
	String consulta = "DELETE INTO empleado WHERE id = ?";
	
	try {
		ps = DB.conn.prepareStatement(consulta);
		ps.setInt(1, empleado.getId() );
	return  ps.executeUpdate();
	
		
	}catch (Exception e) {
		consola.println(e);
		return 0;
	}finally {
		try {
			DB.close(rs,ps);
		} catch (Exception e2) {
			consola.println(e2);
		}
		
	}
		
}
	//actualizar
public static int editEmpleado(empleadoDTO empleado) {
	
	ConnectionFactory DB = new ConnectionFactory();
	PreparedStatement ps = null;
	ResultSet rs = null;
	PrintStream consola = new PrintStream(System.out);
	
	String consulta = "UPDATE empleado SET nombre= ? , apellido=? , rol=? WHERE id=?";
	
	try {
		ps = DB.conn.prepareStatement(consulta);
		ps.setString(1, empleado.getNombre());
		ps.setString(2, empleado.getApellido());
		ps.setString(3, empleado.getRol());
		ps.setInt(4, empleado.getId());
		
	return  ps.executeUpdate();
	
		
	}catch (Exception e) {
		consola.println(e);
		return 0;
	}finally {
		try {
			DB.close(rs,ps);
		} catch (Exception e2) {
			consola.println(e2);
		}
		
	}
		
}
	
}
