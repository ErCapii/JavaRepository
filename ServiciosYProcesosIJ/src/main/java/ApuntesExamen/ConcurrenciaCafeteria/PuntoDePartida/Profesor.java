package ApuntesExamen.ConcurrenciaCafeteria.PuntoDePartida;

import java.util.Random;

public class Profesor implements Runnable{
	private Cafeteria cafeteria;
	
	public Profesor(Cafeteria cafeteria) {
		this.cafeteria = cafeteria;
	}
	
	public void consumir() {

	}

	@Override
	public void run() {
		consumir();
	}
}
