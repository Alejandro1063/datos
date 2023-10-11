package ceu_fct.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ceu_fct.modelo.Fecha;

public class FechaDao {

	public List<Fecha> consultarFecha(Connection conn, Integer anho, Integer evalua) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Fecha> listaFechas = new ArrayList<>();
			String sql = "select * from fechas where fecha = " + anho + " and evaluacion = " + evalua;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
			Fecha fechaConsultado = new Fecha();

			fechaConsultado.setFecha((rs.getDate("fecha").toLocalDate()));;
			fechaConsultado.setAnho(rs.getInt("año"));
			fechaConsultado.setEvaluacion(rs.getInt("evaluacion"));
			fechaConsultado.setDisponibilidad(rs.getBoolean("disponibilidad"));
			listaFechas.add(fechaConsultado);
			}
			return listaFechas;

		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}
	}

}


