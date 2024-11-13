package ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.Ejercicio4Service;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.Ejercicio04Service;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Edicion;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
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

public class Ejercicio4ServiceXml implements Ejercicio04Service {

    private final static Logger log = LoggerFactory.getLogger(Ejercicio4ServiceXml.class);
    @Override
    public void exportXML(List<Libro> libros, String pathFile) throws XMLExportException {
        try {
            log.info("Exportando lista de libros a XML en {}", pathFile);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document xml = builder.newDocument();
            Element librosTag = xml.createElement("libros");
            xml.appendChild(librosTag);
            log.debug("Creando libros");

            for (Libro libro : libros) {
                log.debug("Creando tag libro: " + libro);
                Element libroTag = xml.createElement("libro");

                // Establecer el ISBN como atributo en el elemento libro
                libroTag.setAttribute("isbn", libro.getIsbn().toString());
                librosTag.appendChild(libroTag);

                Element tituloTag = xml.createElement("titulo");
                tituloTag.setTextContent(libro.getTitulo());
                libroTag.appendChild(tituloTag);

                Element autoresTag = xml.createElement("autores");
                libroTag.appendChild(autoresTag);

                for (String autor : libro.getAutores()) {
                    Element autorTag = xml.createElement("autor");
                    autorTag.setTextContent(autor);
                    autoresTag.appendChild(autorTag);
                }

                Element edicionesTag = xml.createElement("ediciones");
                libroTag.appendChild(edicionesTag);

                for (Edicion edicion : libro.getEdiciones()) {
                    Element edicionTag = xml.createElement("edicion");
                    edicionesTag.appendChild(edicionTag);

                    Element fechaTag = xml.createElement("fecha");
                    fechaTag.setTextContent(edicion.getAño().toString());
                    edicionTag.appendChild(fechaTag);

                    Element editorialTag = xml.createElement("editorial");
                    editorialTag.setTextContent(edicion.getEditorial());
                    edicionTag.appendChild(editorialTag);
                }
            }

            log.debug("Creando fichero XML en {}", pathFile);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(xml);
            StreamResult result = new StreamResult(pathFile);
            transformer.transform(source, result);

        } catch (Exception e) {
            log.error("Error al exportar lista de libros a XML", e);
            throw new RuntimeException(e);
        }
    }

}
