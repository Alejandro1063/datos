package ejercicio1.app;

import java.util.List;

import ejercicio1.modelo.Pelicula;
import ejercicio1.services.PeliculasService;
import ejercicio1.services.PeliculasServiceException;

public class test {

	public static void main(String[] args) {
		
		PeliculasService service = new PeliculasService();
		
		
		try {

			List<Pelicula> Pelicula = service.consultarPelicula();

			for (Pelicula peliculas : Pelicula) {

				System.out.println(peliculas);

			}

		} catch (PeliculasServiceException e) {

			e.printStackTrace();

		}
	}

}
