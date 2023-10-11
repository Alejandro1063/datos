package Ejercicio3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ejercicio3.modelo.Pago;

public class PagosDao {

	
	public List<Pago> consultarPagos(Connection conn, int i) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Pago> lPagos = new ArrayList<Pago>();
			String sql = "select amount, payment_date from payment where customer_id = " + i;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Pago a = new Pago();
				a.setFecha(rs.getDate("payment_date").toLocalDate()); 
				a.setImporte(rs.getBigDecimal("amount"));
				lPagos.add(a);
			}
			return lPagos;
		}
		finally {
			try {
				stmt.close();
			}catch(Exception e) {}
		}

	}

}



