package ExecutorServiceFixedPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {
		Lanzabolas lanzabolas1 = new Lanzabolas("lanzabolas1");
		Lanzabolas lanzabolas2 = new Lanzabolas("lanzabolas2");
		Lanzabolas lanzabolas3 = new Lanzabolas("lanzabolas3");
		ExecutorService executor1 = Executors.newFixedThreadPool(9);
	
		for (int i = 0; i < 9; i++) {
			executor1.execute(lanzabolas1);
			executor1.execute(lanzabolas2);
			executor1.execute(lanzabolas3);
			
		}
	}
}
