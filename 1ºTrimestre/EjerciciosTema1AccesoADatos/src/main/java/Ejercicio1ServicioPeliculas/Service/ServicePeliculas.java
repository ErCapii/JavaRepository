package Ejercicio1ServicioPeliculas.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Ejercicio1ServicioPeliculas.Dao.PeliculasDao;
import Ejercicio1ServicioPeliculas.modelo.Pelicula;

public class ServicePeliculas extends Service{
	
	private PeliculasDao dao;

	public ServicePeliculas() {
		dao = new PeliculasDao();
	}

	public List<Pelicula> filtrarPeliculas(Integer longitud) throws PeliculasException{
		
		try(Connection conn = abrirConexion()){
			return dao.listaPeliculas(conn).stream().filter(p -> p.getLongitud() < longitud).toList();
		} catch (SQLException e) {
			System.out.println("Error al consultar las peliculas");
			throw new PeliculasException("Error al consultar la base de datos", e);
		}
	}
}
