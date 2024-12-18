package ApuntesExamen.Ejercicio1.ImplementacionMonoHilo;

public class Botella {
	private String nombre;
	private char caracter;
	private int cantidad;
	private static long milis =300;
	public Botella(String nombre, char caracter, int cantidad) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.cantidad = cantidad;
	}
	
	public void vaciar() {
		while(cantidad > 0) {
			System.out.print(caracter);
			cantidad--;
			try {
				Thread.sleep(milis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} 
	
	public static void main(String[] args) {
		Botella b1 = new Botella("B-1", '*', 10);
		b1.vaciar();
		Botella b2 = new Botella("B-2", '-', 6);
		b2.vaciar();
	}
	// **********------ Imprime esto
	
}
