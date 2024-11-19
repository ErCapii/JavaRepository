package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.ServiceSax;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CatalogoSaxHandler extends DefaultHandler {

    private Boolean openTag;
    private String textoTag;
    private Catalogo catalogo;
    private List<Articulo> listaArticulos;
    private Articulo articulo;
    private Modelo modelo;
    private Categoria categoria;


    public Catalogo getCatalogo() {
        return catalogo;
    }

    @Override
    public void startDocument() throws SAXException {
        catalogo = new Catalogo();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        openTag = true;
        textoTag = "";
        switch (qName) {
            case "catálogo" -> {
                catalogo.setTamaño(Integer.parseInt(attributes.getValue("tamaño")));
            }

            case "articulos" -> {
                listaArticulos = new ArrayList<>();
                catalogo.setArticulos(listaArticulos);
            }
            case "articulo" -> {
                articulo = new Articulo();
                listaArticulos.add(articulo);
            }
            case "modelosDisponibles" -> articulo.setModelos(new ArrayList<Modelo>());
            case "modelo" -> {
                modelo = new Modelo();
                articulo.getModelos().add(modelo);
            }
            case "codigosBarra" -> modelo.setCodigosBarra(new ArrayList<>());
            case "categorias" -> articulo.setCategorias(new ArrayList<Categoria>());
            case "categoria" -> {
                categoria = new Categoria();
                articulo.getCategorias().add(categoria);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        openTag = false;
        switch (qName) {
            case "descripcion" -> articulo.setDescripcion(textoTag);
            case "identificador" -> articulo.setSku(textoTag);
            case "precio" -> {
                BigDecimal precio = new BigDecimal(textoTag);
                BigDecimal iva = precio.multiply(BigDecimal.valueOf(0.21).setScale(2, RoundingMode.HALF_UP));
                BigDecimal precioSinIva = precio.subtract(iva).setScale(2, RoundingMode.HALF_UP);
                articulo.setPvp(new Pvp());
                articulo.getPvp().setPrecio(precioSinIva);
                articulo.getPvp().setIva(iva);
            }
            case "talla" -> modelo.setTalla(textoTag);
            case "color" -> modelo.setColor(textoTag);
            case "codigo" -> modelo.getCodigosBarra().add(textoTag);
            case "categoria" -> categoria.setNombre(textoTag);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (openTag) {
            textoTag = new String(ch, start, length);
        }
    }
}
