package BarraDePrograso;

public class LProgressBar {

	public void LanzarBarra(int start) {
		Runnable progresoRun = new Runnable() {
			
			@Override
			public void run() {
				ProgressBar pro = new ProgressBar(start);
				pro.avanzar();
				
			}
			
		};
		Thread hilo = new Thread(progresoRun);
		hilo.start();
	}
}
