package ejemploJdbc1.servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ejemploJdbc1.modelo.Actor;

public class ActoresServices {

	private OpenConnection openConn;

	public ActoresServices() {

		openConn = new OpenConnection();

	}

	public List<Actor> consultarActores() throws ActoresServiceException {

		Connection conn = null;

		Statement stmt = null;

		ResultSet rs = null;

		List<Actor> listActores = new ArrayList<>();

		try {

			conn = openConn.getConection();

			stmt = conn.createStatement();

			String sql = "SELECT * FROM ACTOR";

			System.out.println(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Actor actor = new Actor();

				actor.setId(rs.getInt("actor_id"));

				actor.setNombre(rs.getString("first_name"));

				actor.setApellidos(rs.getString("last_name"));

				listActores.add(actor);
			}

			return listActores;
		} catch (SQLException e) {

			System.err.println("Ha habido un error en la base de datos : " + e.getMessage());

			throw new ActoresServiceException("Error al obtener actores de la bbdd", e);
		}

		finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
			try {
				conn.close();
			} catch (Exception e) {
			}

		}

	}

}
