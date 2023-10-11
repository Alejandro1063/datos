package Ejercicio3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ejercicio3.modelo.Clientes;


public class ClientesDao {
	public List<Clientes> consultarCliente(Connection conn) throws SQLException{
		Statement stmt = null;
		ResultSet rs = null;
		try {
			List<Clientes> client = new ArrayList<Clientes>();
			String sql = "select * from customer";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Clientes a = new Clientes();
				a.setCustomer_id(rs.getInt("Customer_id")); 
				a.setFirstName(rs.getString("first_name"));
				a.setLastName(rs.getString("last_name"));
				a.setEmail(rs.getString("email"));
				a.setActive(rs.getBoolean("active"));
				client.add(a);
			}
			return client;
		}
		finally {
			try {
				stmt.close();
			}catch(Exception e) {}
		}

	}

}



