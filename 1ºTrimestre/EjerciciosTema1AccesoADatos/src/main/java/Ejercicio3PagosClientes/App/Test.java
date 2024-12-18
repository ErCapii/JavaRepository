package Ejercicio3PagosClientes.App;


import java.sql.SQLException;

import Ejercicio3PagosClientes.Dao.DaoPedido;
import Ejercicio3PagosClientes.Dao.DaoLineaPedido;
import Ejercicio3PagosClientes.Service.ServiceClientes;

public class Test {

	public static void main(String[] args) throws SQLException {
		DaoPedido dao = new DaoPedido();
		DaoLineaPedido daoPago = new DaoLineaPedido();
		ServiceClientes service = new ServiceClientes(dao, daoPago);
		
		System.out.println(service.consultarPago().get("MARILYN.ROSS@sakilacustomer.org"));
		
	}
}
