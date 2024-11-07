package Pruebas;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        CroquetaXMLService croquetaXMLService = new CroquetaXMLService();
        List<Croqueta> lista = List.of(
                new Croqueta(1, "Croqueta1", "Crujiente", "Pequeña", "Pollo"),
                new Croqueta(2, "Croqueta2", "Suave", "Grande", "Pollo"),
                new Croqueta(3, "Croqueta3", "Crujiente", "Pequeña", "Pollo"),
                new Croqueta(4, "Croqueta4", "Suave", "Grande", "Pollo"),
                new Croqueta(5, "Croqueta5", "Crujiente", "Pequeña", "Pollo"),
                new Croqueta(6, "Croqueta6", "Suave", "Grande", "Pollo")
        );
        croquetaXMLService.escribirXmlCroquetas(lista, "c:/temporal/croquetasDeLaAbuela.xml");
        lista = croquetaXMLService.leerXmlCroquetas("c:/temporal/croquetasDeLaAbuela.xml");
        lista.forEach(System.out::println);
    }
}
