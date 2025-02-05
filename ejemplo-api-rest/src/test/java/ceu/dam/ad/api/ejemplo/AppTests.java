package ceu.dam.ad.api.ejemplo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import ceu.dam.ad.api.ejemplo.model.Coche;
import ceu.dam.ad.api.ejemplo.model.Conductor;
import ceu.dam.ad.api.ejemplo.service.CocheNotFoundException;
import ceu.dam.ad.api.ejemplo.service.CocheService;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppTests {
	
	@Autowired
	private CocheService service;
	private Coche coche;
	@BeforeEach
	void initTest() {
		coche = new Coche();
		coche.setMarca("test");
		coche.setModelo("test");
		coche.setConductores(new ArrayList<Conductor>());
		coche.getConductores().add(new Conductor());
		coche.getConductores().getLast().setNombre("awdawdaddad");
		coche.getConductores().getLast().setEdad(18);
		coche.getConductores().add(new Conductor());
		coche.getConductores().getLast().setNombre("addadad");
		coche.getConductores().getLast().setEdad(23);
	}
	
	@Test
	@Order(1)
	void testCrearCoche() {
		Coche cocheCreado = service.crearCoche(coche);
		assertNotNull(cocheCreado);
		assertEquals(1L, cocheCreado.getId());
	}
	
	@Test
	@Order(2)
	void testConsultarCoche() throws CocheNotFoundException {
		Coche cocheConsulta = service.consultarCoche(1L);
		assertEquals(cocheConsulta.getMarca(), coche.getMarca());
		assertEquals(2, cocheConsulta.getConductores().size());
	}
	
	@Test
	@Order(3)
	void testConsultarCocheNoExiste() {
		assertThrows(CocheNotFoundException.class, ()->service.borrarCoche(99L));
		
	}
	
	@Test
	@Order(4)
	void testBuscarCoche() throws CocheNotFoundException {
		List<Coche> resultado = service.buscarCoches("test");
		assertNotNull(resultado);
		assertEquals(1, resultado.size());
		assertEquals(coche.getModelo(), resultado.getFirst().getModelo());
	}
	@Test
	@Order(5)
	void testBorrarCoche() throws CocheNotFoundException {
		service.borrarCoche(1L);
		assertThrows(CocheNotFoundException.class, ()-> service.consultarCoche(1L));
		
	}
}
