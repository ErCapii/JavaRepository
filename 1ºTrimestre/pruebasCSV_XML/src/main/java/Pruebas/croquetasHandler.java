package Pruebas;


import lombok.Data;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

@Data
public class croquetasHandler extends DefaultHandler {

    private Boolean openTag;
    private String texto;
    private List<Croqueta> croquetas;
    private Croqueta croqueta;
    private Ingrediente ingrediente;

    @Override
    public void startDocument() throws SAXException {
        croquetas = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        openTag = true;
        texto = "";
        if (qName.equals("croqueta")) {
            croqueta = new Croqueta();
            croqueta.setId(Integer.parseInt(attributes.getValue("id")));
            croquetas.add(croqueta);
        } else if (qName.equals("ingredientes")) {
            croqueta.setIngrediente(new ArrayList<>());
        } else if (qName.equals("ingrediente")) {
            ingrediente = new Ingrediente();
            croqueta.getIngrediente().add(ingrediente);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        openTag = false;
        if (qName.equals("nombre")) {
            croqueta.setNombre(texto);
        } else if (qName.equals("textura")) {
            croqueta.setTextura(texto);
        } else if (qName.equals("tamaño")) {
            croqueta.setTamaño(texto);
        } else if (qName.equals("tipo")) {
            ingrediente.setTipo(texto);
        } else if (qName.equals("cantidad")) {
            ingrediente.setCantidad(Integer.parseInt(texto));
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (openTag) {
            texto += new String(ch, start, length);
        }
    }
}
