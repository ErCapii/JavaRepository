package ApuntesExamen.Ejercicio1.MultihiloImpRun;


public class Botella implements Runnable {
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
	
	@Override
	public void run() {
		vaciar();
	}
	
	public static void main(String[] args) {
		Botella b1 = new Botella("B-1", '*', 10);
		Thread hilo1 = new Thread(b1);
		hilo1.start();
		
		Botella b2 = new Botella("B-2", '-', 6);
		new Thread(b2).start();
	}
}

//Imprime *-*-*-*-*-*-****
