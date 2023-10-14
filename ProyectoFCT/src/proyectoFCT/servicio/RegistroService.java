package proyectoFCT.servicio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import proyectoFCT.dao.RegistroDao;
import proyectoFCT.exception.RegistroServiceException;
import proyectoFCT.exception.UsuarioNoExisteException;
import proyectoFCT.modelo.Registro;

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
			RegistroDao regist = new RegistroDao();
			con = conn.getConection();
			if (regist.consultarUnicoRegistro(con, reg.getIdUsuario(), reg.getFecha()) == null) {
				regist.insertarRegistro(con, reg);
				System.out.println("Se ha insertado correctamente");
			} else {
				throw new RegistroServiceException("El registro ya existe");
			}
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