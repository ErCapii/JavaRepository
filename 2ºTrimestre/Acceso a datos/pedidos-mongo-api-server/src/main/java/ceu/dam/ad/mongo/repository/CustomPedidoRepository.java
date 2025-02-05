package ceu.dam.ad.mongo.repository;

import java.util.List;

import ceu.dam.ad.mongo.model.Pedido;

public interface CustomPedidoRepository {

	public List<Pedido> buscarListaDePedidosPorDniCliente(String dni);
}
