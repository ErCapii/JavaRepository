package ApuntesExamen.ConcurrenciaCafeteria.PuntoDePartida;

public class Cafeteria {
	private static final Integer AFORO_MAXIMO = 50;
	private static Integer entradas = 0;
	private static Integer salidas = 0;
	
	private Integer aforoActual;
	
	public Cafeteria() {
		aforoActual = 0;
	}
	
	public boolean haySitio() {
		return false;//Lo he puesto  yo para q no pete

	}
	
	public void entraPersona() {
		
		System.out.println("Entra persona. Aforo actual = " + aforoActual);
	}
	
	public void salePersona() {
		System.out.println("Sale persona. Aforo actual = " + aforoActual);
		if(entradas - salidas -aforoActual != 0) System.exit(0);
	}
}
