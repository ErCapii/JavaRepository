package MultihiloEjercicio5;

import java.util.TimerTask;

public class EmisorTimerTask extends TimerTask{
	private DefinicionDeUnEmisor definicionEmisor;
	private int pulsos;
	
	
	public EmisorTimerTask(DefinicionDeUnEmisor definicionEmisor) {
		this.definicionEmisor = definicionEmisor;
		this.pulsos = definicionEmisor.getPulsos();
	}


	@Override
	public void run() {
		if (pulsos > 0) {
			definicionEmisor.emiteUnitariamente();
			pulsos--;
			
		}else {
			cancel();
		}
	}

}
