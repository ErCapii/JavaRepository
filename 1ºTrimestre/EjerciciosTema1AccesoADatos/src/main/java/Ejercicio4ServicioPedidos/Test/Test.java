package Ejercicio4ServicioPedidos.Test;

import java.sql.SQLException;

import Ejercicio4ServicioPedidos.Service.PedidoService;
import Ejercicio4ServicioPedidos.Service.PedidoServiceException;

public class Test {

	
	public static void main(String[] args) throws SQLException, PedidoServiceException {

		PedidoService sr = new PedidoService();
//		Pedido pedido = new Pedido(LocalDate.of(2024, 06, 12), LocalDate.of(2024, 06, 18), "Manueh");
//		LineaPedido linea = new LineaPedido(1, "Raton", new BigDecimal(15));
//		LineaPedido linea2 = new LineaPedido(2, "Teclado", new BigDecimal(15));
//		LineaPedido linea3 = new LineaPedido(3, "Pantalla", new BigDecimal(15));
//		List<LineaPedido> listaLineas = new ArrayList<LineaPedido>();
//		listaLineas.add(linea);
//		listaLineas.add(linea2);
//		listaLineas.add(linea3);
//		pedido.setListaLineaPedido(listaLineas);
//		sr.registrarPedido(pedido);
		System.out.println( sr.mostraPedido(12L));
		
	}
}
