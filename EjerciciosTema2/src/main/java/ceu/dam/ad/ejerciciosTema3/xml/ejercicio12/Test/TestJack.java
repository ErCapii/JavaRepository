package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.Test;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.ServiceJackson.CatalogoJackService;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Catalogo;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.services.CatalogoXMLException;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class TestJack {
	public static void main(String[] args) throws CatalogoXMLException, XMLExportException {
		CatalogoJackService service = new CatalogoJackService();
		
		Catalogo catalogo = Catalogo.createRandomObject(5);
		service.exportXML(catalogo, "c:/temp/catalogoJack.xml");
	}

}
