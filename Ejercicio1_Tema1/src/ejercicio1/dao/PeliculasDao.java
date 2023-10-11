package ejercicio1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejercicio1.modelo.Pelicula;

public class PeliculasDao {

	
	public List<Pelicula> consultarPelicula(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Pelicula> peliculas = new ArrayList<Pelicula>();
			String sql = "select * from film";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pelicula a = new Pelicula();
				a.setTitulo(rs.getString("title")); 
				a.setFilm_id(rs.getInt("film_id"));
				a.setLongitud(rs.getInt("length"));
				peliculas.add(a);
			}
			return peliculas;
		}
		finally {
			try {
				stmt.close();
			}catch(Exception e) {}
		}

	}

}

