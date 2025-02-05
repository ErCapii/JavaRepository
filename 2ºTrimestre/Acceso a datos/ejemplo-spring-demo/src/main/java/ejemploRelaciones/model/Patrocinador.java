package ejemploRelaciones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "patrocinadores")
public class Patrocinador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPatrocinador;
	private String marca;
	
	//private List<Equipo> equipos;
}
