package ceu.dam.ad.tema3.ejercicios.ejercicio03.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "payment")
public class Pago {
	@Id
	@GeneratedValue()
	@Column(name = "payment_id")
	private long id;	
	@Column(name = "customer_id")
	private long idCliente;
	@Column(name = "payment_date")
	private LocalDate fecha;
	@Column(name = "amount")
	private BigDecimal importe;
	
	
}
