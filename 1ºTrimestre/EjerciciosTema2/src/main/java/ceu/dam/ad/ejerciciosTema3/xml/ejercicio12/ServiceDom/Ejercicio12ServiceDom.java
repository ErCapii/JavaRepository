package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.ServiceDom;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Articulo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Catalogo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Categoria;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Modelo;
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
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xml = builder.newDocument();

			Element catalogoTag = xml.createElement("catalogo");
			catalogoTag.setAttribute("tamaño", String.valueOf(catalogo.getArticulos().size()));
			xml.appendChild(catalogoTag);

			Element articulosTag = xml.createElement("articulos");
			catalogoTag.appendChild(articulosTag);

			catalogo.getArticulos().forEach(articulo -> {
				Element articuloTag = xml.createElement("articulo");
				articulosTag.appendChild(articuloTag);

				Element descripcionTag = xml.createElement("descripcion");
				descripcionTag.setTextContent(articulo.getDescripcion());
				articuloTag.appendChild(descripcionTag);

				Element identificadorTag = xml.createElement("identificador");
				identificadorTag.setTextContent(articulo.getSku());
				articuloTag.appendChild(identificadorTag);

				Element precioTag = xml.createElement("precio");
				precioTag.setTextContent(articulo.getPvp().getPrecio().toString());
				articuloTag.appendChild(precioTag);

				Element modelosTag = xml.createElement("modelosDisponibles");
				articuloTag.appendChild(modelosTag);

				articulo.getModelos().forEach(modelo -> {
					Element modeloTag = xml.createElement("modelo");
					modelosTag.appendChild(modeloTag);

					Element tallaTag = xml.createElement("talla");
					tallaTag.setTextContent(modelo.getTalla());
					modeloTag.appendChild(tallaTag);

					Element colorTag = xml.createElement("color");
					colorTag.setTextContent(modelo.getColor());
					modeloTag.appendChild(colorTag);

					Element codigosBarraTag = xml.createElement("codigosDeBarra");
					modeloTag.appendChild(codigosBarraTag);

					modelo.getCodigosBarra().forEach(codigo -> {
						Element codigoTag = xml.createElement("codigo");
						codigoTag.setTextContent(codigo);
						codigosBarraTag.appendChild(codigoTag);
					});
				});
				Element categoriasTag = xml.createElement("categorias");
				articuloTag.appendChild(categoriasTag);

				articulo.getCategorias().forEach(categoria -> {
					Element categoriaTag = xml.createElement("categoria");
					categoriaTag.setTextContent(categoria.getNombre());
					categoriasTag.appendChild(categoriaTag);
				});

			});

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(xml);
			StreamResult result = new StreamResult(pathFile);
			transformer.transform(source, result);

		} catch (Exception e) {
			throw new XMLExportException(e);
		}
	}

	@Override
	public Catalogo importXML(String pathFile) throws CatalogoXMLException {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xml = builder.parse(pathFile);

			Element catalogoTag = xml.getDocumentElement();
			Catalogo catalogo = new Catalogo();
			Element articulosTag = (Element) catalogoTag.getElementsByTagName("articulos").item(0);
			catalogo.setTamaño(Integer.parseInt(catalogoTag.getAttribute("tamaño")));
			NodeList articulosList = articulosTag.getElementsByTagName("articulo");
			List<Articulo> articulos = new ArrayList<>();

			for (int i = 0; i < articulosList.getLength(); i++) {
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

				NodeList modelosDisponinblesList = articulosTag.getElementsByTagName("modeloDisponibles");
				List<Modelo> modelos = new ArrayList<>();
				
				articulos.add(articulo);
				
				for (int j = 0; j < modelosDisponinblesList.getLength(); j++) {

					Modelo modelo = new Modelo();
					Element modeloTag = (Element) modelosDisponinblesList.item(j);
					Element tallaTag = (Element) modeloTag.getElementsByTagName("talla").item(0);
					modelo.setTalla(tallaTag.getTextContent());
					Element colorTag = (Element) modeloTag.getElementsByTagName("colo").item(0);
					modelo.setColor(colorTag.getTextContent());
					modelos.add(modelo);
					
					NodeList codigosBarrasList = modeloTag.getElementsByTagName("codigosBarra");
					List<String> codigoBarras = new ArrayList();

					for (int k = 0; k < codigosBarrasList.getLength(); k++) {
						Element codigoBarraTag = (Element) codigosBarrasList.item(k);
						codigoBarras.add(codigoBarraTag.getTextContent());
						
					}
					modelo.setCodigosBarra(codigoBarras);
				}
				articulo.setModelos(modelos);
				NodeList categoriasList = articulosTag.getElementsByTagName("categorias");
				List<Categoria> categorias = new ArrayList<>();
				for (int j = 0; j < categoriasList.getLength(); j++) {
					Categoria categoria = new Categoria();
					Element categoriasTag = (Element) categoriasList.item(j);
					categoria.setNombre(categoriasTag.getTextContent());
					categorias.add(categoria);
				}
				articulo.setCategorias(categorias);
				

			}
			
			catalogo.setArticulos(articulos);
			return catalogo;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
