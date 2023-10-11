package ejercicio4.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicio4.modelo.Pedido;

public class PedidosDao {

	public Long insertarNuevoPedido(Connection conn, Pedido ped) throws SQLException {

		PreparedStatement stmt = null;

		try {

			stmt = conn.prepareStatement(
					"INSERT INTO pedidos(fecha_pedido, fecha_entrega, cliente) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
		
			stmt.setDate(1, Date.valueOf(ped.getFecha_pedido()));
			stmt.setDate(2, Date.valueOf(ped.getFecha_pedido()));
			stmt.setString(3,ped.getCliente());
			stmt.execute();	
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			return rs.getLong("id_pedido");
		}

		finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}

}
