package ejercicio4.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ejercicio4.modelo.LineaPedido;

public class LineaPedidoDao {

	public void insertarNuevoLineaPedido(Connection conn, LineaPedido ped) throws SQLException {

		PreparedStatement stmt = null;

		try {

			stmt = conn.prepareStatement(
					"INSERT INTO pedidos_lineas(id_pedido, numero_linea, articulo, precio) VALUES (?,?,?,?)");
			stmt.setLong(1, ped.getIdPedido());
			stmt.setInt(2, ped.getNumero_linea());
			stmt.setString(3, ped.getArticulo());
			stmt.setBigDecimal(4, ped.getPrecio());
			
			stmt.execute();		}

		finally {
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}

}
