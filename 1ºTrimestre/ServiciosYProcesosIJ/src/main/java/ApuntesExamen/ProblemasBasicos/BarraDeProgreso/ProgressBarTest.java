package ApuntesExamen.ProblemasBasicos.BarraDeProgreso;

public class ProgressBarTest {

	public static void main(String[] args) {
		TProgressBar t = new TProgressBar();
		RProgressBar r = new RProgressBar();
		LProgressBar l = new LProgressBar();
		
		t.start();
		new Thread(r).start();
		l.lanzar();
	}

}
