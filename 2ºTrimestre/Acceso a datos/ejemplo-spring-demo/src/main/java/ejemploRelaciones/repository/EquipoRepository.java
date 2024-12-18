package ejemploRelaciones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ejemploRelaciones.model.Equipo;
@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer>{

}
