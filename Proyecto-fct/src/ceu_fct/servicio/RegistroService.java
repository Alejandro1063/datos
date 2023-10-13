package ceu_fct.servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ceu_fct.dao.RegistroDao;
import ceu_fct.exception.RegistroServiceException;
import ceu_fct.exception.UsuarioNoExisteException;
import ceu_fct.modelo.Registro;

public class RegistroService {

	private OpenConnection conn;


	public RegistroService() {
		conn = new OpenConnection();

	}

	public List<Registro> consultarRegistrosUsuarios(Long idUsuario)
			throws RegistroServiceException, UsuarioNoExisteException {
		Connection con = null;

		try {
			con = conn.getConection();
			RegistroDao regDao = new RegistroDao();

			regDao.consultarRegistro(con, idUsuario);

			return regDao.consultarRegistro(con, idUsuario);

		} catch (SQLException e) {
			System.out.println("Error en la base de datos" + e.getMessage());
			e.printStackTrace();
			throw new RegistroServiceException();
		}

		finally {
			try {
				con.close();
			} catch (Exception e) {
			}

		}
	}

	public void insertarRegistro(Registro reg) throws RegistroServiceException{
		Connection con = null;
		
		try {
			con = conn.getConection();
			RegistroDao regisDao = new  RegistroDao();
			if(regisDao.consultarUnicoRegistro(con, reg.getId_usuario(), reg.getFecha()) != null) {
				
				throw new RegistroServiceException("Ya existe ese registro");
			}
			regisDao.insertarRegistro(con, reg);
		} catch (Exception e) {
			System.out.println("Error en la base de datos" + e.getMessage());
			e.printStackTrace();
			throw new RegistroServiceException();
		}

		finally {
			try {
				con.close();
			} catch (Exception e) {
			}}
}
}
