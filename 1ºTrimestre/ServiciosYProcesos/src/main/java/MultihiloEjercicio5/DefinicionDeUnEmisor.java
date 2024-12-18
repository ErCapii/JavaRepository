package MultihiloEjercicio5;

import lombok.Data;

@Data
public class DefinicionDeUnEmisor {

	private String nombre;
	private char caracter;
	private int pulsos;

	public DefinicionDeUnEmisor(String nombre, char caracter, int pulsos) {
		this.nombre = nombre;
		this.caracter = caracter;
		this.pulsos = pulsos;
	}

	public DefinicionDeUnEmisor(char caracter, int pulsos) {
		this.caracter = caracter;
		this.pulsos = pulsos;
	}

	public void emiteUnitariamente() {
		System.out.print(caracter);
		
	}
}
