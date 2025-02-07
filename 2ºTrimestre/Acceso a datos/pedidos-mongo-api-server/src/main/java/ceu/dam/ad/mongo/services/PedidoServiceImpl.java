package ceu.dam.ad.mongo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.dam.ad.mongo.model.Cliente;
import ceu.dam.ad.mongo.model.Pedido;
import ceu.dam.ad.mongo.model.PedidoDetalle;
import ceu.dam.ad.mongo.repository.ClienteRepository;
import ceu.dam.ad.mongo.repository.PedidoRepository;
@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	private PedidoRepository pedidoRp;
	@Autowired
	private ClienteRepository clienteRp;
	
	@Override
	public String registrarPedido(Pedido pedido) throws DatosIncorrectosException {
	
		Optional<Pedido> pedidoPrevio = pedidoRp.findOneByNumero(pedido.getNumero());
		if (pedidoPrevio.isPresent()) {
			throw new DatosIncorrectosException("Ya hay un pedido con ese número");
		}
		
		// TRATAMIENTO DEL CLIENTE 
		if (pedido.getCliente().getId()!=null) { // Si nos indican un pedido con ID de cliente, vemos si existe dicho cliente
			Optional<Cliente> clienteOpt = clienteRp.findById(pedido.getCliente().getId()); 
			if (clienteOpt.isEmpty()) { // Si no existe, lanzamos error
				throw new DatosIncorrectosException("No existe el ID del cliente indicado");
			}
			// Si existe, actualizamos sus datos
			clienteRp.save(pedido.getCliente()); // Actualizamos los datos del cliente con los últimos datos recibidos del pedido 
		}
		else { // Si no nos indican ID de cliente, lo buscamos por su DNI. Si no existe, lo creamos. Si existe, lo actualizamos
			Optional<Cliente> clienteOpt = clienteRp.findOneByDni(pedido.getCliente().getDni());
			if (clienteOpt.isPresent()) { 
				pedido.getCliente().setId(clienteOpt.get().getId());
			}
			clienteRp.save(pedido.getCliente());
		}
		// FIN TRATAMIENTO DEL CLIENTE
		
		pedidoRp.save(pedido);
		return pedido.getId();

	}

	@Override
	public Pedido consultarPedido(String id) throws DatosIncorrectosException {
		return pedidoRp.findById(id).orElseThrow(()-> new DatosIncorrectosException());
	}

	@Override
	public List<Pedido> buscarPedidos(LocalDate desde, LocalDate hasta) {
		if(desde == null) {
			desde = LocalDate.now().minusMonths(1);
		}
		
		if(hasta == null) {
			hasta = LocalDate.now();
		}
		List<Pedido> lista = pedidoRp.findByFechaBetween(desde.minusDays(1), hasta.plusDays(1));
		return lista;
	}

	@Override
	public List<Pedido> consultarPedidosCliente(String dni) {
		List<Pedido> list = pedidoRp.buscarListaDePedidosPorDniCliente(dni);
		return list;
	}

	@Override
	public Pedido añadirDetalle(String id, PedidoDetalle detalle) throws DatosIncorrectosException {
		Pedido pedido = consultarPedido(id);
		pedido.getDetalles().add(detalle);
		
		return pedidoRp.save(pedido);
	}

}
