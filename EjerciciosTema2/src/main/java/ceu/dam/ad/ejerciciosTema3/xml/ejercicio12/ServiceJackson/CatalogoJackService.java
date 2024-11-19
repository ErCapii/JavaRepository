package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.ServiceJackson;

import java.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Catalogo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services.CatalogoXMLException;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services.Ejercicio12Service;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class CatalogoJackService implements Ejercicio12Service{

	@Override
	public void exportXML(Catalogo catalogo, String pathFile) throws CatalogoXMLException, XMLExportException {
		XmlMapper xmlMapper = new XmlMapper();
		File file = new File(pathFile);
		try {
			xmlMapper.writeValue(file, catalogo);
		}catch (Exception e) {
			throw new XMLExportException("Error al escribir el fichero XML", e);
		}
	}

	@Override
	public Catalogo importXML(String pathFile) throws CatalogoXMLException {
		XmlMapper xmlMapper = new XmlMapper();
		File xmlFile = new File(pathFile);
		try {
			Catalogo catalogo = xmlMapper.readValue(xmlFile, Catalogo.class);
			return catalogo;
		}catch (Exception e) {
			throw new CatalogoXMLException("Error al leer el archivo xml", e);
		}		
	}
	

}
