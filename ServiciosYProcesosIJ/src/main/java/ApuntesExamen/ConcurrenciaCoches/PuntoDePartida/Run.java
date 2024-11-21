package ApuntesExamen.ConcurrenciaCoches.PuntoDePartida;

public class Run {
	public static void main(String[] args) {
		Carrera carrera = new Carrera(1000,1);
		Coche cocheAlonso = new Coche("Alonso", 100, carrera);
		cocheAlonso.correrCarrera();
		carrera.imprimirPodio();
	}
}
