package Pruebas.PruebasJackSon;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Alumno {

	@JacksonXmlProperty(isAttribute = true)
	private String dni;
	@JsonProperty("nombreApellidos")
	private String nombre;
	@JacksonXmlElementWrapper(localName = "asignaturas")
	@JsonProperty("asignatura")
	private List<Asignatura> asignaturas;

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	
	
	
}
