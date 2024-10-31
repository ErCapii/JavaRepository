package Luciernaga.Luciernaga;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Deletrator implements Runnable {

	private String palabra;

	private static int milis = 100;
	Random rm = new Random();

	public Deletrator(String nombre) {
		super();
		this.palabra = nombre;
	}

	public void enciende() {
		char[] letras = palabra.toCharArray();
		Integer letrasImpresas = 0;
		for (int e = 0; e < letras.length; e++) {
			System.out.print("Deletreando " + palabra + ":[");
			for (int i = 0; i < letras.length; i++) {
				if (letrasImpresas == i) {
					System.out.print(letras[e]);
				} else {
					System.out.print("-");
				}
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e1) {

					e1.printStackTrace();
				}
			}
			letrasImpresas++;
			System.out.print("]");
			System.out.println();
		}
	}

	@Override
	public void run() {
		enciende();

	}

	public static void main(String[] args) {

		Deletrator letra = new Deletrator("hola");
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.execute(letra);

//		Deletrator letra = new Deletrator("hola");
//		Deletrator letra2 = new Deletrator("adios");
//		ExecutorService executor = Executors.newFixedThreadPool(1);
//		ExecutorService executor2 = Executors.newFixedThreadPool(2);
//		executor.execute(letra);
//		executor2.execute(letra2);
	}
}
