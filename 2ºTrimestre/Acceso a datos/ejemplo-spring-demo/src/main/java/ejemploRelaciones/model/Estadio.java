package ejemploRelaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Estadio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstadio;
	private String ciudad;
	private Integer capacidad;

}
