package ceu.dam.ad.mongo.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.mongo.model.Cliente;
import ceu.dam.ad.mongo.model.ClienteRequest;
import ceu.dam.ad.mongo.services.ClienteService;
import ceu.dam.ad.mongo.services.DatosIncorrectosException;

import jakarta.validation.Valid;

@RestController
public class ClienteApiService {
	@Autowired
	private ClienteService service;
	
	@GetMapping("/cliente/{id}")
	public Cliente consultarClientePorId(@PathVariable String id) throws DatosIncorrectosException{
		return service.consultarClienteById(id);
	}
	@GetMapping("/cliente")
	public Cliente consultarClientPorDni(@RequestParam String dni) throws DatosIncorrectosException{
		return service.consultarClienteByDni(dni);
	}
	@PostMapping("/cliente")
	public Cliente crearCliente(@Valid @RequestBody ClienteRequest request) throws DatosIncorrectosException {
		Cliente client = new Cliente();
		ModelMapper mapper = new ModelMapper(); 
		mapper.map(request, client);
			return service.crearCliente(client);
	}
	@PutMapping("/cliente")
	public Cliente actualizarCliente(@Valid @RequestBody Cliente cliente) throws DatosIncorrectosException   {
		return service.actualizarCliente(cliente);
	}
}
