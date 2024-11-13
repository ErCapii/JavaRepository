package ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
@JacksonXmlRootElement(localName = "libros")
public class Libros {
	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonProperty("libro")
	private List<Libro> libros;

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	

}
