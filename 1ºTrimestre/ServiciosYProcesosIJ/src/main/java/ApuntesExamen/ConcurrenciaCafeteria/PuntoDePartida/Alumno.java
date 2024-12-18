package ApuntesExamen.ConcurrenciaCafeteria.PuntoDePartida;

import java.util.Random;

public class Alumno implements Runnable{
	private Cafeteria cafeteria;
	
	public Alumno(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}
	
	public void consumir() {
		Random random = new Random();
		while(true) {
		}
	}

	@Override
	public void run() {
		consumir();
	}
}
