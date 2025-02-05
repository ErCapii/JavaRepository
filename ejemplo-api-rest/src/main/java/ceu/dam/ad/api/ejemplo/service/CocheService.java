package ceu.dam.ad.api.ejemplo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ceu.dam.ad.api.ejemplo.model.Coche;
import ceu.dam.ad.api.ejemplo.repository.CocheRepository;

@Service
public class CocheService {

	@Autowired
	private CocheRepository cocheRp;

	public Coche consultarCoche(Long id) throws CocheNotFoundException {

		return cocheRp.findById(id).orElseThrow(() -> new CocheNotFoundException());
	}

	public List<Coche> buscarCoches(String filtroMarca) throws CocheNotFoundException {

		List<Coche> lista = cocheRp.findByMarca(filtroMarca);
		if (lista.isEmpty()) {
			throw new CocheNotFoundException("Coche no enconctrado");
		}
		return lista;

	}
	@Transactional
	public Coche crearCoche(Coche coche) {
		return cocheRp.save(coche);
	}
	@Transactional
	public Coche actualizarCoche(Coche coche) throws CocheNotFoundException {
		consultarCoche(coche.getId());

		return cocheRp.save(coche);
	}
	@Transactional
	public void borrarCoche(Long id) throws CocheNotFoundException {
		consultarCoche(id);
		cocheRp.deleteById(id);
	}

}
