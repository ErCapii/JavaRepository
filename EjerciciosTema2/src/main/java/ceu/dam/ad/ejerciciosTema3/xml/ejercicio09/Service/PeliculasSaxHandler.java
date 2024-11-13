package ceu.dam.ad.ejerciciosTema3.xml.ejercicio09.Service;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Persona;
import lombok.Data;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

@Data
public class PeliculasSaxHandler extends DefaultHandler {
    private Boolean openTag;
    private String textoTag;
    private Largometraje largometraje;
    private List<Largometraje> largometrajes;
    private String tipo;
    private Persona artista;

    @Override
    public void startDocument() throws SAXException {
        largometrajes = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        openTag = true;
        textoTag = "";
        switch (qName) {
            case "peliculas" -> largometrajes = new ArrayList<>();
            case "pelicula" -> {
                largometraje = new Largometraje();
                largometrajes.add(largometraje);
            }
            case "artistas" -> largometraje.setActores(new ArrayList<>());
            case "artista" -> {
                tipo = attributes.getValue("tipo");
                artista = new Persona();
                if (tipo.equals(Persona.DIRECCION)) {
                    largometraje.setDireccion(artista);
                } else if (tipo.equals(Persona.PRODUCCION)) {
                    largometraje.setProduccion(artista);
                } else if (tipo.equals(Persona.INTERPRETACION)) {
                    largometraje.getActores().add(artista);
                }

            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        openTag = false;
        switch (qName) {
            case "titulo" -> largometraje.setTitulo(textoTag);
            case "duracion" -> largometraje.setDuracion(Integer.parseInt(textoTag));
            case "año" -> largometraje.setAño(Integer.parseInt(textoTag));
            case "nombre" -> artista.setNombre(textoTag);
            case "nacionalidad" -> artista.setNacionalidad(textoTag);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (openTag) {
            textoTag = new String(ch, start, length);
        }
    }
}

