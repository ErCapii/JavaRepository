package ApuntesExamen.ProblemasBasicos.BarraDeProgreso;

public class TProgressBar extends Thread{

	private Integer progreso;

	public TProgressBar() {
		progreso = 0;
	}
	
	public Integer getProgreso() {
		return progreso;
	}

	public void empezar() {
		while (progreso < 100) {
			try {
				System.out.println(progreso + " %");
				Thread.sleep(300);
				progreso+=10;
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(progreso + " %");
	}
	
	@Override
	public void run() {
		empezar();
	}
}
