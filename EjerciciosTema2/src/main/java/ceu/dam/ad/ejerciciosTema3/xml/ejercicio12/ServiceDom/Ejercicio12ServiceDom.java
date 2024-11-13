package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.ServiceDom;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Articulo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Catalogo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Pvp;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services.CatalogoXMLException;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services.Ejercicio12Service;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio12ServiceDom implements Ejercicio12Service {
    @Override
    public void exportXML(Catalogo catalogo, String pathFile) throws XMLExportException {
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xml = builder.newDocument();

            Element catalogoTag = xml.createElement("catalogo");
            catalogoTag.setAttribute("tamaño", String.valueOf(catalogo.getArticulos().size()));
            xml.appendChild(catalogoTag);

            Element articulosTag = xml.createElement("articulos");
            catalogoTag.appendChild(articulosTag);

            for (int i = 0; i < catalogo.getArticulos().size(); i++) {
                Element articuloTag = xml.createElement("articulo");
                articulosTag.appendChild(articuloTag);

                Element descripcionTag = xml.createElement("descripcion");
                descripcionTag.setTextContent(catalogo.getArticulos().get(i).getDescripcion());
                articuloTag.appendChild(descripcionTag);

                Element identificadorTag = xml.createElement("identificador");
                identificadorTag.setTextContent(catalogo.getArticulos().get(i).getSku());
                articuloTag.appendChild(identificadorTag);

                Element precioTag = xml.createElement("precio");
                precioTag.setTextContent(catalogo.getArticulos().get(i).getPvp().getPrecio().toString());
                articuloTag.appendChild(precioTag);

                Element modelosTag = xml.createElement("modelosDisponibles");
                articuloTag.appendChild(modelosTag);

                for (int j = 0; j < catalogo.getArticulos().get(i).getModelos().size(); j++) {
                    Element modeloTag = xml.createElement("modelo");
                    modelosTag.appendChild(modeloTag);

                    Element tallaTag = xml.createElement("talla");
                    tallaTag.setTextContent(catalogo.getArticulos().get(i).getModelos().get(j).getTalla());
                    modeloTag.appendChild(tallaTag);

                    Element colorTag = xml.createElement("color");
                    colorTag.setTextContent(catalogo.getArticulos().get(i).getModelos().get(j).getColor());
                    modeloTag.appendChild(colorTag);

                    Element codigosBarraTag = xml.createElement("codigosDeBarra");
                    modeloTag.appendChild(codigosBarraTag);

                    for (String codigo : catalogo.getArticulos().get(i).getModelos().get(j).getCodigosBarra()) {
                        Element codigoTag = xml.createElement("codigo");
                        codigoTag.setTextContent(codigo);
                        codigosBarraTag.appendChild(codigoTag);
                    }
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(xml);
            StreamResult result = new StreamResult(pathFile);
            transformer.transform(source, new StreamResult(pathFile));

        }catch (Exception e){
            throw new XMLExportException(e);
        }
    }

    @Override
    public Catalogo importXML(String pathFile) throws CatalogoXMLException {

        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xml = builder.parse(pathFile);

            Element catalogoTag = xml.getDocumentElement();
            Catalogo catalogo = new Catalogo();
            Element articulosTag = (Element) catalogoTag.getElementsByTagName("articulos").item(0);
            NodeList articulosList = articulosTag.getElementsByTagName("articulo");
            List<Catalogo> articulos = new ArrayList<>();

            for (int i = 0; i< articulosList.getLength(); i++){
                Element articuloTag = (Element) articulosList.item(i);
                Articulo articulo = new Articulo();
                Element descripcionTag = (Element) articuloTag.getElementsByTagName("descripcion").item(0);
                articulo.setDescripcion(descripcionTag.getTextContent());
                Element identificadorTag = (Element) articuloTag.getElementsByTagName("identificador").item(0);
                articulo.setSku(identificadorTag.getTextContent());
                Element precioTag = (Element) articulosTag.getElementsByTagName("precio").item(0);
                Pvp pvp = new Pvp();
                pvp.setPrecio(new BigDecimal(precioTag.getTextContent()));
                articulo.setPvp(pvp);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}


/*
<catalogo tamaño="10">
    <articulos>
        <articulo>
            <descripcion>lfa gxalymcxve axsr</descripcion>
            <identificador>ycpijj60627</identificador>
            <precio>804.11</precio>
            <modelosDisponibles>
                <modelo>
                    <talla>L</talla>
                    <color>Verde</color>
                    <codigosDeBarra>
                        <codigo>4665935597784</codigo>
                        <codigo>1419275103129</codigo>
                        <codigo>8364869602468</codigo>
                    </codigosDeBarra>
                </modelo>
 */
