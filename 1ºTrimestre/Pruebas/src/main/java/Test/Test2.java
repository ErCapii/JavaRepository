package Test;

import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        CsvService servicio = new CsvService();
        List<Gato> gato;
        try {
            gato = servicio.leerCsv("c:/Users/adominguez5871/Desktop/libro.csv");
            gato.forEach(System.out::println);

            //servicio.escribirCsv(gato, "c:/Users/adominguez5871/Desktop/SalidaCsv.csv");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
