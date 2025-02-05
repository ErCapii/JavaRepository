package ceu.dam.ad.api.sakila.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ceu.dam.ad.api.sakila.model.Descansito;

import java.util.List;

public class CustomDescansitoRepositoryImpl implements CustomDescansitoRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Descansito> buscarPorNumAlumnos(Integer minNumAlumnos) {
        Query query = new Query();
    
        query.addCriteria(Criteria.where("listaAlumnos").size(minNumAlumnos));
        
        return mongoTemplate.find(query, Descansito.class);
    }

	@Override
	public List<Descansito> buscarPorEdadAlumnos(Integer edad) {
		Query query = new Query();
        
       
        query.addCriteria(Criteria.where("listaAlumnos.edad").is(edad));
        
        return mongoTemplate.find(query, Descansito.class);
		
	}
    
    
    
}