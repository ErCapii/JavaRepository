package ceu.dam.ad.tema3.ejercicios.ejercicio04bien.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pedidos")
public class PedidoB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idPedido;
	@Column(name = "fecha_pedido")
	private LocalDate fechaPedido;
	@Column(name = "fecha_entrega")
	private LocalDate fechaEntrega;
	private String cliente;
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<PedidoLineaB> lineas;
	
	

}
