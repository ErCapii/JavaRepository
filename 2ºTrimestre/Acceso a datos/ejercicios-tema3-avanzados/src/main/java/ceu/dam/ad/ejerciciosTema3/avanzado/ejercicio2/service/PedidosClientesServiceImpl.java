package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.Articulo;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.Cliente;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.Pedido;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.model.PedidoLinea;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.repository.ArticuloRepository;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.repository.ClienteRepository;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio2.repository.PedidoRepository;
import jakarta.transaction.Transactional;

@Service
public class PedidosClientesServiceImpl implements PedidosClientesService {
	@Autowired
	private ArticuloRepository articuloRp;
	@Autowired
	private ClienteRepository clienteRp;
	@Autowired
	private PedidoRepository pedidoRp;

	@Override
	public void crearCliente(Cliente cliente) throws PedidosClientesServiceException {
		try {
			clienteRp.save(cliente);
		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al crear el cliente", e);
		}
	}

	@Override
	@Transactional
	public Pedido crearPedido(Pedido pedido) throws PedidosClientesServiceException {
		try {
			consultarCliente(pedido.getCliente().getDni());
			List<PedidoLinea> listaLineas = pedido.getLineas();
			Integer numL = 1;
			for (PedidoLinea pedidoLinea : listaLineas) {
				consultarArticulo(pedidoLinea.getArticulo().getId());
				pedidoLinea.setNumLinea(numL++);
			}
			
			return pedidoRp.save(pedido);
		} catch (DataAccessException | NotFoundException e) {
			throw new PedidosClientesServiceException("Error al crear el pedido", e);
		}
	}

	@Override
	public Articulo crearArticulo(Articulo articulo) throws PedidosClientesServiceException {
		try {
			return articuloRp.save(articulo);
		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al crear el pedido", e);
		}

	}

	@Override
	public void actualizarCliente(Cliente cliente) throws PedidosClientesServiceException {
		try {
			consultarCliente(cliente.getDni());
			clienteRp.save(cliente);
		} catch (DataAccessException |NotFoundException e) {
			throw new PedidosClientesServiceException("Error al actualizar el cliente", e);
		}
	}

	@Override
	public Cliente consultarCliente(String dni) throws NotFoundException, PedidosClientesServiceException {
		try {
			return clienteRp.findById(dni).orElseThrow(() -> new NotFoundException());
		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al consultar el cliente", e);
		}
	}

	@Override
	public Articulo consultarArticulo(Long idArticulo) throws NotFoundException, PedidosClientesServiceException {
		try {
			return articuloRp.findById(idArticulo).orElseThrow(() -> new NotFoundException());
		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al consultar el articulo", e);
		}
	}

	@Override
	public Pedido consultarPedido(String uuid) throws NotFoundException, PedidosClientesServiceException {
		try {
			UUID uid = UUID.fromString(uuid);
			return pedidoRp.findById(uid).orElseThrow(() -> new NotFoundException());
		} catch (DataAccessException e) {
			throw new PedidosClientesServiceException("Error al consultar el pedido", e);
		}
	}

}
