package ejemploJdbc1.app;

import java.util.List;
import java.util.Scanner;

import ejemploJdbc1.modelo.Actor;
import ejemploJdbc1.servicios.ActoresServiceException;
import ejemploJdbc1.servicios.ActoresServices;

public class App {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ActoresServices service = new ActoresServices();
		List<Actor> actores;
		try {
			actores = service.consultarActores();
			for (Actor actor : actores) {
				System.out.println(actor);
			}

		} catch (ActoresServiceException e) {
			
			e.printStackTrace();
		}

		scanner.close();
	}
}
