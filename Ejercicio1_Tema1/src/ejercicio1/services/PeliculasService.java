package ejercicio1.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import ejercicio1.dao.PeliculasDao;
import ejercicio1.modelo.Pelicula;

public class PeliculasService {

	private OpenConnection openConn;

	public PeliculasService() {
		openConn = new OpenConnection();
	}
	public List<Pelicula> consultarPelicula() throws PeliculasServiceException {

		Connection conn = null;
		

		try {
			List<Pelicula> peliculas = new ArrayList<Pelicula>();
			conn = openConn.getConection();

			PeliculasDao dao = new PeliculasDao();

			peliculas = dao.consultarPelicula(conn);
			
			Iterator<Pelicula> it = peliculas.iterator();
			
			while (it.hasNext()) {
				if (it.next().getLongitud() > 100) {
					
					it.remove();
				}
				
			}
			return peliculas;
		} 
			catch (SQLException e) {

			System.err.println("Ha habido un error en la base de datos : " + e.getMessage());

			throw new PeliculasServiceException("Error al obtener actores de la bbdd", e);
		}

		finally {
			try {
				conn.close();
			} catch (Exception e) {
			}

		}
		

	}

}