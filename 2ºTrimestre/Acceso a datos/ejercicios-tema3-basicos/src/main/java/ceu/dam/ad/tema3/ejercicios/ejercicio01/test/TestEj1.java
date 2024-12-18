package ceu.dam.ad.tema3.ejercicios.ejercicio01.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import ceu.dam.ad.tema3.ejercicios.ejercicio01.model.Pelicula;
import ceu.dam.ad.tema3.ejercicios.ejercicio01.services.PeliculasException;
import ceu.dam.ad.tema3.ejercicios.ejercicio01.services.PeliculasService;
@Component
public class TestEj1 {
	@Autowired
	private PeliculasService service;
	//dentro del test solucion 1 ConfigurableApplicationContext context
	public void test() throws PeliculasException {
		//PeliculasService service = context.getBean(PeliculasService.class);
		try{
			List<Pelicula> listaPelis = new ArrayList<>();
			listaPelis = service.consultarPeliculas();
			listaPelis.forEach(System.out::println);
			
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

}
