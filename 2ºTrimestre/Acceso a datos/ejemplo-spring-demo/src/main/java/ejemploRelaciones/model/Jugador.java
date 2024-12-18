package ejemploRelaciones.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Jugador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idJugador;
	private Integer dorsal;
	private String nombre;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_equipo", nullable = false)
	private Equipo equipo;
	
	public String toString() {
		return idJugador + " - " + dorsal + " - " + nombre;
	}
	

}
