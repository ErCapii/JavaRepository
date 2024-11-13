package ceu.dam.ad.ejerciciosTema3.xml.ejercicio07.ServiceLeer;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Persona;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio07.Ejercicio07Service;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio07ServiceLeer implements Ejercicio07Service {
    @Override
    public List<Largometraje> importarXML(String fichero) throws XMLImportException {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File(fichero);
            Document xml = builder.parse(fichero);

            Element peliculasTag = xml.getDocumentElement();
            NodeList peliculasList = peliculasTag.getElementsByTagName("pelicula");
            List<Largometraje> peliculas = new ArrayList<>();

            for (int i = 0; i < peliculasList.getLength(); i++) {
                Element peliculaTag = (Element) peliculasList.item(i);
                Largometraje pelicula = new Largometraje();

                Element tituloTag = (Element) peliculaTag.getElementsByTagName("titulo").item(0);
                pelicula.setTitulo(tituloTag.getTextContent());
                Element duracionTag = (Element) peliculaTag.getElementsByTagName("duracion").item(0);
                pelicula.setDuracion(Integer.parseInt(duracionTag.getTextContent()));
                Element añoTag = (Element) peliculaTag.getElementsByTagName("año").item(0);
                pelicula.setAño(Integer.parseInt(añoTag.getTextContent()));
                Element artistasTag = (Element) peliculaTag.getElementsByTagName("artistas").item(0);
                NodeList artistasList = artistasTag.getElementsByTagName("artista");
                List<Persona> artistas = new ArrayList<>();

                for (int j = 0; j < artistasList.getLength(); j++) {

                    Persona artista = new Persona();
                    Element artistaTag = (Element) artistasList.item(j);
                    String tipo = artistaTag.getAttribute("tipo");
                    Element nombreTag = (Element) artistaTag.getElementsByTagName("nombre").item(0);
                    artista.setNombre(nombreTag.getTextContent());
                    Element nacionalidadTag = (Element) artistaTag.getElementsByTagName("nacionalidad").item(0);
                    artista.setNacionalidad(nacionalidadTag.getTextContent());

                    switch (tipo) {
                        case "direccion":
                            pelicula.setDireccion(artista);
                            break;
                        case "produccion":
                            pelicula.setProduccion(artista);
                            break;
                        case "actores":
                            artistas.add(artista);
                            break;
                    }
                }
                pelicula.setActores(artistas);
                peliculas.add(pelicula);
            }
            return peliculas;
        } catch (Exception e) {
            throw new XMLImportException("Error al importar el fichero XML", e);
        }


    }
}
