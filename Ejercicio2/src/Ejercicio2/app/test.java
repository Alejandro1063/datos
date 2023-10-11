package Ejercicio2.app;

import java.util.HashMap;
import java.util.Map;

import Ejercicio2.modelo.Clientes;
import Ejercicio2.services.ClientesService;
import Ejercicio2.services.ClientesServiceException;

public class test {

	public static void main(String[] args) {

ClientesService service = new ClientesService();
		
		
		try {

			Map<String, Clientes> map = new HashMap<String, Clientes>();

				map = service.consultarClientes();
				System.out.println(map.get("MARILYN.ROSS@sakilacustomer.org"));
				

		} catch (ClientesServiceException e) {

			e.printStackTrace();

		}
	}
}


