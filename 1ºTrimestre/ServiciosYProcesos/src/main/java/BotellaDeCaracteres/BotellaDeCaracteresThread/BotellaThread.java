package BotellaDeCaracteres.BotellaDeCaracteresThread;

import lombok.Data;

@Data
public class BotellaThread extends Thread {

	public BotellaThread(String nombre, char caracter, int cantidad) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.cantidad = cantidad;
	}

	private String nombre;
	private char caracter;
	private int cantidad;
	private static long milis = 200;

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
		BotellaThread botella1 = new BotellaThread("botella1", 'j', 4);
		BotellaThread botella2 = new BotellaThread("botella2", 'a', 6);
		BotellaThread botella3 = new BotellaThread("botella3", 'j', 2);

		botella1.start();
		botella2.start();
		botella3.start();
	}

}
