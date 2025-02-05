package ceu.dam.ad.api.sakila.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ceu.dam.ad.api.sakila.model.Descansito;
import ceu.dam.ad.api.sakila.repository.DescansitoRepository;

@Service
public class DescansitoService {

	@Autowired
	private DescansitoRepository descansitoRp;
	
	public Descansito crearDescanso(Descansito descanso) {
		return descansitoRp.save(descanso);
	}
	public List<Descansito> buscarPorProfesor(String profesor){
		return descansitoRp.findByProfesor(profesor);
	}
	
	public List<Descansito> buscarPorNumAlumnos(Integer minimo){
		return descansitoRp.buscarPorNumAlumnos(minimo);
	}
	
	public List<Descansito> buscarPorEdadAlumnos(Integer edad){
		return descansitoRp.buscarPorEdadAlumnos(edad);
	}
	
	
}
