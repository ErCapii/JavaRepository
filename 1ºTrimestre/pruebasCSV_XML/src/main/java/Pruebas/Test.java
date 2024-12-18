package Pruebas;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        croquetasSaxservice servicio = new croquetasSaxservice();

        try {
            List<Croqueta> lista = servicio.leerCroquetas("C:/temporal/croquetas.xml");
            for (Croqueta croqueta : lista) {
                System.out.println(croqueta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
