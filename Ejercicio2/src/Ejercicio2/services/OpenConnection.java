package Ejercicio2.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OpenConnection {

	public Connection getConection() throws SQLException {

		String urlConexion = "jdbc:mariadb://localhost:3306/sakila";
		String claseDriver = "org.mariadb.jdbc.Driver";
		String usuario = "sakila";
		String password = "sakila";
		try {
			Class.forName(claseDriver);

		} catch (ClassNotFoundException e) {

			System.err.println("No se encuentra el driver JDBC. Revisa tu configuracion");
			throw new RuntimeException(e.getMessage(), e);
		}
		Connection conn = DriverManager.getConnection(urlConexion, usuario, password);
		return conn;
	}

}
