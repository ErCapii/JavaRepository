package BarraDePrograso;

public class TProgressBar extends Thread{
    private ProgressBar progress;

	public TProgressBar(int progress) {
		this.progress = new ProgressBar(progress);
	}
	
	@Override
	public void run() {
		progress.avanzar();
	}
	
	
    
    
}
