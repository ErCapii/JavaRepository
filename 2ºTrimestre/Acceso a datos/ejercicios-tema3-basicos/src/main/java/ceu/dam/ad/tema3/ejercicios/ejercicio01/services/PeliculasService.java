package ceu.dam.ad.tema3.ejercicios.ejercicio01.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.tema3.ejercicios.ejercicio01.model.Pelicula;
import ceu.dam.ad.tema3.ejercicios.ejercicio01.repository.PeliculaRepository;
@Service
public class PeliculasService {
	@Autowired
	private PeliculaRepository repository;

	private static final Logger log = LoggerFactory.getLogger(PeliculasService.class);
	
	public List<Pelicula> consultarPeliculas() throws PeliculasException {
		return consultarPeliculas(100);
	}

	public List<Pelicula> consultarPeliculas(Integer longitud) throws PeliculasException {
		try {
			//return repository.findAll().stream().filter(p -> p.getLongitud() < longitud).toList();
			//es lo mismo que el de arriba
			return repository.findByLongitudLessThan(longitud);
			
		}catch (DataAccessException e) {
			throw new PeliculasException("Error al consultar en la base de datos", e); 
		}
	}



}
