package Ejercicio4ServicioPedidos.Pedido;

import java.time.LocalDate;
import java.util.List;

import Ejercicio4ServicioPedidos.LineaPedido.LineaPedido;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class Pedido {

	private Long idPedido;
	private LocalDate fechaPedido;
	private LocalDate fechaDeEntrega;
	private String cliente;
	private List<LineaPedido> listaLineaPedido;
	public Pedido(LocalDate fechaPedido, LocalDate fechaDeEntrega, String cliente) {
		super();
		this.fechaPedido = fechaPedido;
		this.fechaDeEntrega = fechaDeEntrega;
		this.cliente = cliente;
	}
	
	

}
