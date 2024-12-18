package ceu.dam.ad.ejerciciosTema3.csv.ejercicio01;


import ceu.dam.ad.ejerciciosTema3.csv.exceptions.CsvException;
import ejercicios.ejercicio01.modelo.Pelicula;
import ejercicios.ejercicio01.services.PeliculasException;
import ejercicios.ejercicio01.services.PeliculasService;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class Ejercicio01ServiceImp implements Ejercicio01Service {
    @Override
    public void exportarPeliculasCsv(String nombreFichero) throws CsvException, PeliculasException, CsvPeliculasException {
        PeliculasService servicePeliculas = new PeliculasService();
        List<Pelicula> listaPeliculas = servicePeliculas.consultarPeliculas(100);
        escribirCsv(nombreFichero, listaPeliculas);
    }

    public void escribirCsv(String pathFile, List<Pelicula> lista) throws CsvPeliculasException {
        try {

            File fichero = new File(pathFile);
            FileWriter writer = new FileWriter(fichero);
            fichero.createNewFile();
            for (Pelicula peliculas : lista) {
                writer.write(peliculas.getId() + "|");
                writer.write(peliculas.getNombre() + "|");
                writer.write(peliculas.getLongitud() + "\n");

            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CsvPeliculasException();
        }
    }

}
