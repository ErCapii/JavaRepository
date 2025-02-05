package ceu.dam.ad.tema3.ejercicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ceu.dam.ad.tema3.ejercicios.ejercicio01.services.PeliculasException;
import ceu.dam.ad.tema3.ejercicios.ejercicio04bien.test.TestEj4Bien;

@SpringBootApplication
public class App {

	public static void main(String[] args) throws PeliculasException {
		// Solucion rara
//		TestEj1 test = new TestEj1();
//		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
//		test.test(context, 100);
		// otra solu
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
//		TestEj1 test = context.getBean(TestEj1.class);
//		test.test();

//		TestEj2 test2 = context.getBean(TestEj2.class);
//		test2.test();
		
//		TestEj3 test3 = context.getBean(TestEj3.class);
//		test3.test();
		
		TestEj4Bien test4 = context.getBean(TestEj4Bien.class);
		test4.test();
	}

}
