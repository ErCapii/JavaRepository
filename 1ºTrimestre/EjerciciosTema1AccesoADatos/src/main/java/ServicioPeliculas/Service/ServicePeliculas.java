package ServicioPeliculas.Service;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import ServicioPeliculas.Dao.Dao;
import ServicioPeliculas.Peliculas.Pelicula;

public class ServicePeliculas extends ServiceDao{

	private Dao dao;


public List<Pelicula> borrarPorLongitud(Integer filtro) throws PeliculaServiceException{
		
	try (Connection conn = abrirConexion()){
	List<Pelicula> peliculas = dao.buscar(conn);
	for (Iterator iterator = peliculas.iterator(); iterator.hasNext();) {
		Pelicula pelicula = (Pelicula) iterator.next();
		if(pelicula.getLongitud()>filtro) {
			iterator.remove();
		}
	}
	return peliculas;
	} catch (SQLException e) {
		throw new PeliculaServiceException("No se puede lanzar la consulta sql "+ e.getMessage());
	}
}	
}
