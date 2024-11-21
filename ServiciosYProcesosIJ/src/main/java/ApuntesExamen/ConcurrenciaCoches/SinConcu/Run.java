package ApuntesExamen.ConcurrenciaCoches.SinConcu;

import java.util.ArrayList;
import java.util.List;

public class Run {
	public static void main(String[] args) {
		
		/*
		Esto es un ejemplo de carrera con un número pequeño de coches (3 coches en el podio).
		Carrera carrera0 = new Carrera(300, 3); // Crea una nueva carrera de 300 km, con podio de tamaño 3
		ThreadGroup tg0 = new ThreadGroup("grupo0"); // Crea un grupo de hilos llamado "grupo0"
		
		// Crea y empieza 3 hilos (representando a 3 coches)
		Thread t1 = new Thread(tg0, new Coche("C-1", 100, carrera0));
		t1.start();
		Thread t2 = new Thread(tg0, new Coche("C-2", 100, carrera0));
		t2.start();
		Thread t3 = new Thread(tg0, new Coche("C-3", 100, carrera0));
		t3.start();
		
		// Espera a que todos los hilos terminen
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Imprime el número de hilos activos en el grupo después de que todos los coches terminen
		System.out.println(tg0.activeCount());
		carrera0.imprimirPodio(); // Imprime el podio de la carrera.
		*/
		
		// Ahora vamos a ejecutar una carrera con un número muy grande de coches (10,000 coches)
		int numCoches = 10_000; // Define el número de coches en la carrera
		Carrera carrera = new Carrera(300, numCoches); // Crea una nueva carrera de 300 km, con un podio de tamaño igual a numCoches
		ThreadGroup tg = new ThreadGroup("grupito"); // Crea un grupo de hilos llamado "grupito"
		List<Thread> hilos = new ArrayList<>(); // Lista para almacenar los hilos
		
		// Crea y empieza 10,000 hilos (representando a 10,000 coches)
		for (int i = 0; i < numCoches; i++) {
			Thread t = new Thread(tg, new Coche("C" + i, 100, carrera)); // Crea un nuevo coche con su hilo
			t.start();
			hilos.add(t); // Añade el hilo a la lista
		}
		
		// Espera a que todos los hilos terminen
		try {
			for (Thread thread : hilos) {
				thread.join(); // Espera a que cada coche termine la carrera
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Imprime el número de hilos activos en el grupo después de que todos los coches terminen
		System.out.println(tg.activeCount());
		
		// Espera un breve tiempo (2 segundos) antes de imprimir el podio
		try {
			Thread.sleep(2_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Imprime el podio de la carrera
		carrera.imprimirPodio();
	}
}

