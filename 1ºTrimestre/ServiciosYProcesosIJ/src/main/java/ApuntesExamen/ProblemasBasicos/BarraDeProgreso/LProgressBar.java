package ApuntesExamen.ProblemasBasicos.BarraDeProgreso;

public class LProgressBar {

	public void lanzar() {
		Runnable progressBar = new Runnable() {
			
			@Override
			public void run() {
				ProgressBar barra = new ProgressBar();
				barra.empezar();
			}
		};
		
		Thread hilo = new Thread(progressBar);
		hilo.start();
		
	}

}

