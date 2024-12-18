package ejemploRelaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ejemploRelaciones.model.Jugador;
@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer>{

}
