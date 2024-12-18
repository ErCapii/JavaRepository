package ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.Service;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.Ejercicio10Service;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.modelo.Libros;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.util.List;

public class Ejercicio10ServiceJack implements Ejercicio10Service {

    @Override
    public void escribirXMLLibros(String pathFile, List<Libro> lista) throws XMLExportException {
        XmlMapper xmlMapper = new XmlMapper();
        File xmlFile = new File(pathFile);
        try {
            Libros libros = new Libros();
            libros.setLibros(lista);
            xmlMapper.writeValue(xmlFile, libros);

        } catch (Exception e) {
            throw new XMLExportException("Error al escribir el fichero XML", e);
        }
    }

    @Override
    public List<Libro> leerXMLLibros(String pathFile) throws XMLExportException {
        try {
            File File = new File(pathFile);
            XmlMapper mapper = new XmlMapper();
            Libros libros = mapper.readValue(File, Libros.class);
            return libros.getLibros();
        } catch (Exception e) {
            throw new XMLExportException("Error al leer el fichero XML", e);
        }

    }
}
