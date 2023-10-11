package ejercicio4.modelo;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

	private Integer id_pedido;
	private LocalDate fecha_pedido;
	private LocalDate fecha_entrega;
	private String cliente;
	private List<LineaPedido> lista_pedido;
	
	public Integer getId_pedido() {
		return id_pedido;
	}
	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}
	public LocalDate getFecha_pedido() {
		return fecha_pedido;
	}
	public void setFecha_pedido(LocalDate fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}
	public LocalDate getFecha_entrega() {
		return fecha_entrega;
	}
	public void setFecha_entrega(LocalDate fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
	public List<LineaPedido> getLista_pedido() {
		return lista_pedido;
	}
	public void setLista_pedido(List<LineaPedido> lista_pedido) {
		this.lista_pedido = lista_pedido;
	}
	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", fecha_pedido=" + fecha_pedido + ", fecha_entrega=" + fecha_entrega
				+ ", cliente=" + cliente + "]";
	}
	
	
}
