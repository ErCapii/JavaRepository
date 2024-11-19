package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.ServiceSax;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Catalogo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services.CatalogoXMLException;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services.Ejercicio12Service;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class CatalogoSaxService implements Ejercicio12Service {

    @Override
    public void exportXML(Catalogo catalogo, String pathFile) throws CatalogoXMLException, XMLExportException {

    }

    @Override
    public Catalogo importXML(String pathFile) throws CatalogoXMLException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            CatalogoSaxHandler handler = new CatalogoSaxHandler();

            File file = new File(pathFile);
            saxParser.parse(file, handler);
            return handler.getCatalogo();
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el fichero", e);
        }
    }
}
