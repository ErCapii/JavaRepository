package ceu.dam.ad.tema3.ejercicios.ejercicio03.service;

import java.sql.Connection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.tema3.ejercicios.ejercicio02.model.Cliente;
import ceu.dam.ad.tema3.ejercicios.ejercicio02.repository.ClientesRepository;
import ceu.dam.ad.tema3.ejercicios.ejercicio03.model.Pago;
import ceu.dam.ad.tema3.ejercicios.ejercicio03.repository.PagosRepository;

@Service
public class PagosService {

	private static final Logger log = LoggerFactory.getLogger(PagosService.class);
	@Autowired
	private ClientesRepository clienteRepository;
	@Autowired
	private PagosRepository pagoRepository;

	public Map<String, List<Pago>> consultarPagosClientes() throws PagosException {
		try {
			Map<String, List<Pago>> mapa = new HashMap<>();
			List<Cliente> clientes = clienteRepository.findAll();
			List<Pago> pagos = pagoRepository.findAll();

			// Agrupar pagos por cliente ID
			Map<Long, List<Pago>> pagosPorCliente = pagos.stream().collect(Collectors.groupingBy(Pago::getIdCliente));

			// Construir el mapa de email -> lista de pagos
			for (Cliente cliente : clientes) {
				mapa.put(cliente.getEmail(), pagosPorCliente.getOrDefault(cliente.getId(), Collections.emptyList()));
			}
			
			return mapa;
		} catch (DataAccessException e) {
			System.err.println("Error al obtener pagos de clientes de bbdd");
			throw new PagosException("Error al obtener pagos de cliente", e);
		}
	}
}
