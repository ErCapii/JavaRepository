package app.service;

import java.util.ArrayList;
import java.util.List;

import app.model.Gato;

public class GatoService {

	public List<Gato> consultarGatos(){
		List<Gato> lista = new ArrayList<Gato>();
		lista.add(new Gato("Persa", "Bigotitos", 3));
		lista.add(new Gato("De la calle", "Pelusilla", 2));
		lista.add(new Gato("Naranja", "Manchitas", 5));
		lista.add(new Gato("Persa", "Bigotitos", 3));
		lista.add(new Gato("De la calle", "Pelusilla", 2));
		lista.add(new Gato("Naranja", "Manchitas", 5));
		lista.add(new Gato("Persa", "Bigotitos", 3));
		lista.add(new Gato("De la calle", "Pelusilla", 2));
		lista.add(new Gato("Naranja", "Manchitas", 5));
		return lista; 
	}
}
