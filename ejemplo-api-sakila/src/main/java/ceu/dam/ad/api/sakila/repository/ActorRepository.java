package ceu.dam.ad.api.sakila.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ceu.dam.ad.api.sakila.model.Actor;
@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer>{

	public List<Actor> findByFirstNameContainingOrLastNameContainingIgnoreCase(String firstName, String lastName);
	public List<Actor> findByLastUpdateBetween(LocalDate primeraFecha, LocalDate segundaFecha);
}
