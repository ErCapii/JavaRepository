package ceu.dam.ad.mongo.model;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class Articulo {

	private String codigo;
	@NotBlank(message = "La descripcion del articulo no puede ser null")
	private String descripcion;
	@NotNull(message = "La precio del articulo no puede ser null")
	@Positive
	private BigDecimal precio;
	
}
	
