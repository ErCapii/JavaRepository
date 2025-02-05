package ceu.dam.ad.users.model;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "ID del actor, Autogenerado en peticiones POST")
	private Long id;
	@NotNull(message = "El nombre es obligatorio")
	@Size(min = 3, max = 50)
	private String username;
	@NotNull(message = "El email es obligatorio")
	@Size(min = 3, max = 50)
	private String email;
	@NotNull(message = "La password es obligatoria")
	@Size(min = 8, max = 100)
	private String password;
	@Column(name = "fecha_alta")
	private LocalDate createdDate;
	@Column(name = "fecha_ultimo_login")
	private LocalDate lastLoginDate;
	
	
	

}
