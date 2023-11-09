package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase trabaja creando insancias de si misma se forma statica para
 * asegurarse se que solo exista una instancia de de conexion, mientras la
 * instancia este se utilizara para conectarnos, si no se encuentra creara una
 * nueva a pedido este sistema de "crear objetos a pedido" se conoce como patron
 * FACTORY.
 *
 */
public class connectionFactory {

	/**
	 * No es extrictamente necesario que lleve el static de si mismo esto es una
	 * mescla con otro patron de sideño llama SINGLENTON que permite crear intancias
	 * de objetos que sean unicas para no tener miles de instancias sin uso, se
	 * complementa bien con FACTORY.
	 */
	private static connectionFactory fabrica = null;
	private Connection conn = null;

	/**
	 * El constructor tiene la peculiaridad de ser PRIVADO en el ambos patrones.
	 */
	private connectionFactory() {

	}

	public static connectionFactory getInstance()
	{
		if( fabrica == null)
		{
			fabrica = new connectionFactory();
		}
			
		return fabrica;
	}
	
	/**
	 * Aca bemos el claro funcionamiento del FACTORY, donde un metodo instancia un
	 * objeto de si mismo, para luego devolver tantas instancias de como sean
	 * pedidas, de alguna class en especial (o multiples clases con la misma
	 * interface)
	 *
	 * Ademas podemos conectarnos a distintas DB pidiendo diferentes conexiones.
	 *
	 * @return
	 */
	// public synchronized static ConnectionFactory getInstance() {
	public Connection getConection(String db) {

		switch (db) {
		case "MySQL":
				MySQL sql = new MySQL();
				conn = sql.getConnection();
			break;

		case "H2":
				H2 h2 = new H2();
				conn = h2.getConnection();
			break;
		}

		return conn;
	}

	/**
	 * mismo modelo que el getConecction pero usando singlenton para que la
	 * instacioa de coneccion a DB siempre sea una solo, ojo que solo se puede
	 * realizar 1 consulta a a vez con cada coneccion hasta que sea cerrada.
	 * 
	 * @return
	 */
	/*
	 * public Connection getConectionSinglentos() { if (conn == null) try { conn =
	 * DriverManager.getConnection(url, user, pass); } catch (SQLException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } return conn; }
	 */
}

class H2 {
	
	//private String driver = "jdbc:h2:tcp://localhost/~/tmp/h2db/ProgramacionSobreRedes";

	//private String db = "/test";
	//private String port = ":3306";
	//private String EngineDB = "mysql";
	//private String ip = "://localhost";

	private String url = "jdbc:h2:~/test";
	private String user = "sa";
	private String pass = "sa";
	
	Connection conn = null;


	public Connection getConnection() {

		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// clases anonimas
class MySQL {
	private String driver = "com.mysql.cj.jdbc.Driver";

	private String db = "/sistematienda";
	private String port = ":3306";
	private String EngineDB = "mysql";
	private String ip = "://localhost";

	private String url = "jdbc:".concat(EngineDB).concat(ip).concat(port).concat(db);
	private String user = "root";
	private String pass = "";
	
	Connection conn = null;

	public MySQL() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {

		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}