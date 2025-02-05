package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.modelo.Pais;
import java.util.List;


public interface PaisesRepository extends JpaRepository<Pais, String>{

	List<Pais> findByDescripcionStartingWith(String descripcion);
}
