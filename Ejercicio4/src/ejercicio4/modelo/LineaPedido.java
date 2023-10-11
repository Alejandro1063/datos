package ejercicio4.modelo;

import java.math.BigDecimal;

public class LineaPedido {

	
	private Long idPedido;
	private	Integer numero_linea;
	private String articulo;
	private BigDecimal precio;
	
	public LineaPedido() {
	}
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido2) {
		this.idPedido = idPedido2;
	}
	public Integer getNumero_linea() {
		return numero_linea;
	}
	public void setNumero_linea(Integer numero_linea) {
		this.numero_linea = numero_linea;
	}
	public String getArticulo() {
		return articulo;
	}
	public void setArticulo(String articulo) {
		this.articulo = articulo;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "LineaPedido [idPedido=" + idPedido + ", numero_linea=" + numero_linea + ", articulo=" + articulo
				+ ", precio=" + precio + "]";
	}
	
	
}
