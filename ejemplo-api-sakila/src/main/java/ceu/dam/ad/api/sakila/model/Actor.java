package ceu.dam.ad.api.sakila.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "ID del actor, Autogenerado en peticiones POST")
	private Integer actorId;
	@NotNull(message = "El nombre es obligatorio")
	@Size(min = 3, max = 255)
	private String firstName;
	@NotNull(message = "El apellido es obligatorio")
	@Size(min = 3, max = 255)
	private String lastName;
	@PastOrPresent
	private LocalDate lastUpdate;

}
