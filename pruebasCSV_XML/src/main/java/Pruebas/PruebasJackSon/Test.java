package Pruebas.PruebasJackSon;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Alumno alumno = new Alumno();
		alumno.setNombre("Blas de los montes");
		alumno.setDni("9837388D");
		alumno.setAsignaturas(new ArrayList<>());
		
		alumno.getAsignaturas().add(crearAsignatura("Acceso datos", "Carmen Camello"));
		alumno.getAsignaturas().add(crearAsignatura("Acceso a la nada", "Lucía Luque"));
		
		AlumnosXmlService service = new AlumnosXmlService();
		List<Alumno> lista = new ArrayList<>();
		lista.add(alumno);
		lista.add(alumno);
		lista.add(alumno);
		service.escribirXmlAlumnos(lista, "c:/temporal/alumno.xml");
		service.leerXmlAlumnos("c:/temporal/alumno.xml").forEach(System.out::println);
		service.leerJsonAlumnos("c:/temporal/alumno.xml").forEach(System.out::println);
		System.out.println("Fichero generado");
	}

	private static Asignatura crearAsignatura(String tituloAsignatura, String nombreProfe) {
		Asignatura a = new Asignatura();
		a.setHoras(32);
		a.setTitulo(tituloAsignatura);
		a.setProfesor(new Profesor());
		a.getProfesor().setNombre(nombreProfe);
		return a;
	}

}
