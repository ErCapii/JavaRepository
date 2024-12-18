package Pruebas.PruebasJackSon;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Asignatura {

	private String titulo;
	@JsonIgnore
	private Integer horas;

	private Profesor profesor;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
}
