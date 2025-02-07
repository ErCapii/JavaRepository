package ceu.dam.ad.mongo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.mongo.model.Cliente;
import ceu.dam.ad.mongo.services.ClienteService;
import ceu.dam.ad.mongo.services.DatosIncorrectosException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
public class ClienteApiService {
	@Autowired
	private ClienteService service;
	
	@Operation(summary = "Consulta de cliente por id", description = "Permite obetner un cliente por su id")
	@GetMapping("/cliente/{id}")
	public Cliente consultarClientePorId(@PathVariable String id) throws DatosIncorrectosException{
		return service.consultarClienteById(id);
	}
	@Operation(summary = "Consulta de cliente por dni", description = "Permite obetner un cliente por su dni")
	@GetMapping("/cliente")
	public Cliente consultarClientPorDni(@RequestParam String dni) throws DatosIncorrectosException{
		return service.consultarClienteByDni(dni);
	}
	@Operation(summary = "Crear un cliente nuevo", description = "Permite crear un cliente")
	@PostMapping("/cliente")
	public Cliente crearCliente(@Valid @RequestBody Cliente client) throws DatosIncorrectosException {
			return service.crearCliente(client);
	}
	@Operation(summary = "Actualiza un cliente existente", description = "Permite actualizar un cliente")
	@PutMapping("/cliente")
	public Cliente actualizarCliente(@Valid @RequestBody Cliente cliente) throws DatosIncorrectosException   {
		return service.actualizarCliente(cliente);
	}
}
