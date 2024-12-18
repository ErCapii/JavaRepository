package Ejercicio3PagosClientes.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Ejercicio3PagosClientes.Pago.Pago;

public class DaoLineaPedido {

	public List<Pago> listaPagos(Connection conn, Integer filtro) {
		List<Pago> lista = new ArrayList<Pago>();
		String sql = "Select * from payment where customer_id ="+filtro;
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pago pago = new Pago();
				pago.setImporte(rs.getBigDecimal("amount"));
				pago.setFecha(rs.getDate("payment_date"));
				lista.add(pago);
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lista;
	}
}
