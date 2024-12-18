package ExecutorServiceFixedPool;

import java.time.LocalDateTime;

public class Lanzabolas implements Runnable{

	private String nombre;
	
	public Lanzabolas(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		System.out.println("Lanzando bola desde "+ nombre + " a las " + LocalDateTime.now());
	}

	

	

}
