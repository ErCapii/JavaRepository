package ServicioPeliculas.Service;

import java.sql.Connection;
import java.sql.DriverManager;


public class ServiceDao {
	
	public Connection abrirConexion() {
		String urlConexion = "jdbc:mariadb://127.0.0.1:3306/sakila";
		String driver = "org.mariadb.jdbc.Driver";
		String usuario = "sakila";
		String password = "sakila";

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(urlConexion, usuario, password);
			return conn;

		} catch (Exception e) {
			System.err.println("No he podido abrir la conexión. " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("No puedo conectarme a la BBDD");
		}

	}

	public void testConexion() {
		Connection conn = abrirConexion();
		System.out.println("Esta es mi conexion: " + conn);
		if (conn != null) {
			System.out.println("Todo ok");
		} else {
			System.out.println("Esto no rula...");
		}
	}
	
	
}
