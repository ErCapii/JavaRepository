package Luciernaga.Luciernaga;

import java.util.Random;

public class Luciernaga {

	private String nombre;
	private boolean encendido;
	private int energia;
	private static int milis;
	Random rm = new Random();

	public Luciernaga(String nombre, int energia) {
		super();
		this.nombre = nombre;
		this.encendido = false;

		this.energia = rm.nextInt(50) + 1;
	}

	public void enciende() {
		
		if (!encendido && energia > 0) {
			encendido = true;
			while (energia > 0) {
				System.out.println(nombre + " " + energia + " ");
				energia--;
				try {
					Thread.sleep(milis);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				if(energia <= 0 ) {
					encendido = false;
				}
			}
		}
	}
	public static void main(String[] args) {
		
		Luciernaga luz1 = new Luciernaga("luz1", 300);
		Luciernaga luz2 = new Luciernaga("luz2", 300);
		Luciernaga luz3 = new Luciernaga("luz3", 300);
		
		luz1.enciende();
		luz2.enciende();
		luz3.enciende();
		
	}
}
