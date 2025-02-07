package ceu.dam.ad.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Document
@Data
public class Cliente {
	@Id
	private String id;
	@NotBlank(message = "El dni del cliente no puede ser null")
	@Size(min = 9, max = 9)
	private String dni;
	@NotBlank(message = "El nombre del cliente no puede ser null")
	@Size(min = 3)
	private String nombre;
	@NotBlank(message = "La direccion del cliente no puede ser null")
	private String direccion;
	
	
}
