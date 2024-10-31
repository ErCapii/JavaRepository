package Ejercicio2ServicioClientes.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Ejercicio2ServicioClientes.Clientes.Cliente;

public class Dao {

	public List<Cliente> listaClientes(Connection conn) {
		List<Cliente> lista = new ArrayList<Cliente>();
		String sql = "Select * from customer";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente cl = new Cliente();
				cl.setId(rs.getInt("customer_id"));
				cl.setNombre(rs.getString("first_name"));
				cl.setApellido(rs.getString("last_name"));
				cl.setEmail(rs.getString("email"));
				cl.setActivo(rs.getBoolean("active"));
				lista.add(cl);
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lista;
	}
}
