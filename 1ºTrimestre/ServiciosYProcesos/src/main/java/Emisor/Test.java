package Emisor;

public class Test {

	public static void main(String[] args) {
		LanzadorEmisiones le = new LanzadorEmisiones("h-1", new Emisor("E-1",'*',5));
		System.out.println("Lanzador antes de start");
		System.out.println(le);
		le.start();
		System.out.println("Lanzador despues de start");
		System.out.println(le);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		le.interrupt();
		System.out.println("Lanzador interrumpido");
		System.out.println(le);
		try {
			le.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("Lanzador despues de terminar");
		System.out.println(le);
		
	}
}
