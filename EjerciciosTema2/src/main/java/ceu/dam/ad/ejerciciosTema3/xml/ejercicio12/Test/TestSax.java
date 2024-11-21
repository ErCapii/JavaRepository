package ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.Test;


import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.ServiceSax.CatalogoSaxService;
import ceu.dam.ad.ejerciciosTema3.xml.ejercicio12.modelo.Catalogo;

public class TestSax {
    public static void main(String[] args) {
        CatalogoSaxService servicio = new CatalogoSaxService();
        try {
            Catalogo catalogo = servicio.importXML("C:/temp/catalogo.xml");
            catalogo.getArticulos().forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el fichero", e);
        }
    }
}
