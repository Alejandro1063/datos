package proyectoFCT.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import proyectoFCT.modelo.Registro;

public class RegistroDao {

	public List<Registro> consultarRegistro(Connection conn, Long idUser) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from registros where id_usuario = " + idUser;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			List<Registro> listaUser = new ArrayList<Registro>();

			while (rs.next()) {

				Registro registroConsultado = new Registro();

				registroConsultado.setIdRegistro(rs.getLong("id_registro"));
				registroConsultado.setIdUsuario(rs.getLong("id_usuario"));
				registroConsultado.setFecha((rs.getDate("fecha").toLocalDate()));
				registroConsultado.setNumHoras(rs.getBigDecimal("num_horas"));
				registroConsultado.setDescripcion(rs.getString("descripcion"));
				listaUser.add(registroConsultado);
			}

			return listaUser;

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

	public Long insertarRegistro(Connection conn, Registro reg) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			stmt = conn.prepareStatement(
					"INSERT INTO registros(id_usuario, fecha, num_horas, descripcion) VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, reg.getIdUsuario());
			stmt.setDate(2, Date.valueOf(reg.getFecha()));
			stmt.setBigDecimal(3, reg.getNumHoras());
			stmt.setString(4, reg.getDescripcion());

			stmt.execute();
			rs = stmt.getGeneratedKeys();
			rs.next();
			Long id = rs.getLong(1);

			return id;
			
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}

	public Registro consultarUnicoRegistro(Connection conn, Long idUser, LocalDate fecha) throws SQLException {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		Registro register = new Registro();

		try {
			String sql = "select * from registros where id_usuario = ?  and fecha = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, idUser);
			stmt.setDate(2, Date.valueOf(fecha));
			rs = stmt.executeQuery();
			if (rs.next()) {
				register.setIdRegistro((long) rs.getInt("id_registro"));
				register.setIdUsuario((long) rs.getInt("id_usuario"));
				register.setFecha(rs.getDate("fecha").toLocalDate());
				register.setNumHoras(rs.getBigDecimal("num_horas"));
				register.setDescripcion(rs.getString("descripcion"));
				return register;
			} else {
				return null;
			}
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}
}
