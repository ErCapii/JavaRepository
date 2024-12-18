package ApuntesExamen.ConcurrenciaCoches.PuntoDePartida;

public class Carrera {

	// Atributos de la clase
	private Integer kmTotales;  // Kilómetros totales que tiene la carrera
	private String[] podio;  // Array que almacena el nombre de los coches que llegan al podio
	private Integer personasEnPodio;  // Número de coches que han llegado al podio (lugares ocupados)

	// Constructor de la clase Carrera
	public Carrera(Integer kmTotales, int podioSize) {
		this.kmTotales = kmTotales;  // Inicializa la distancia total de la carrera
		podio = new String[podioSize];  // Inicializa el array del podio con el tamaño dado
		personasEnPodio = 0;  // Inicializa el número de coches en el podio en 0
	}

	// Método que devuelve la distancia total de la carrera
	public Integer getKmTotales() {
		return kmTotales;
	}
	
	// Método que añade un coche al podio (si aún hay espacio en el podio)
	public void subirAlPodio(String nombreCoche) {
		// Verifica si hay espacio en el podio (lugares disponibles)
		if(personasEnPodio < podio.length) {
			// Añade el coche al podio en el siguiente lugar disponible
			podio[personasEnPodio] = nombreCoche;
			personasEnPodio++;  // Incrementa el número de coches en el podio
		}
	}
	
	// Método que imprime el podio con los nombres de los coches en los lugares ocupados
	public void imprimirPodio() {
		// Muestra el mensaje con el podio
		System.out.println("Podio de la carrera: ");
		// Imprime la posición en el podio para cada coche que ha llegado
		for (int i = 0; i < podio.length; i++) {
			System.out.printf("\tLugar %d -> %s%n", i + 1, podio[i]);
		}
	}
}

