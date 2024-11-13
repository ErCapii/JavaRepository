package ceu.dam.ad.ejerciciosTema3.xml.ejercicio11.Test;

import ceu.dam.ad.ejerciciosTema3.xml.ejercicio11.Service.Ejercicio11ServicioJack;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio11.modelo.Libro;
import ceu.dam.ad.ejerciciosTema3.xml.exceptions.XMLExportException;

import java.util.List;

public class Test {
    public static void main(String[] args) throws XMLExportException {
        Ejercicio11ServicioJack service = new Ejercicio11ServicioJack();

        Libro libro = new Libro();
        List<Libro> lista = libro.createRandomList(1);
        System.out.println("Lista de libros generada aleatoriamente:");
        lista.forEach(System.out::println);
        service.escribirJsonLibros("c:/temporal/librosJson.json", lista);
        service.escribirYamlLibros("c:/temporal/librosYaml.yaml", lista);

        lista = service.leerJsonLibros("c:/temporal/librosJson.json");
        System.out.println("Lista de libros leída del fichero JSON:");
        lista.forEach(System.out::println);
        lista = service.leerYamlLibros("c:/temporal/librosYaml.yaml");
        System.out.println("Lista de libros leída del fichero YAML:");
        lista.forEach(System.out::println);
    }
}
