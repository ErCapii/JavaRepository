package ceu.dam.ad.tema3.ejercicios.ejercicio04bien.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.tema3.ejercicios.ejercicio04bien.modelo.PedidoB;
import ceu.dam.ad.tema3.ejercicios.ejercicio04bien.repository.PedidoRepositoryB;
import jakarta.transaction.Transactional;

@Service
public class PedidosServiceB {

	private static final Logger log = LoggerFactory.getLogger(PedidosServiceB.class);
	@Autowired
	private PedidoRepositoryB pedidoRp;
	

	public PedidoB consultarPedido(Long idPedido) throws PedidoException, PedidoNotFoundException {
		try {
			PedidoB pedido = pedidoRp.findById(idPedido).orElseThrow(() -> new PedidoNotFoundException("No existe el id" + idPedido));
			return pedido;
		} catch (DataAccessException e) {
			log.error("Error registrando pedido", e);
			throw new PedidoException("Error al registrar pedido", e);
		}
	}

	@Transactional
	public Long crearPedido(PedidoB pedido) throws PedidoException {
		log.debug("Creando nuevo pedido....");
		try {
			pedidoRp.save(pedido);
			return pedido.getIdPedido();
		} catch (DataAccessException e) {
			log.error("Error creando pedido", e);
			throw new PedidoException("Error al registrar pedido", e);
		}
	}

}
