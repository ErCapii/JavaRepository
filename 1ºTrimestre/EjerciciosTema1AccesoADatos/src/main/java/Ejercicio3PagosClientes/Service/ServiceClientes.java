package Ejercicio3PagosClientes.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import Ejercicio3PagosClientes.Dao.DaoPedido;
import Ejercicio3PagosClientes.Dao.DaoLineaPedido;
import Ejercicio3PagosClientes.Pago.Pago;

public class ServiceClientes extends Service {

	private DaoPedido daoCliente;
	private DaoLineaPedido daoPago;

	public ServiceClientes(DaoPedido daoC, DaoLineaPedido daoP) {
		this.daoCliente = daoC;
		this.daoPago = daoP;
	}

	public Map<String, List<Pago>> consultarPago() throws SQLException{
		Map<String, List<Pago>> mapaCliente = new HashMap<String, List<Pago>>();
		try (Connection conn = abrirConexion()) {
			return daoCliente.listaClientes(conn).stream()
					.collect(Collectors.toMap(e -> e.getEmail(), p -> daoPago.listaPagos(conn, p.getId())));

		}

	}
}
