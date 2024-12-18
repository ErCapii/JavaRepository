package Ejercicio4ServicioPedidos.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Ejercicio4ServicioPedidos.LineaPedido.LineaPedido;

public class DaoLineaPedido {

	public void insertarLineaPedido(Connection conn, LineaPedido lineaPedido, Long id) throws SQLException {

		try (PreparedStatement stmt = conn.prepareStatement(
				"INSERT INTO pedidos_lineas (id_pedido, numero_linea, articulo, precio) VALUES (?, ?, ?, ?)")) {

			stmt.setLong(1, id);
			stmt.setInt(2, lineaPedido.getNumeroLinea());
			stmt.setString(3, lineaPedido.getArticulo());
			stmt.setBigDecimal(4, lineaPedido.getPrecio());
			stmt.executeUpdate();

		}

	}

	public List<LineaPedido> consultarLineaPedido(Connection conn, Long idPedido) {
		String sql = "Select * from pedidos_lineas where id_pedido = " + idPedido;
		List<LineaPedido> listaLinea = new ArrayList<LineaPedido>();
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			LineaPedido lineaPedido = new LineaPedido();
			lineaPedido.setIdPedido(idPedido);
			lineaPedido.setArticulo(rs.getString("articulo"));
			lineaPedido.setNumeroLinea(rs.getInt("numero_linea"));
			lineaPedido.setPrecio(rs.getBigDecimal("precio"));
			listaLinea.add(lineaPedido);
			}
		} catch (SQLException e) {
			System.out.println("No se existe ninguna linea de pedido con esa id");
			e.printStackTrace();
		}
		return listaLinea;
	}

}
