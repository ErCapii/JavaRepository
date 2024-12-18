package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.Service.ActorNotFoundException;
import com.example.demo.Service.ActorService;
import com.example.demo.model.Actor;

@SpringBootApplication
public class App {

	public static void main(String[] args) throws ActorNotFoundException {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		
		ActorService service = context.getBean(ActorService.class);
		
		System.out.println(service.consultarActor(10L));
		
//		Actor a = new Actor();
//		
//		a.setFirstName("blas");
//		a.setLastName("de los montes");
//		
//		Actor b = new Actor();
//		
//		b.setFirstName("blason");
//		b.setLastName("de los montes malos");
//		
//		ArrayList<Actor> lista = new ArrayList<>();
//		
//		lista.add(a);
//		lista.add(b);
//		try {
//			service.crearActores(lista);
//		} catch (ActorServiceException e) {
//			System.out.println("Error insertando actor");
//		}
		//Consultamos el actor para cambiar solo un campo en concreto filtrando por la id
		Actor a1 = service.consultarActor(190L);
		a1.setLastName("Blas");
		service.actualizarActor(a1);
		
		service.borrarActor(209L);
		service.borrarActor(208L);
		
	}

}
