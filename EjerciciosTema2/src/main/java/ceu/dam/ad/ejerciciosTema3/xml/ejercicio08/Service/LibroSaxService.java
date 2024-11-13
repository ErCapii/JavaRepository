package ceu.dam.ad.ejerciciosTema3.xml.ejercicio08.Service;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

public class LibroSaxService {

    public List<Libro> leerLibros(String pathFile) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            LibroSaxHandler handler = new LibroSaxHandler();

            File file = new File(pathFile);
            saxParser.parse(file, handler);
            return handler.getLibros();
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el fichero", e);
        }
    }

}
