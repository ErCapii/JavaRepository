package MultihiloEjercicio5;

import java.util.Timer;

public class Test {

	public static void main(String[] args) {
		DefinicionDeUnEmisor de1 = new DefinicionDeUnEmisor('*', 25);
		Timer t1 = new Timer();
		EmisorTimerTask ett1 = new EmisorTimerTask(de1);
		
		System.out.println("Iniciando emision...");
		t1.scheduleAtFixedRate(ett1, 0, 500);
	}
}
