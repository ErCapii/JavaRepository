package ExecutorServiceFixedPoolCorregido;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lanzabolas implements Runnable {
    private String nombre;

    // Constructor para asignar el nombre
    public Lanzabolas(String nombre) {
        this.nombre = nombre;
    }

    // Método run que se ejecutará cuando el hilo se inicie
    @Override
    public void run() {
        // Obtener la hora actual
        LocalDateTime ahora = LocalDateTime.now();
        // Formatear la hora para mostrar horas, minutos, segundos y milisegundos
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

        // Imprimir el mensaje con la hora formateada
        System.out.printf("Lanzando bola desde %s a las %s\n", nombre, ahora.format(formatter));
    }
}
