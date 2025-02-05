package ceu.dam.ad.mongo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.mongo.model.Pedido;
@Repository
public interface PedidoRepository extends MongoRepository<Pedido, String>, CustomPedidoRepository{

	public List<Pedido> findByFechaBetween(LocalDate fecha, LocalDate fecha2);
}
