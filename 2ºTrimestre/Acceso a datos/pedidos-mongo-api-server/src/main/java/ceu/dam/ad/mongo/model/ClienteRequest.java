package ceu.dam.ad.mongo.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class ClienteRequest {

	@NotBlank
	private String dni;
	@NotBlank
	private String nombre;
	@NotBlank
	private String direccion;
}
