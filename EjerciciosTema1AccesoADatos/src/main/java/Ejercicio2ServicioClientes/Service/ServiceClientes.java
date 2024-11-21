package Ejercicio2ServicioClientes.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import Ejercicio2ServicioClientes.Clientes.Cliente;
import Ejercicio2ServicioClientes.Dao.Dao;

public class ServiceClientes extends Service {

	private Dao dao;

	public ServiceClientes(Dao dao) {
		this.dao = dao;
	}

//	public Map<String, Cliente> buscarCliente() {
//		Map<String, Cliente> mapaCliente = new HashMap<String, Cliente>();
//		try (Connection conn = abrirConexion()) {
//			List<Cliente> listaCliente = dao.listaClientes(conn);
//			mapaCliente = listaCliente.stream().collect(Collectors.toMap(e -> e.getEmail(), c -> c));
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		}
//		return mapaCliente;
//
//	}
}
