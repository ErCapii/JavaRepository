package ceu.dam.ad.ejerciciosTema3.xml.ejercicio09.Service;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.List;

public class PeliculasSaxService {

    public List<Largometraje> leerPeliculas(String pathFile) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            PeliculasSaxHandler handler = new PeliculasSaxHandler();

            File file = new File(pathFile);
            saxParser.parse(file, handler);
            return handler.getLargometrajes();
        }catch (Exception e) {
            throw new RuntimeException("Error al leer el fichero", e);
        }
    }
}
