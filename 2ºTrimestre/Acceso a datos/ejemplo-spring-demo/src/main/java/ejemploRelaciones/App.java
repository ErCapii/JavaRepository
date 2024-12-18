package ejemploRelaciones;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ejemploRelaciones.model.Equipo;
import ejemploRelaciones.model.Estadio;
import ejemploRelaciones.model.Jugador;
import ejemploRelaciones.repository.EquipoRepository;
import ejemploRelaciones.repository.JugadorRepository;
@SpringBootApplication
public class App {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		
		EquipoRepository repo = context.getBean(EquipoRepository.class);
		JugadorRepository repoJugador = context.getBean(JugadorRepository.class);
		Estadio estadio = new Estadio();
		estadio.setCapacidad(99999);
		estadio.setCiudad("SHANGAI");
		Equipo equipo = new Equipo();
		equipo.setNombre("CALAMARES FC");
		equipo.setEstadio(estadio);
		
//		repo.save(equipo);
//		repo.deleteById(2);
		
		Optional<Equipo> equipo1 = repo.findById(1);
		System.out.println(equipo1.get());
		
//		Jugador equipo1 = repoJugador.findById(3).get();
//		System.out.println(equipo1);
	}

}
