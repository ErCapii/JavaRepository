package Ejercicio4ServicioPedidos.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Ejercicio4ServicioPedidos.Pedido.Pedido;

public class DaoPedido {

	public Long insertarPedido(Connection conn, Pedido pedido) throws SQLException {
		String sql = "INSERT INTO pedidos (fecha_pedido, fecha_entrega, cliente) VALUES (?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			stmt.setDate(1, Date.valueOf(pedido.getFechaPedido()));
			stmt.setDate(2, Date.valueOf(pedido.getFechaDeEntrega()));
			stmt.setString(3, pedido.getCliente());
			stmt.executeUpdate();
			ResultSet key = stmt.getGeneratedKeys();
			key.next();
			return key.getLong(1);
		}
	}

	public Pedido consultarPedido(Connection conn, Long idPedido) throws SQLException {
		String sql = "Select * from pedidos where id_pedido = " + idPedido;
		Pedido pedido = null;
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
			pedido = new Pedido();
			pedido.setIdPedido(idPedido);
			pedido.setFechaPedido(rs.getDate("fecha_pedido").toLocalDate());
			pedido.setFechaDeEntrega(rs.getDate("fecha_entrega").toLocalDate());
			pedido.setCliente(rs.getString("cliente"));
			}
			return pedido;
		} catch (SQLException e) {
			throw e;
		}
	}
}
