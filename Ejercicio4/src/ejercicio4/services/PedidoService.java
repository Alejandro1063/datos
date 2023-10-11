package ejercicio4.services;

import java.sql.Connection;
import java.sql.SQLException;

import ejercicio4.dao.LineaPedidoDao;
import ejercicio4.dao.PedidosDao;
import ejercicio4.modelo.LineaPedido;
import ejercicio4.modelo.Pedido;

public class PedidoService {

	private OpenConnection openConn;

	public PedidoService() {
		openConn = new OpenConnection();
	}

	public void registrarPedido(Pedido ped) throws PedidoServiceException {

		Connection conn = null;
		try {
			conn = openConn.getConection();
			conn.setAutoCommit(false);

			PedidosDao pedDao = new PedidosDao();
			LineaPedidoDao linPedDao = new LineaPedidoDao();

			Long idPedido = pedDao.insertarNuevoPedido(conn, ped);
			Integer numLinea = 1;

			for (LineaPedido pedido2 : ped.getLista_pedido()) {
				pedido2.setIdPedido(idPedido);
				pedido2.setNumero_linea(numLinea);
				linPedDao.insertarNuevoLineaPedido(conn, pedido2);
				numLinea++;

			}
			conn.commit();

		} catch (SQLException e) {

			System.err.println("Ha habido un error en la base de datos : " + e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new PedidoServiceException("Error al obtener datos de la bbdd", e);
		}

		finally {
			try {
				conn.close();
			} catch (Exception e) {
			}

		}

	}

}