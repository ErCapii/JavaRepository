package ceu.dam.ad.api.sakila.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.dam.ad.api.sakila.model.Actor;
import ceu.dam.ad.api.sakila.repository.ActorRepository;

@Service
public class ActorService {

	@Autowired
	private ActorRepository actorRp;

	public Actor buscarActor(Integer id) throws ActorNotFoundException {

		return actorRp.findById(id).orElseThrow(() -> new ActorNotFoundException("No existe un actor con el id" + id));
	}

	public List<Actor> buscarActorNombreApellido(String nombre) throws ActorNotFoundException {
		return actorRp.findByFirstNameContainingOrLastNameContainingIgnoreCase(nombre, nombre);

	}

	public List<Actor> buscarPorUpdate(LocalDate fecha1, LocalDate fecha2) throws ActorNotFoundException {
		
		List<Actor> lista = actorRp.findByLastUpdateBetween(fecha1, fecha2);
		if (lista.isEmpty()) {
			throw new ActorNotFoundException();
		}
		
		return lista;
	}

	public Actor crearActor(Actor actor) {
		actor.setLastUpdate(LocalDate.now());
		return actorRp.save(actor);
	}

	public Actor actualizarActor(Actor actor) throws ActorNotFoundException {
		if (buscarActor(actor.getActorId()) == null) {
			return actorRp.save(actor);
		}
		return null;
	}

	public void borrarActor(Integer id) {
		actorRp.deleteById(id);
	}

}
