package ApuntesExamen.ProblemasBasicos.BarraDeProgreso;

public class ProgressBar {

	private Integer progreso;

	public ProgressBar() {
		progreso = 0;
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
		System.out.println(progreso+" %");
	}

}
