package Cafeteria.Alumno;

import java.util.Random;

import Cafeteria.Cafeteria.Cafeteria;

public class Alumno implements Runnable{
	private Cafeteria cafeteria;
	
	public Alumno(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}
	
	public void consumir() {
		Random random = new Random();
		while(true) {
			int segundosEsperandoFuera = random.nextInt(4);
			int segundosEsperandoDentro = random.nextInt(8);
			try {
				Thread.sleep(1000 * segundosEsperandoFuera);
				if (cafeteria.haySitio()) {
					cafeteria.entraPersona();
					Thread.sleep(1000*segundosEsperandoDentro);
					cafeteria.salePersona();
				}else {
					System.out.println("El alumno no ha podido entrar a la cafeteria");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void run() {
		consumir();
	}
}
