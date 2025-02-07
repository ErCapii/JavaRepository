package ceu.dam.ad.mongo.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Document
@Data
public class Pedido {
	@Id
	private String id;
	private Cliente cliente;
	private LocalDate fecha;
	@Positive
	private Integer numero;

	private List<PedidoDetalle> detalles;
	
}
