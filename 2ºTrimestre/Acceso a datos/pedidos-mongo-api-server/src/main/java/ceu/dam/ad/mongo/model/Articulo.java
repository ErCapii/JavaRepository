package ceu.dam.ad.mongo.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Document
@Data
public class Articulo {
	@Id
	private String codigo;
	@NotBlank
	private String descripcion;
	@NotBlank
	private BigDecimal precio;
	
}
	
