package ceu.dam.ad.api.sakila.repository;

import java.util.List;

import ceu.dam.ad.api.sakila.model.Descansito;

public interface CustomDescansitoRepository {

	public List<Descansito> buscarPorNumAlumnos(Integer minNumAlumnos);
	
	public List<Descansito> buscarPorEdadAlumnos(Integer edad);
}
