package ejercicio4.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ejercicio4.modelo.LineaPedido;
import ejercicio4.modelo.Pedido;
import ejercicio4.services.PedidoService;

public class test {

	public static void main(String[] args) {

		try {
			List<LineaPedido> articulos = new ArrayList<>();
			PedidoService pedido = new PedidoService();

			LineaPedido art1 = new LineaPedido();
			art1.setArticulo("Barco");
			art1.setNumero_linea(1);
			art1.setPrecio(new BigDecimal("200"));

			LineaPedido art2 = new LineaPedido();
			art2.setArticulo("avion");
			art2.setNumero_linea(2);
			art2.setPrecio(new BigDecimal("800"));

			articulos.add(art1);
			articulos.add(art2);

			Pedido ped = new Pedido();
			ped.setCliente("Alejandro");
			ped.setFecha_pedido(LocalDate.now());
			ped.setFecha_entrega(LocalDate.of(2023, 10, 8));

			ped.setLista_pedido(articulos);

			pedido.registrarPedido(ped);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
