package ceu.dam.ad.api.ejemplo.model;

import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Entity
@Data
public class Conductor {
	@Id
	@GeneratedValue
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private UUID uuidConductor;
	@NotBlank(message = "El nombre es obligatorio tontito")
	@Size(min = 6)
	private String nombre;
	@NotNull(message = "La edad tambien es obligatorio tontito")
	@Min(value = 18, message = "La edad minima es 18 tontito")
	private Integer edad;
}
