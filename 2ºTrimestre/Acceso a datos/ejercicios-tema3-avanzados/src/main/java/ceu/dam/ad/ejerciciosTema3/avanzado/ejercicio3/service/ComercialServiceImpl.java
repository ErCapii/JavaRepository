package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.modelo.CentroComercial;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.modelo.Marca;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.modelo.Pais;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.modelo.Tienda;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.repository.CentroComercialRepository;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.repository.MarcaRepository;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.repository.PaisesRepository;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio3.repository.TiendaRepository;
import jakarta.transaction.Transactional;

@Service
public class ComercialServiceImpl implements ComercialService {
	@Autowired
	PaisesRepository paisRp;
	@Autowired
	MarcaRepository marcaRp;
	@Autowired
	CentroComercialRepository centroRp;
	@Autowired
	TiendaRepository tiendaRp;

	@Override
	public List<Pais> buscarPaises(String filtro) throws ComercialException {
		try {
			return paisRp.findByDescripcionStartingWith(filtro);
		} catch (DataAccessException e) {
			throw new ComercialException("Error al buscar el pais en la bbdd", e);
		}
	}

	@Override
	public void insertarMarca(Marca marca) throws ComercialException {
		try {
			marcaRp.save(marca);
		} catch (DataAccessException e) {
			throw new ComercialException("Error al instar la marca en la base de datos", e);
		}

	}

	@Override
	public void insertarCentroComercial(CentroComercial cc) throws ComercialException {
		try {
			cc.getMarcas().forEach(m -> marcaRp.findById(m.getCodigo()).get()); 
			paisRp.findById(cc.getPais().getCodigo()).get();

			centroRp.save(cc);
		} catch (Exception e) {
			throw new ComercialException("Error al insertar el centro comercial", e);
		}
	}

	@Override
	public CentroComercial consultarCentroComercial(String uuidCentro) throws ComercialException, NotFoundException {
		try {
			UUID uid = UUID.fromString(uuidCentro);
			return centroRp.findById(uid).orElseThrow(() -> new NotFoundException("No se ha encontrado el centro comercial"));
		} catch (DataAccessException e) {
			throw new ComercialException("Error al consultar el centro comercial", e);

		}
	}

	@Override
	public Tienda consularTienda(Long idTienda) throws ComercialException, NotFoundException {
		try {
			
			return tiendaRp.findById(idTienda).orElseThrow(() -> new NotFoundException("No se ha encontrado la tienda con id: " + idTienda));
		} catch (DataAccessException e) {
			throw new ComercialException("Error al consultar la tienda", e);
		}
	}

	@Override
	public void borrarTienda(Long idTienda) throws ComercialException {
		try {
			tiendaRp.deleteById(idTienda);
		} catch (DataAccessException e) {
			throw new ComercialException("Error al borrar la tienda", e);
		}
	}

	@Override
	@Transactional
	public void borrarCentroComercial(String uuidCentro) throws ComercialException {
		try {
			UUID uid = UUID.fromString(uuidCentro);
			centroRp.deleteById(uid);
		} catch (DataAccessException e) {
			throw new ComercialException("Error al borrar el centro comercial", e);
		}
	}

}
