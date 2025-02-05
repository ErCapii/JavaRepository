package ceu.dam.ad.api.sakila.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.api.sakila.model.Actor;
import ceu.dam.ad.api.sakila.service.ActorNotFoundException;
import ceu.dam.ad.api.sakila.service.ActorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/actores")
public class ActorApi {
	@Autowired
	private ActorService service;

	@Operation(summary = "Consulta de actor", description = "Permite obtener un actor por su Id")
	@GetMapping("/{id}")
	public Actor consultar(@PathVariable Integer id) throws ActorNotFoundException {
		return service.buscarActor(id);
	}

	@Operation(summary = "Consulta de actores entre dos fechas", description = "Permite obtener una lista de actores  entre dos fechas de updates")
	@GetMapping
	public List<Actor> consultarActorPorFechas(
			@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fecha1,
			@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fecha2) throws ActorNotFoundException {
		return service.buscarPorUpdate(fecha1, fecha2);
	}

	@Operation(summary = "Consulta de actores por un nombre", description = "Permite obtener una lista de actores por su nombre o apellido")
	@GetMapping("/actorNombreApellidos/{filtro}")
	public List<Actor> consultarPorNombreApellido(@PathVariable String filtro) throws ActorNotFoundException {
		return service.buscarActorNombreApellido(filtro);
	}

	@Operation(summary = "Crear un nuevo actor", description = "Permite obtener crear un nuevo actor")
	@PostMapping
	public Actor crear(@Valid @RequestBody Actor actor) {
		return service.crearActor(actor);
	}

	@Operation(summary = "Actualiza un actor existente", description = "Permite actualizar un actor")
	@PutMapping
	public Actor actualizar(@Valid @RequestBody Actor actor) throws ActorNotFoundException {
		return service.actualizarActor(actor);
	}

	@Operation(summary = "Borra un actor", description = "Permite borrar un actor mediante la id")
	@DeleteMapping("/{id}")
	public void borrar(@PathVariable Integer id) throws ActorNotFoundException {
		service.borrarActor(id);
	}
}
