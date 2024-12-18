package BotellaDeCaracteres.BotellaDeCaracteresRunneable;

import lombok.Data;

@Data
public class BotellaRunneable implements Runnable{

	public BotellaRunneable(String nombre, char caracter, int cantidad) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.cantidad = cantidad;
	}

	private String nombre;
	private char caracter;
	private int cantidad;
	private static long milis = 300;

	public void vaciar() {
		while (cantidad > 0) {
			System.out.print(caracter + " ");
			cantidad--;
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
	@Override
	public void run() {
		vaciar();
	}

	public static void main(String[] args) {
		BotellaRunneable botella1 = new BotellaRunneable("botella1", 'J', 3);
		BotellaRunneable botella2 = new BotellaRunneable("botella2", 'A', 6);
		BotellaRunneable botella3 = new BotellaRunneable("botella3", 'J', 3);
		
	
		new Thread(botella1).start();
		new Thread(botella2).start();
		new Thread(botella3).start();
		
		
	}

}
