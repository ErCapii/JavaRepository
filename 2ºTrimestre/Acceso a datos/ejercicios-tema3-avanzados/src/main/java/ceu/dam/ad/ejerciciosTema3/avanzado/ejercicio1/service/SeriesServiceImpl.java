package ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio1.model.Serie;
import ceu.dam.ad.ejerciciosTema3.avanzado.ejercicio1.repository.SerieRepository;
import jakarta.transaction.Transactional;

@Service
public class SeriesServiceImpl implements SeriesService {

	@Autowired
	SerieRepository serieRp;

	@Override
	public Serie consultarSerie(Long idSerie) throws SerieNotFoundException, SeriesServiceException {
		try {
			return serieRp.findById(idSerie)
					.orElseThrow(() -> new SerieNotFoundException("No existe el id" + idSerie));
		} catch (DataAccessException e) {
			throw new SeriesServiceException("Error al consultar la serie", e);
		}

	}

	@Override
	public List<Serie> buscarSeries(String filtroDescripcion) throws SerieNotFoundException, SeriesServiceException {
		try {

			List<Serie> listaSeries = serieRp.findByDescripcionContainingIgnoreCase(filtroDescripcion);
			if (listaSeries.isEmpty()) {
				throw new SerieNotFoundException("No se ha encontrado una serie con esa descripcion");
			}
			return listaSeries;
		} catch (DataAccessException e) {
			throw new SeriesServiceException("Error al consultar la serie", e);
		}

	}

	@Override
	@Transactional
	public Serie crearSerie(Serie serie) throws SeriesServiceException {
		try {
			Serie nuevaSerie = serieRp.save(serie);
			return nuevaSerie;
		} catch (DataAccessException e) {
			throw new SeriesServiceException("Error al crear la serie", e);
		}

	}

	@Override
	@Transactional
	public void elimnarSerie(Long idSerie) throws SeriesServiceException {
		try {
			serieRp.deleteById(idSerie);
		} catch (DataAccessException e) {
			throw new SeriesServiceException("Error al borrar la serie", e);
		}

	}

	@Override
	public void actualizarSerie(Serie serie) throws SeriesServiceException {
		try {
			crearSerie(serie);
		} catch (DataAccessException e) {
			throw new SeriesServiceException("Error al crear la serie", e);
		}

	}

}
