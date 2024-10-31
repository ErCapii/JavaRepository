package Ejercicio4ServicioPedidos.Service;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Ejercicio4ServicioPedidos.Dao.DaoLineaPedido;
import Ejercicio4ServicioPedidos.Dao.DaoPedido;
import Ejercicio4ServicioPedidos.LineaPedido.LineaPedido;
import Ejercicio4ServicioPedidos.Pedido.Pedido;
import jdk.internal.org.jline.utils.Log;

public class PedidoService extends Service {

	public static final Logger logger = LoggerFactory.getLogger(PedidoService.class);
	private DaoPedido daoPedido;
	private DaoLineaPedido daoLineaPedido;

	public PedidoService() {
		daoPedido = new DaoPedido();
		daoLineaPedido = new DaoLineaPedido();
	}
	public void registrarPedido(Pedido pedido) throws PedidoServiceException {
		logger.debug("Creando nuevo pedido...");
		try (Connection conn = abrirConexion()) {

			try {
				conn.setAutoCommit(false);
				Long id = daoPedido.insertarPedido(conn, pedido);
				for (LineaPedido lineaPedido : pedido.getListaLineaPedido()) {
					daoLineaPedido.insertarLineaPedido(conn, lineaPedido, id);
				}
				conn.commit();
				logger.info("pedido insertado");
			} catch (SQLException e) {
				conn.rollback();
				throw e;
			}

		}catch (SQLException e) {
			System.out.println("No a sido posible insertar los datos");
			e.printStackTrace();
			throw new PedidoServiceException();
		}
	}
	public Pedido mostraPedido(Long id) throws PedidoServiceException {
		logger.debug("Consultando pedido con id "+ id);
		try (Connection conn = abrirConexion()) {
			Pedido pedido = new Pedido();
			pedido = daoPedido.consultarPedido(conn, id);
			if(pedido == null) {
				logger.warn("pedido no encontrado");
				throw new PedidoServiceException("No existe el pedido");
			}
			pedido.setListaLineaPedido(daoLineaPedido.consultarLineaPedido(conn, id));
			
			
			return pedido;
		} catch (SQLException e) {
			logger.error("Error registrando pedido", e);
			throw new PedidoServiceException("Error al registrar el pedido", e);
		}
	}
	

}
