package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.ServiceSax;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Articulo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Catalogo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Categoria;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Modelo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Pvp;

public class CatalogoSaxHandler extends DefaultHandler {

	private Boolean openTag;
	private String textoTag;
	private Catalogo catalogo;
	private Articulo articulo;
	private Modelo modelo;


	public Catalogo getCatalogo() {
		return catalogo;
	}

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		openTag = true;
		textoTag = "";
		switch (qName) {
		case "catalogo" -> {
			catalogo = new Catalogo();
			catalogo.setTamaño(Integer.parseInt(attributes.getValue("tamaño")));
			catalogo.setArticulos(new ArrayList<Articulo>());
		}
		case "articulo" -> {
			articulo = new Articulo();
			articulo.setCategorias(new ArrayList<Categoria>());
			articulo.setModelos(new ArrayList<Modelo>());
			catalogo.getArticulos().add(articulo);
		}
		case "modelo" -> {
			modelo = new Modelo();
			modelo.setCodigosBarra(new ArrayList<String>());
			articulo.getModelos().add(modelo);
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
		case "categoria" ->{
			Categoria categoria = new Categoria();
			categoria.setNombre(textoTag);
			articulo.getCategorias().add(categoria);
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
