package ceu.dam.ad.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Document
@Data
public class PedidoDetalle {
	@Id
	private Articulo articulo;
	@NotBlank
	private Integer cantidad;
	
}
