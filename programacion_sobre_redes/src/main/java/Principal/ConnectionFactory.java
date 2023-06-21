package Principal;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public ConnectionFactory() {
			Connection conn = null;
			
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
			}
			
			//CONSULTAS 
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
					int rol = rs.getInt("rol");
					
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
	
	
	
}




/*
 
  Create Database usuarios;
 USE usuarios;
 CREATE TABLE `empleado` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
 
 
 
 */