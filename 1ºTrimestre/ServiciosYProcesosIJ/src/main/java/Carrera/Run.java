package Carrera;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Run {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(1000);
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 1; i <= 1000; i++) {
            Coche coche = new Coche("C-" + i, 100, carrera);
            executorService.execute(coche);
        }
       executorService.close();
        carrera.imprimirPodio();




    }
}