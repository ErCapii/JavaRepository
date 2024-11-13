package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.Test;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.ServiceDom.Ejercicio12ServiceDom;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Catalogo;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

public class TestDom {

    public static void main(String[] args) throws XMLExportException {
        Ejercicio12ServiceDom servicio = new Ejercicio12ServiceDom();
        Catalogo catalogo = Catalogo.createRandomObject(10);
        servicio.exportXML(catalogo, "c:/temporal/catalogo.xml");
    }
}
