package BarraDePrograso;

public class Test {
	
	public static void main(String[] args) {
		
		TProgressBar tp = new TProgressBar(0);
		//tp.start();
		
		Thread hilo =new Thread(new RProgressBar(0));
		//hilo.start();
		
		LProgressBar lp = new LProgressBar();
		//lp.LanzarBarra(0);
		
	}

}
