package ceu.dam.ad.mongo.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ceu.dam.ad.mongo.model.Pedido;
import ceu.dam.ad.mongo.model.PedidoDetalle;
import ceu.dam.ad.mongo.services.DatosIncorrectosException;
import ceu.dam.ad.mongo.services.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
public class PedidoApiService {
	@Autowired
	private PedidoService service;

	@Operation(summary = "Consulta pedido por id", description = "Consulta un pedido mediante una id y lo devuelve")
	@GetMapping("/pedidoId")
	public Pedido consultarPedido(@RequestParam String id) throws DatosIncorrectosException {
		return service.consultarPedido(id);
	}

	@Operation(summary = "Consulta lista pedidos por dni", description = "Consulta una lista de pedido mediante un dni del cliente")
	@GetMapping("/pedidoDni/{dni}")
	public List<Pedido> consultarPedidoCliente(@PathVariable String dni) {
		return service.consultarPedidosCliente(dni);
	}

	@Operation(summary = "Consulta lista pedidos por dos fechas", description = "Consulta una lista de pedidos entre dos fechas")
	@GetMapping("/pedidoFechas")
	public List<Pedido> buscarPedidosEntreFechas(@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fecha1,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fecha2) {
		return service.buscarPedidos(fecha1, fecha2);
	}

	@Operation(summary = "Registrar pedido nuevo", description = "Permite registrar un nuevo pedido completo")
	@PostMapping("/pedido")
	public String registrarPedido(@Valid @RequestBody Pedido pedido) throws DatosIncorrectosException {
		return service.registrarPedido(pedido);
	}

	@Operation(summary = "Añadir detalle pedido", description = "Permite añadir detalle de pedido a un pedido")
	@PostMapping("/pedidoActualizar")
	public Pedido añadirDetallePedido(@Valid @RequestParam String id,@RequestBody PedidoDetalle detalles) throws DatosIncorrectosException {
	
		return service.añadirDetalle(id, detalles);
	}

}
