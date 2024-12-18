package Luciernaga.Luciernaga;

import java.util.Random;

public class LuciernagaR extends Thread{

	private String nombre;
	private boolean encendido;
	private int energia;
	private static int milis;
	Random rm = new Random();

	public LuciernagaR(String nombre, int energia) {
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
	@Override
	public void run() {
		enciende();
		
	}
	
	public static void main(String[] args) {
		
		LuciernagaR luz1 = new LuciernagaR("luz1", 300);
		LuciernagaR luz2 = new LuciernagaR("luz2", 300);
		LuciernagaR luz3 = new LuciernagaR("luz3", 300);
		
		luz1.start();
		luz2.start();
		luz3.start();
		
	}
}
