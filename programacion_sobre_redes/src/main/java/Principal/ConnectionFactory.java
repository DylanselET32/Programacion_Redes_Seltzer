package Principal;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	private Connection conn = null;
	private static ConnectionFactory connectionFactory = null;
	
	private ConnectionFactory() {
	
	}
	
	
	@SuppressWarnings("finally")
	public Connection getConn(){
		//CONEXION BDD
		try {
			//Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String BDD_hostName= "localhost:3306/"; 
		String BDD_Name= "usuarios"; 
		String BDD_userName= "root"; 
		String BDD_password= ""; 
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://"+BDD_hostName+BDD_Name,BDD_userName,BDD_password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			return conn;
		}
	}
	
	public static ConnectionFactory getInstance() {
		if (connectionFactory == null)
			connectionFactory = new ConnectionFactory();
		return connectionFactory;
	}
	
	
	public void close(ResultSet rs ,PreparedStatement ps) {
		
		try {
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
	public  void leerDatos(){
		PreparedStatement ps = null;
		PrintStream consola = new PrintStream(System.out);
		String consulta = "SELECT * from empleado ";
		try {
			ps = conn.prepareStatement(consulta);
			//ps.setString(1, "empleado");
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String rol = rs.getString("rol");
				
				consola.println("Nombre: "+nombre);
				consola.println("apellido: "+apellido);
				consola.println("roll: "+rol);
				
				if(rs.isLast()) {
					consola.println("\n Cantidad de resultados: "+rs.getRow());
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void agregar(String nombre,String apellido,String rol){
		PreparedStatement ps = null;
		PrintStream consola = new PrintStream(System.out);
		String consulta = "INSERT INTO `empleado`(`nombre`, `apellido`, `rol`) VALUES (?,?,?)";
		try {
			ps = conn.prepareStatement(consulta);
			ps.setString(1, nombre);
			ps.setString(2, apellido);
			ps.setString(3, rol);
			int rs =  ps.executeUpdate();
			if(rs >=0) {
				consola.println("se agrego correctamente");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}




/*
 
 DROP DATABASE  IF EXISTS usuarios;
 Create Database usuarios;
 USE usuarios;
 CREATE TABLE `empleado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `rol` varchar(20) NOT NULL,
   PRIMARY KEY (id)
)
 
 
 */