package Luciernaga.Luciernaga;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LuciernagaT implements Runnable{

	private String nombre;
	private boolean encendido;
	private int energia;
	private static int milis;
	Random rm = new Random();

	public LuciernagaT(String nombre, int energia) {
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
		
		LuciernagaT luz1 = new LuciernagaT("luz1", 300);
		LuciernagaT luz2 = new LuciernagaT("luz2", 300);
		LuciernagaT luz3 = new LuciernagaT("luz3", 300);
	    ExecutorService executor = Executors.newFixedThreadPool(1);
	    executor.execute(luz1);
	    executor.execute(luz2);
	    executor.execute(luz3);
//		new Thread(luz1).start();
//		new Thread(luz2).start();
//		new Thread(luz3).start();
	}
}
