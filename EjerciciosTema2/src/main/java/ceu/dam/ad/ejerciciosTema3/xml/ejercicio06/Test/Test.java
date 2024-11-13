package ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.Test;



import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.Service.Ejercicio6Service;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

import java.util.List;

public class Test {
    public static void main(String[] args) throws XMLExportException {
        Ejercicio6Service ejercicio6Service = new Ejercicio6Service();
        List<Largometraje> largometrajes = Largometraje.createRandomList(10);

        ejercicio6Service.exportarXML(largometrajes, "c:/temporal/largometrajes.xml");
    }
}
