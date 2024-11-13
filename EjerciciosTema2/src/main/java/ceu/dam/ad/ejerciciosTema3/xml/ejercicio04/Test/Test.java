package ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.Test;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.Ejercicio4Service.Ejercicio4ServiceXml;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

import java.util.List;

public class Test {


    public static void main(String[] args) throws XMLExportException {
        Ejercicio4ServiceXml ejercicio4Service = new Ejercicio4ServiceXml();
        List<Libro> libro = Libro.createRandomList(10);

        ejercicio4Service.exportXML(libro, "c:/temporal/libros.xml");
    }
}
