package dao;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import Principal.connectionFactory;
import dto.DTOfactory;
import dto.empleadoDTO;
import dto.generalDTO;

public class EmpleadoDAO implements GeneralDAO<empleadoDTO>{
	//Muy parecido a hacer CRUD pero para un solo DTO (osea tabla)
	
	 
	
	
	//obtener
	
	public empleadoDTO getEmpleadoById(int id) {
		return null;
	}
	
	public  LinkedList<empleadoDTO> getAll() {
		
		Connection DB = connectionFactory.getInstance().getConection("MySQL");
		PreparedStatement ps = null;
		ResultSet rs = null;
		PrintStream consola = new PrintStream(System.out);
		LinkedList<empleadoDTO> empleados= new LinkedList<empleadoDTO>();
		
		String consulta = "SELECT * from empleado";
		try {
			ps = DB.prepareStatement(consulta);
			
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
				rs.close();
				ps.close();
				DB.close();
			} catch (Exception e2) {
				consola.println(e2);
			}
			
		}
			
	}

	
	//agregar 
public int add(empleadoDTO empleado) {
		
	Connection DB = connectionFactory.getInstance().getConection("MySQL");
		PreparedStatement ps = null;
		PrintStream consola = new PrintStream(System.out);
		
		String consulta = "INSERT INTO `empleado`(`nombre`, `apellido`, `rol`) VALUES (?,?,?)";
		
		try {
			ps = DB.prepareStatement(consulta);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido());
			ps.setString(3, empleado.getRol());
			
			
		return  ps.executeUpdate();
		
			
		}catch (Exception e) {
			consola.println(e);
			return 0;
		}finally {
			try {
				ps.close();
				DB.close();
			} catch (Exception e2) {
				consola.println(e2);
			}
			
		}
			
	}


	//borrar 
public int delete(empleadoDTO empleado) {
	
	Connection DB = connectionFactory.getInstance().getConection("MySQL");
	PreparedStatement ps = null;
	PrintStream consola = new PrintStream(System.out);
	
	String consulta = "DELETE INTO empleado WHERE id = ?";
	
	try {
		ps = DB.prepareStatement(consulta);
		ps.setInt(1, empleado.getId() );
	return  ps.executeUpdate();
	
		
	}catch (Exception e) {
		consola.println(e);
		return 0;
	}finally {
		try {
			ps.close();
			DB.close();
		} catch (Exception e2) {
			consola.println(e2);
		}
		
	}
		
}
	//actualizar
public int edit(empleadoDTO empleado) {
	
	Connection DB = connectionFactory.getInstance().getConection("MySQL");
	PreparedStatement ps = null;
	PrintStream consola = new PrintStream(System.out);
	
	String consulta = "UPDATE empleado SET nombre= ? , apellido=? , rol=? WHERE id=?";
	
	try {
		ps = DB.prepareStatement(consulta);
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
			ps.close();
			DB.close();
		} catch (Exception e2) {
			consola.println(e2);
		}
		
	}
		
}

@Override
public int delete(LinkedList<empleadoDTO> aBorrar) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public empleadoDTO getEmpleado(int id) {
	// TODO Auto-generated method stub
	return null;
}
	
}
