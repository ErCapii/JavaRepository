package ApuntesExamen.ConcurrenciaCoches.SinConcu;

import java.util.Random;

public class Coche implements Runnable{
	
	private String nombre;               
	private Integer kmEntrePausas;      
	private Integer kmRecorridos;        
	private Carrera carrera;              
	
	// Constructor que inicializa los atributos del coche
	public Coche(String nombre, Integer kmEntrePausas, Carrera carrera) {
		this.nombre = nombre;              
		this.kmEntrePausas = kmEntrePausas; 
		this.carrera = carrera;           
		kmRecorridos = 0;              
	}
	
	// Método que simula el comportamiento del coche durante la carrera
	public void correrCarrera() {
		// El coche corre hasta que ha recorrido todos los kilómetros de la carrera
		do {
			avanzar();  // Avanza el coche
			System.out.printf("[Km %d] %s.%n ", kmRecorridos, nombre);  // Muestra en pantalla el kilómetro actual y el nombre del coche
			pausar();   // Hace una pausa aleatoria
		}
		while (kmRecorridos < carrera.getKmTotales());  // La carrera continúa hasta que se alcanza el total de kilómetros
		System.out.printf("%s ha finalizado la carrera.%n", nombre);  // Una vez finaliza la carrera, imprime el mensaje
		carrera.subirAlPodio(nombre);  // El coche sube al podio al terminar la carrera		
	}
	
	// Método que simula el avance del coche en la carrera
	public void avanzar() {
		kmRecorridos += kmEntrePausas;  // Incrementa los kilómetros recorridos por el coche
		if (kmRecorridos > carrera.getKmTotales()) {
			kmRecorridos = carrera.getKmTotales();  // Asegura que el coche no supere los kilómetros totales de la carrera
		}
	}
	
	// Método que simula la pausa aleatoria del coche
	public void pausar() {
		Random random = new Random();
		// El coche hace una pausa aleatoria entre 1 y 3 segundos
		try {
			Thread.sleep(1000 * (random.nextInt(3) + 1));  // Espera entre 1 y 3 segundos
		} catch (InterruptedException e) {
			e.printStackTrace();  // Si ocurre una excepción, la imprime en consola
		}
	}

	// Método que ejecuta el hilo del coche
	@Override
	public void run() {
		correrCarrera();  // Llama al método correrCarrera() cuando el hilo se inicia
	}
	
}

