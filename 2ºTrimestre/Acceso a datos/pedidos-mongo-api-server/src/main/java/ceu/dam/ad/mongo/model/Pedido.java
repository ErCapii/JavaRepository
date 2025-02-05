package ceu.dam.ad.mongo.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Document
@Data
public class Pedido {
	@Id
	private String id;
	@NotBlank
	private Cliente cliente;
	@NotBlank
	private LocalDate fecha;
	@NotBlank
	private Integer numero;
	@NotBlank
	private List<PedidoDetalle> detalles;
	
}
