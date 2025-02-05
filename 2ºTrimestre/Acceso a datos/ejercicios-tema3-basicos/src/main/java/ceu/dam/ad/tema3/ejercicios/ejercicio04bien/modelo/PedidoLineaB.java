package ceu.dam.ad.tema3.ejercicios.ejercicio04bien.modelo;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pedidos_lineas_norm")
public class PedidoLineaB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLinea;
	@Column(name = "numero_linea")
	private Integer numLinea;
	private String articulo;
	private BigDecimal precio;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pedido", nullable = false)
	private PedidoB pedido;
	@Override
	public String toString() {	
			return idLinea + " - " + numLinea + " - " + articulo + " - " + precio;
	}
	
	


}
