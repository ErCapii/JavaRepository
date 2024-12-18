package Emisor;

import lombok.Data;
@Data
public class Emisor{ 


	private String nombre;
	private char caracter;
	private Integer tiempoSegundos;
	private static int milis = 300;
  
  
  
	
	public Emisor(String nombre, char string, Integer tiempoSegundos) {
		super();
		this.nombre = nombre;
		this.caracter = string;
		this.tiempoSegundos = tiempoSegundos;
	}

	
	public void emite() {
		final String ANSI_RESET = "\u001B[0m";    // Resetea el color
		final String ANSI_GREEN = "\u001B[32m";   // Color verde
		final String ANSI_RED = "\u001B[31m";     // Color rojo
		
		long milisAlFinal = System.currentTimeMillis() + tiempoSegundos * 1000;
		long milisParaProximaEmision = System.currentTimeMillis() + milis;
		System.out.print(ANSI_GREEN + caracter + ANSI_RESET);
		while(System.currentTimeMillis() < milisAlFinal) {
			if(Thread.currentThread().isInterrupted()) {
				return;
			}
			if(System.currentTimeMillis() > milisParaProximaEmision) {
				System.out.print(caracter);
				milisParaProximaEmision = System.currentTimeMillis() + milis;
			}
		}
		System.out.print(ANSI_RED + caracter + ANSI_RESET);
	}
	
	
}
