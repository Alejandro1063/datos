package proyectoFCT.servicio;

import java.sql.Connection;
import java.sql.SQLException;

import proyectoFCT.dao.UsuarioDao;
import proyectoFCT.exception.AutenticationException;
import proyectoFCT.exception.UsuarioNoExisteException;
import proyectoFCT.exception.UsuarioServiceException;
import proyectoFCT.modelo.Usuario;

public class UsuarioService {

	private OpenConnection conn;

	public UsuarioService() {
		conn = new OpenConnection();

	}

	public Usuario loginUsuario(String mail, String pass)
			throws UsuarioNoExisteException, AutenticationException, UsuarioServiceException {
		Connection con = null;

		try {
			con = conn.getConection();
			Usuario userBien = new Usuario();
			UsuarioDao userDao = new UsuarioDao();
			userBien = userDao.consultarUsuario(con, mail);
			if (userBien == null) {

				throw new UsuarioNoExisteException("El usuario no existe");

			} else if (!userBien.getPassword().equals(pass)) {

				throw new AutenticationException("La password no se corresponde");

			} else {

			}
			return userBien;

		} catch (SQLException e) {
			System.out.println("Error en la base de datos" + e.getMessage());
			e.printStackTrace();
			throw new UsuarioServiceException();
		}

		finally {
			try {
				((Connection) conn).close();
			} catch (Exception e) {
			}

		}

	}

	public void altaUsuario(Usuario user) throws UsuarioServiceException {
		Connection con = null;

		try {
			con = conn.getConection();
			Usuario userBien = new Usuario();
			UsuarioDao userDao = new UsuarioDao(); 
			userBien = userDao.consultarUsuario(con, user.getEmail());
			if (userBien != null) {
				throw new UsuarioServiceException("El usuario ya existe");
			} else {
				userDao.insertarUsuario(con, user);
			}
		} catch (

		SQLException e) {
			System.out.println("Error en la base de datos" + e.getMessage());
			e.printStackTrace();
			throw new UsuarioServiceException("Error en la consulta de bbdd");
		}

		finally {
			try {
				((Connection) con).close();
			} catch (Exception e) {
			}

		}

		// consultar si el email está registrado
		// si es distinto de null, lanzo excepcion
		// si no existe inserta el usuario
		// si hay error lanzamos FCTException

	}

}