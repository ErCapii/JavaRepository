package ceu.dam.ad.ejerciciosTema3.xml.ejercicio08.Service;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Edicion;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import lombok.Data;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

@Data
public class LibroSaxHandler extends DefaultHandler {
    private Boolean openTag;
    private String textoTag;
    private List<Libro> libros;
    private Libro libro;
    private Edicion edicion;


    @Override
    public void startDocument() throws SAXException {
        libros = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        openTag = true;
        textoTag = "";
        switch (qName) {
            case "libros" -> libros = new ArrayList<>();
            case "libro" -> {
                libro = new Libro();
                libro.setIsbn(Integer.parseInt(attributes.getValue("isbn")));
                libros.add(libro);
            }
            case "autores" -> libro.setAutores(new ArrayList<>());
            case "ediciones" -> libro.setEdiciones(new ArrayList<Edicion>());
            case "edicion" -> {
                edicion = new Edicion();
                libro.getEdiciones().add(edicion);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        openTag = false;
        switch (qName) {
            case "titulo" -> libro.setTitulo(textoTag);
            case "autor" -> libro.getAutores().add(textoTag);
            case "año" -> {
                edicion.setAño(Integer.parseInt(textoTag));
                libro.getEdiciones().add(edicion);
            }
            case "editorial" -> {
                edicion.setEditorial(textoTag);
                libro.getEdiciones().add(edicion);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (openTag) {
            textoTag = new String(ch, start, length);
        }
    }
}


