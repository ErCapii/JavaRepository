package ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.Service;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.Ejercicio06Service;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.List;

public class Ejercicio6Service implements Ejercicio06Service {
    private final static Logger log = LoggerFactory.getLogger(Ejercicio6Service.class);

    @Override
    public void exportarXML(List<Largometraje> peliculas, String fichero) throws XMLExportException {
        try {
            log.info("Exportando lista de peliculas a XML en {}", fichero);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xml = builder.newDocument();
            Element peliculasTag = xml.createElement("peliculas");
            xml.appendChild(peliculasTag);
            log.debug("Creando peliculas");
            for (Largometraje pelicula : peliculas) {
                log.debug("Creando tag pelicula: " + pelicula);
                Element peliculaTag = xml.createElement("pelicula");
                peliculasTag.appendChild(peliculaTag);

                Element tituloTag = xml.createElement("titulo");
                tituloTag.setTextContent(pelicula.getTitulo());
                peliculaTag.appendChild(tituloTag);

                Element duracionTag = xml.createElement("duracion");
                duracionTag.setTextContent(pelicula.getDuracion().toString());
                peliculaTag.appendChild(duracionTag);

                Element anioTag = xml.createElement("año");
                anioTag.setTextContent(pelicula.getAnio().toString());
                peliculaTag.appendChild(anioTag);

                Element artistasTag = xml.createElement("artistas");
                peliculaTag.appendChild(artistasTag);
                // Elemento direccion
                extracted(pelicula, xml, artistasTag, "direccion");
                // Elemento produccion
                extracted(pelicula, xml, artistasTag, "produccion");
                // Elemento actores
                for (Largometraje pelis : peliculas) {
                    extracted(pelis, xml, artistasTag, "actores");
                }
            }
            log.debug("Exportando XML a fichero");
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(xml);
            StreamResult result = new StreamResult(fichero);
            transformer.transform(source, result);
        } catch (Exception e) {
            log.error("Error al exportar a XML", e);
            throw new XMLExportException(e);
        }
    }

    private void extracted(Largometraje pelicula, Document xml, Element artistasTag, String atributo) {
        Element direccionTag = xml.createElement("artista");
        artistasTag.appendChild(direccionTag);
        direccionTag.setAttribute("tipo", atributo);
        Element nombreTag = xml.createElement("nombre");
        nombreTag.setTextContent(pelicula.getDireccion().getNombre());
        direccionTag.appendChild(nombreTag);
        Element nacionalidadTag = xml.createElement("nacionalidad");
        nacionalidadTag.setTextContent(pelicula.getDireccion().getNacionalidad());
        direccionTag.appendChild(nacionalidadTag);
    }


}
