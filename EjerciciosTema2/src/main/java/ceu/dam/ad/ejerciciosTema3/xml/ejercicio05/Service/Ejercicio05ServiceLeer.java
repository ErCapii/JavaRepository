package ceu.dam.ad.ejerciciosTema3.xml.ejercicio05.Service;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Edicion;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio05.Ejercicio05Service;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio05ServiceLeer implements Ejercicio05Service {

    @Override
    public List<Libro> importXML(String pathFile) throws XMLImportException {
        List<Libro> libros = new ArrayList<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File fichero = new File(pathFile);
            Document xml = builder.parse(fichero);

            Element librosTag = xml.getDocumentElement();
            NodeList librosList = librosTag.getElementsByTagName("libro");

            for (int i = 0; i < librosList.getLength(); i++) {
                Element libroTag = (Element) librosList.item(i);
                Libro libro = new Libro();

                Integer isbn = Integer.parseInt(libroTag.getAttribute("isbn"));
                libro.setIsbn(isbn);

                Element tituloTag = (Element) libroTag.getElementsByTagName("titulo").item(0);
                libro.setTitulo(tituloTag.getTextContent());

                Element autoresTag = (Element) libroTag.getElementsByTagName("autores").item(0);
                NodeList autoresList = autoresTag.getElementsByTagName("autor");
                List<String> autores = new ArrayList<>();

                for (int j = 0; j < autoresList.getLength(); j++) {
                    Element autorTag = (Element) autoresList.item(j);
                    autores.add(autorTag.getTextContent());
                }
                libro.setAutores(autores);

                Element edicionesTag = (Element) libroTag.getElementsByTagName("ediciones").item(0);
                NodeList edicionesList = edicionesTag.getElementsByTagName("edicion");
                List<Edicion> ediciones = new ArrayList<>();

                for (int k = 0; k < edicionesList.getLength(); k++) {
                    Element edicionTag = (Element) edicionesList.item(k);
                    Edicion edicion = new Edicion();

                    Integer fecha = Integer.parseInt(edicionTag.getElementsByTagName("fecha").item(0).getTextContent());
                    edicion.setAño(fecha);
                    String editorial = edicionTag.getElementsByTagName("editorial").item(0).getTextContent();
                    edicion.setEditorial(editorial);

                    ediciones.add(edicion);
                }
                libro.setEdiciones(ediciones);
                libros.add(libro);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new XMLImportException("Error al importar el archivo XML", e);
        }
        return libros;
    }


}

