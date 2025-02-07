package ceu.dam.ad.mongo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PedidoDetalle {

	private Articulo articulo;
	@NotNull(message = "La cantidad de detalles del pedido no puede ser null")
	@Min(1)
	private Integer cantidad;
	
}
