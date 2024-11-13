package ceu.dam.ad.ejerciciosTema3.xml.ejercicio05.Test;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio05.Service.Ejercicio05ServiceLeer;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLImportException;

import java.util.List;

public class Test {

    public static void main(String[] args) throws XMLImportException {
        Ejercicio05ServiceLeer ejercicio05Service = new Ejercicio05ServiceLeer();
        List<Libro> lista = ejercicio05Service.importXML("c:/temporal/libros.xml");
        lista.forEach(System.out::println);
    }


}
