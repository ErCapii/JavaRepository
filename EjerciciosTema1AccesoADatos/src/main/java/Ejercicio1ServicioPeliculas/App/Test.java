package Ejercicio1ServicioPeliculas.App;

import java.util.List;

import Ejercicio1ServicioPeliculas.Service.PeliculasException;
import Ejercicio1ServicioPeliculas.Service.ServicePeliculas;
import Ejercicio1ServicioPeliculas.modelo.Pelicula;


public class Test {

	public static void main(String[] args) {
		ServicePeliculas service = new ServicePeliculas();
		
		try {
			List<Pelicula> lista = service.filtrarPeliculas(100);
			lista.forEach(System.out::println);
		}catch (PeliculasException e) {
			e.printStackTrace();
		}
	}

}
