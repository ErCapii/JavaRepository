package Pruebas;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class CroquetaXMLService {

//    public List<Croqueta> leerXmlCroquetas(String pathfile) {
//        List<Croqueta> croquetas = new ArrayList<>();
//        try {
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            File fichero = new File(pathfile);
//            Document xml = builder.parse(fichero);
//
//            Element croquetasTag = xml.getDocumentElement();
//            NodeList croquetasList =  croquetasTag.getElementsByTagName("croqueta");
//            for (int i = 0; i < croquetasList.getLength(); i++) {
//                croquetasList.item(i);
//                Element croquetaTag = (Element) croquetasList.item(i);
//                Croqueta croqueta = new Croqueta();
//                Integer id = Integer.parseInt(croquetaTag.getAttribute("id"));
//                croqueta.setId(id);
//                Element nombreTag = (Element) croquetaTag.getElementsByTagName("nombre").item(0);
//                croqueta.setNombre(nombreTag.getTextContent());
//                Element texturaTag = (Element) croquetaTag.getElementsByTagName("textura").item(0);
//                croqueta.setTextura(texturaTag.getTextContent());
//                Element tamañoTag = (Element) croquetaTag.getElementsByTagName("tamaño").item(0);
//                croqueta.setTamaño(tamañoTag.getTextContent());
//                Element ingredientesTag = (Element) croquetaTag.getElementsByTagName("ingredientes").item(0);
//                croqueta.setIngredientes(ingredientesTag.getTextContent());
//                croquetas.add(croqueta);
//
//
//
//            }
//
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
//
//        return croquetas;
//    }
//    public void escribirXmlCroquetas(List<Croqueta> lista, String pathfile) {
//        try {
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document xml = builder.newDocument();
//            Element croquetasTag = xml.createElement("croquetas");
//            xml.appendChild(croquetasTag);
//
//            for (Croqueta croqueta : lista) {
//                // Crear el elemento croqueta con el atributo id
//                Element croquetaTag = xml.createElement("croqueta");
//                croquetaTag.setAttribute("id", croqueta.getId().toString());  // Añadir el id como atributo
//                croquetasTag.appendChild(croquetaTag);
//
//                Element nombreTag = xml.createElement("nombre");
//                nombreTag.setTextContent(croqueta.getNombre());
//                croquetaTag.appendChild(nombreTag);
//
//                Element texturaTag = xml.createElement("textura");
//                texturaTag.setTextContent(croqueta.getTextura());
//                croquetaTag.appendChild(texturaTag);
//
//                Element tamañoTag = xml.createElement("tamaño");
//                tamañoTag.setTextContent(croqueta.getTamaño());
//                croquetaTag.appendChild(tamañoTag);
//
//                Element ingredientesTag = xml.createElement("ingredientes");
//                ingredientesTag.setTextContent(croqueta.getIngredientes());
//                croquetaTag.appendChild(ingredientesTag);
//            }
//
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource source = new DOMSource(xml);
//            StreamResult result = new StreamResult(pathfile);
//            transformer.transform(source, result);
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }



}

