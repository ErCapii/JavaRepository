package ceu.dam.ad.ejerciciosTema3.xml.ejercicio09.Test;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio06.modelo.Largometraje;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio09.Service.PeliculasSaxService;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        PeliculasSaxService servicio = new PeliculasSaxService();
        try {
            List<Largometraje> lista = servicio.leerPeliculas("C:/temporal/xmlPeliculas.xml");
            for (Largometraje pelicula : lista) {
                System.out.println(pelicula);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el fichero", e);
        }
    }

}
