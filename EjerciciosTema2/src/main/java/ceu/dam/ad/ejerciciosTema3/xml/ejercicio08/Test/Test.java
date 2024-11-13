package ceu.dam.ad.ejerciciosTema3.xml.ejercicio08.Test;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio04.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio08.Service.LibroSaxService;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        LibroSaxService servicio = new LibroSaxService();

        try {
            List<Libro> lista = servicio.leerLibros("C:/temporal/xmlLibrosAbel.xml");
            for (Libro libro : lista) {
                System.out.println(libro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
