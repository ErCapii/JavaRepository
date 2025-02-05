package ceu.dam.ad.api.ejemplo.model;

import java.util.List;

import org.hibernate.annotations.Fetch;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Coche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "ID del cliente, Autogenerado en peticiones POST")
	private Long id;
	@NotBlank(message = "La marca es obligatoria tontito")
	private String marca;
	@NotBlank(message = "El modelo tambien es obligatorio tontito")
	private String modelo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_coche", nullable = false)
	@Size(min = 1, message = "Es obligatorio al menos un conductor tontito")
	@Valid
	private List<Conductor> conductores;
}
