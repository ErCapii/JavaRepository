package Ejercicio4ServicioPedidos.LineaPedido;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class LineaPedido {

	private Long idPedido;
	private Integer numeroLinea;
	private String articulo;
	public LineaPedido(Integer numeroLinea, String articulo, BigDecimal precio) {
		this.numeroLinea = numeroLinea;
		this.articulo = articulo;
		this.precio = precio;
	}
	private BigDecimal precio;

}
