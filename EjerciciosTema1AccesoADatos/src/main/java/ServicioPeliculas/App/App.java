package ServicioPeliculas.App;

import java.util.List;

import ServicioPeliculas.Peliculas.Pelicula;
import ServicioPeliculas.Service.ServicePeliculas;

public class App {

	public static void main(String[] args) {
		ServicePeliculas service = new ServicePeliculas();
		
		try {
			List<Pelicula> pelis = service.borrarPorLongitud(100);
			for (Pelicula pelicula : pelis) {
				System.out.println(pelicula);
			}
		}catch (Exception e) {
			
		}
	}

}
