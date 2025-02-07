package ceu.dam.ad.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.dam.ad.mongo.model.Cliente;
import ceu.dam.ad.mongo.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRp;


	@Override
	public Cliente crearCliente(Cliente cliente) throws DatosIncorrectosException {
		if (clienteRp.findOneByDni(cliente.getDni()).isPresent()) {
		    throw new DatosIncorrectosException("El cliente ya existe");
		}
		return clienteRp.save(cliente);
	}

	@Override
	public Cliente actualizarCliente(Cliente cliente) throws DatosIncorrectosException {
		if (clienteRp.findById(cliente.getId()) == null || clienteRp.findOneByDni(cliente.getDni()) == null) {
		    throw new DatosIncorrectosException("El cliente no existe");
		}
		return clienteRp.save(cliente);
	}

	@Override
	public Cliente consultarClienteById(String id) throws DatosIncorrectosException {
		return clienteRp.findById(id).orElseThrow(() -> new DatosIncorrectosException());

	}

	@Override
	public Cliente consultarClienteByDni(String dni) throws DatosIncorrectosException {
		return clienteRp.findOneByDni(dni).orElseThrow(() -> new DatosIncorrectosException());
	}

}
