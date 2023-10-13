package ceu_fct.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ceu_fct.modelo.Registro;

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

				registroConsultado.setId_registro(rs.getLong("id_registro"));
				registroConsultado.setId_usuario(rs.getLong("id_usuario"));
				registroConsultado.setFecha((rs.getDate("fecha").toLocalDate()));
				registroConsultado.setNum_horas(rs.getBigDecimal("num_horas"));
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

	public long insertarRegistro(Connection conn, Registro reg) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			stmt = conn.prepareStatement(
					"INSERT INTO registros(id_usuario, fecha, num_horas, descripcion) VALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, reg.getId_usuario());
			stmt.setDate(1, Date.valueOf(reg.getFecha()));
			stmt.setBigDecimal(2, reg.getNum_horas());
			stmt.setString(3, reg.getDescripcion());

			stmt.execute();
			rs = stmt.getGeneratedKeys();
			rs.next();
			Long id = rs.getLong(1);

			return id;
		}

		finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}

	public Registro consultarUnicoRegistro(Connection conn, Long idUser, LocalDate fecha) throws SQLException {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement("select * from registros where id_usuario = ? and fecha = ?");
			
			stmt.setLong(1, idUser);
			stmt.setDate(2, Date.valueOf(fecha));
			rs = stmt.executeQuery();
			
				Registro registroConsultado = new Registro();
				
				registroConsultado.setId_registro(rs.getLong("id_registro"));
				registroConsultado.setId_usuario(rs.getLong("id_usuario"));
				registroConsultado.setFecha(fecha);
				registroConsultado.setNum_horas(rs.getBigDecimal("num_horas"));
				registroConsultado.setDescripcion(rs.getString("descripcion"));
			
			return registroConsultado;

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

}
