package ceu.dam.ad.api.sakila;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ceu.dam.ad.api.sakila.model.Alumno;
import ceu.dam.ad.api.sakila.model.Descansito;
import ceu.dam.ad.api.sakila.services.DescansitoService;

@SpringBootApplication
public class AppMondongo {

	
	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(AppMondongo.class, args);
		DescansitoService service = context.getBean(DescansitoService.class);
		Descansito d = new Descansito();
		d.setProfesor("Abel");
		d.setDuracion(20);
		d.setAutorizado(false);
		d.setListaAlumnos(new ArrayList<>());
		d.getListaAlumnos().add(new Alumno("Bladadw", 22, true));
		d.getListaAlumnos().add(new Alumno("Quisawdawdtian", 125, true));
		d.getListaAlumnos().add(new Alumno("moskdadawdatel", 11, false));
		
		//System.out.println(service.crearDescanso(d));
		//service.buscarPorNumAlumnos(3).forEach(System.out::println);
		service.buscarPorEdadAlumnos(22).forEach(System.out::println);
		
		
	}

}
