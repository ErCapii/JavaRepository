package app.model;


public class Gato {

	private String raza;
	private String nombre;
	private Integer edad;
	
	private Gato() {
	}
	
	public Gato(String raza, String nombre, Integer edad) {
		super();
		this.raza = raza;
		this.nombre = nombre;
		this.edad = edad;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
}
