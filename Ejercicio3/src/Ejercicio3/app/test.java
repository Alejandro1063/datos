package Ejercicio3.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import Ejercicio3.modelo.Pago;
import Ejercicio3.services.PagosService;

public class test {

	public static void main(String[] args) {

		PagosService service = new PagosService();
		
		
		try {

			Map<String,  List<Pago>> map = new HashMap<String,  List<Pago>>();
			
				map = service.consultarPagos();
				
				System.out.print(map.get("MARILYN.ROSS@sakilacustomer.org"));
				

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}


