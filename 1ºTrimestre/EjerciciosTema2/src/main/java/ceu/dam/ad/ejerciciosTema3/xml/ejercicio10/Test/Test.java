package ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.Test;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.Service.Ejercicio10ServiceJack;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio10.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

import java.util.List;

public class Test {
    public static void main(String[] args) throws XMLExportException {
        Ejercicio10ServiceJack service = new Ejercicio10ServiceJack();

        Libro libro = new Libro();
        List<Libro> lista = libro.createRandomList(10);
        service.escribirXMLLibros("c:/temporal/libros10.xml", lista);
        service.leerXMLLibros("c:/temporal/libros10.xml");
    }


}
