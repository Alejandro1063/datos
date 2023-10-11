package Ejercicio2.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ejercicio2.dao.ClientesDao;
import Ejercicio2.modelo.Clientes;

public class ClientesService {

	private OpenConnection openConn;

	public ClientesService() {
		openConn = new OpenConnection();
	}
	public Map<String, Clientes> consultarClientes() throws ClientesServiceException {

		Connection conn = null;
		

		try {
			List<Clientes> client = new ArrayList<Clientes>();
			Map<String, Clientes> map = new HashMap<String, Clientes>();

			
			conn = openConn.getConection();

			ClientesDao dao = new ClientesDao();

			client = dao.consultarCliente(conn);
			
			for (Clientes clientes : client) {
				map.put(clientes.getEmail(), clientes);
			}
			
			return map;
		} 
			catch (SQLException e) {

			System.err.println("Ha habido un error en la base de datos : " + e.getMessage());

			throw new ClientesServiceException("Error al obtener actores de la bbdd", e);
		}

		finally {
			try {
				conn.close();
			} catch (Exception e) {
			}

		}
		

	}

}