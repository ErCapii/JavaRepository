package ceu.dam.ad.mongo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.dam.ad.mongo.model.Pedido;
import ceu.dam.ad.mongo.model.PedidoDetalle;
import ceu.dam.ad.mongo.repository.PedidoRepository;
@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	private PedidoRepository pedidoRp;
	
	@Override
	public String registrarPedido(Pedido pedido) throws DatosIncorrectosException {
		if(consultarPedido(pedido.getId()) != null) {
			throw new DatosIncorrectosException("Pedido ya creado");
		}
		return pedidoRp.save(pedido).getId();
	}

	@Override
	public Pedido consultarPedido(String id) throws DatosIncorrectosException {
		return pedidoRp.findById(id).orElseThrow(()-> new DatosIncorrectosException());
	}

	@Override
	public List<Pedido> buscarPedidos(LocalDate desde, LocalDate hasta) {
		List<Pedido> lista = pedidoRp.findByFechaBetween(desde, hasta);
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
