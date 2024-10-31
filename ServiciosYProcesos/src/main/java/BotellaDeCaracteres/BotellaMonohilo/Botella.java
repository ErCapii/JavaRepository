package BotellaDeCaracteres.BotellaMonohilo;

import lombok.Data;

@Data
public class Botella {

	
	public Botella(String nombre, char caracter, int cantidad) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.cantidad = cantidad;
	}
	private String nombre;
	private char caracter;
	private int cantidad;
	private static long milis = 20;
	
	public void vaciar() {
		while(cantidad > 0) {
			System.out.print(caracter+ " ");
			cantidad--;
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
			
		}
	public static void main(String[] args) {
			Botella botella1 = new Botella("botella1", 'A', 4);
			Botella botella2 = new Botella("botella2", 'B', 6);
			Botella botella3 = new Botella("botella3", 'C', 2);
			
			botella1.vaciar();
			botella2.vaciar();
			botella3.vaciar();
		}

}
