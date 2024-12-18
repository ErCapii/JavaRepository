package Pruebas.PruebasJackSon;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class Profesor {
	@JacksonXmlText
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
