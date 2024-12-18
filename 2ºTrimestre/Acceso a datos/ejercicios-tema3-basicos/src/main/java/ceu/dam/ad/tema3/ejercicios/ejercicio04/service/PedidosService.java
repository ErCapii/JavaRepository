package ceu.dam.ad.tema3.ejercicios.ejercicio04.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.tema3.ejercicios.ejercicio04.modelo.Pedido;
import ceu.dam.ad.tema3.ejercicios.ejercicio04.modelo.PedidoLinea;
import ceu.dam.ad.tema3.ejercicios.ejercicio04.repository.PedidoLineaRepository;
import ceu.dam.ad.tema3.ejercicios.ejercicio04.repository.PedidoRepository;
import jakarta.transaction.Transactional;

@Service
public class PedidosService {

	private static final Logger log = LoggerFactory.getLogger(PedidosService.class);
	@Autowired
	private PedidoRepository pedidoRp;
	@Autowired
	private PedidoLineaRepository pedidoLineaRp;

	public Pedido consultarPedido(Long idPedido) throws PedidoException, PedidoNotFoundException {
		try {
			Pedido pedido = pedidoRp.findById(idPedido).get();
			List<PedidoLinea> lineaLista = pedidoLineaRp.findByIdPedido(idPedido);
			pedido.setLineas(lineaLista);
			return pedido;
		} catch (DataAccessException e) {
			log.error("Error registrando pedido", e);
			throw new PedidoException("Error al registrar pedido", e);
		}
	}

	@Transactional
	public Long crearPedido(Pedido pedido) throws PedidoException {
		log.debug("Creando nuevo pedido....");
		try {
			pedidoRp.save(pedido);
			pedido.getIdPedido();
			Integer numLinea = 1;
			log.debug("Insertando líneas del pedido...");
			for (PedidoLinea linea : pedido.getLineas()) {
				linea.setIdPedido(pedido.getIdPedido());
				linea.setNumLinea(numLinea);
				numLinea++;
				pedidoLineaRp.save(linea);
			}
			log.info("Pedido registrado con id " + pedido.getIdPedido());
			return pedido.getIdPedido();
		} catch (DataAccessException e) {
			log.error("Error creando pedido", e);
			throw new PedidoException("Error al registrar pedido", e);
		}
	}

}
