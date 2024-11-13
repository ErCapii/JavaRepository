package ceu.dam.ad.ejerciciosTema3.xml.ejercicio07.Test;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio07.ServiceLeer.Ejercicio07ServiceLeer;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

import java.util.List;

public class Test {
    public static void main(String[] args) throws XMLImportException {
        Ejercicio07ServiceLeer ejercicio07Service = new Ejercicio07ServiceLeer();
        List<Largometraje> lista = ejercicio07Service.importarXML("c:/temporal/largometrajes.xml");
        lista.forEach(System.out::println);
    }
}
