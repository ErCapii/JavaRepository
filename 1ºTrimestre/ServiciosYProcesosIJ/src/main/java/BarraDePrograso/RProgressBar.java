package BarraDePrograso;

public class RProgressBar implements Runnable{
	
	private ProgressBar progress;

	public RProgressBar(int progress) {
		this.progress = new ProgressBar(progress);
	}
	
	@Override
	public void run() {
		progress.avanzar();
	}
	

}
