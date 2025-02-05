package ceu.dam.ad.api.sakila.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import ceu.dam.ad.api.sakila.model.Descansito;

@Repository
public interface DescansitoRepository extends MongoRepository<Descansito, String>, CustomDescansitoRepository {

    List<Descansito> findByProfesor(String profesor);
}

