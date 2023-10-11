package ceu_fct.servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ceu_fct.dao.RegistroDao;
import ceu_fct.modelo.Registro;

public class RegistroService {

	private OpenConnection conn;

	public RegistroService() {
		conn = new OpenConnection();

	}

	public List<Registro> consultarRegistro(Long id) throws RegistroServiceException {
		Connection conn = null;

		try {

			RegistroDao registro = new RegistroDao();

			return registro.consultarRegistro(conn, id);

		} catch (SQLException e) {
			System.out.println("Error en la base de datos" + e.getMessage());
			e.printStackTrace();
			throw new RegistroServiceException();
		}

		finally {
			try {
				conn.close();
			} catch (Exception e) {
			}

		}
	}

}
