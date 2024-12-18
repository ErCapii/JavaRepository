package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Actor;
import com.example.demo.repository.ActorRepository;

@Service
public class ActorService {

	@Autowired
	private ActorRepository repository;
	
	public Actor consultarActor(Long id) throws ActorNotFoundException {
		Optional<Actor> actor = repository.findById(id);
		//esto es lo mismo 
		return actor.orElseThrow(() -> new ActorNotFoundException("No existe actor con ese id"));
		//que esto
//		if(!actor.isPresent()) {
//			throw new ActorNotFoundException("No existe actor con ese id");
//		}
//		return actor.get();
	}
	//Consulta todos los actores que contienen en su nombre o apellidos el filtro indicado
	public List<Actor> consultarActores(String filtro){
		return repository.findByFirstNameContainingOrLastNameContaining(filtro, filtro);
	}
	
	public void crearActor(Actor a) throws ActorServiceException {
		try {
			repository.save(a);
			
		}catch (DataAccessException e) {
			throw new ActorServiceException("Error insertando actor",e);
		}
	}
	/*
	@Transactional
	public void crearActores(List<Actor> actores) throws ActorServiceException {
		try {
			actores.forEach(a -> repository.save(a));
		}catch (DataAccessException | UnexpectedRollbackException e) {
			throw new ActorServiceException("Error insertando actores",e);
		}
	}
	*/
	
	public void crearActores(List<Actor> actores) throws ActorServiceException {
		try {
			repository.saveAll(actores);
		}catch (DataAccessException | UnexpectedRollbackException e) {
			throw new ActorServiceException("Error insertando actores",e);
		}
	}
	
	public void actualizarActor(Actor actor) {
		repository.save(actor);
	}
	
	public void borrarActor(Long id) {
		repository.deleteById(id);
	}
}
