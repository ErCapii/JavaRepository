package Ejercicio2ServicioClientes.App;


import Ejercicio2ServicioClientes.Dao.Dao;
import Ejercicio2ServicioClientes.Service.ServiceClientes;

public class Test {

	public static void main(String[] args) {
		Dao dao = new Dao();
		ServiceClientes service = new ServiceClientes(dao);
		
		//System.out.println(service.buscarCliente().get("MARILYN.ROSS@sakilacustomer.org"));
		
	}
}
