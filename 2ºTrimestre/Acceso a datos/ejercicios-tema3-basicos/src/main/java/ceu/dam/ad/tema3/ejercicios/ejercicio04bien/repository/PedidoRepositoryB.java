package ceu.dam.ad.tema3.ejercicios.ejercicio04bien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.tema3.ejercicios.ejercicio04bien.modelo.PedidoB;
@Repository
public interface PedidoRepositoryB extends JpaRepository<PedidoB, Long>{

	
}
