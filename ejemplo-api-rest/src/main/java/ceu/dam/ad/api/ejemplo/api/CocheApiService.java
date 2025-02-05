package ceu.dam.ad.api.ejemplo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.api.ejemplo.model.Coche;
import ceu.dam.ad.api.ejemplo.service.CocheNotFoundException;
import ceu.dam.ad.api.ejemplo.service.CocheService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
public class CocheApiService {
	@Autowired
	private CocheService service;
	@Operation(summary = "Consulta de clientes", description = "Permite obtener un cliente por su Id")
	@GetMapping("/coches/{id}")
	public Coche consultar(@PathVariable Long id) throws CocheNotFoundException {
		return service.consultarCoche(id);
	}
	@Operation(summary = "Listado de clientes", description = "Permite obtener una lista de cliente por su marca")
	@GetMapping("/coches")
	public List<Coche> consultarCoches(@RequestParam(required = false) String filtroMarca) throws CocheNotFoundException{
		return service.buscarCoches(filtroMarca);
	}
	@Operation(summary = "Crear coche", description = "Permite crear un cliente")
	@PostMapping("/coches")
	public Coche crear(@Valid @RequestBody Coche coche) {
		return service.crearCoche(coche);
	}
	@Operation(summary = "Actualizar clientes", description = "Permite actualizar un cliente")
	@PutMapping("/coches")
	public Coche actualizar(@Valid @RequestBody Coche coche) throws CocheNotFoundException {
		return service.actualizarCoche(coche);
	}
	@Operation(summary = "Borar clientes", description = "Permite borrar un cliente por su Id")
	@DeleteMapping("/coches/{id}")
	public void borrar(@PathVariable Long id) throws CocheNotFoundException {
		service.borrarCoche(id);
	}

}
