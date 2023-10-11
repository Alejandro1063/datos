package Ejercicio3.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ejercicio3.dao.ClientesDao;
import Ejercicio3.dao.PagosDao;
import Ejercicio3.modelo.Clientes;
import Ejercicio3.modelo.Pago;

public class PagosService {
	
	private OpenConnection openConn;

	public PagosService() {
		openConn = new OpenConnection();
	}
	
	public Map<String, List<Pago>> consultarPagos() throws PagosServiceException {

		Connection conn = null;
		

		try {
			List<Clientes> client = new ArrayList<Clientes>();
			Map<String,  List<Pago>> map = new HashMap<String,  List<Pago>>();
			List<Pago> listaPagos = new ArrayList<>();
			
			conn = openConn.getConection();

			ClientesDao clientesDao = new ClientesDao();

			client = clientesDao.consultarCliente(conn);
			
			PagosDao pagos = new PagosDao();
		
			
			for (Clientes clientes : client) {
				listaPagos = pagos.consultarPagos(conn, clientes.getCustomer_id());
				map.put(clientes.getEmail(), listaPagos);
				
			}
			
			return map;
		} 
			catch (SQLException e) {

			System.err.println("Ha habido un error en la base de datos : " + e.getMessage());

			throw new PagosServiceException("Error al obtener actores de la bbdd", e);
		}

		finally {
			try {
				conn.close();
			} catch (Exception e) {
			}

		}
		

	}

}