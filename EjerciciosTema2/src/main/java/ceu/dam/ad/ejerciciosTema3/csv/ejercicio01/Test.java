package ceu.dam.ad.ejerciciosTema3.csv.ejercicio01;

import ceu.dam.ad.ejerciciosTema3.csv.exceptions.CsvException;
import ejercicios.ejercicio01.modelo.Pelicula;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Ejercicio01ServiceImp service = new Ejercicio01ServiceImp();
        List<Pelicula> ListaPeliculas = new ArrayList<>();
        try {
          service.exportarPeliculasCsv("c:\\Users\\adominguez5871\\Desktop\\Peliculas.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
