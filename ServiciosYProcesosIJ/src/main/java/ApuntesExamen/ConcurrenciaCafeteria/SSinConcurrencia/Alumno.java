package ApuntesExamen.ConcurrenciaCafeteria.SSinConcurrencia;

import java.util.Random;

public class Alumno implements Runnable {
    private Cafeteria cafeteria;  // Referencia a la cafetería compartida
    
    // Constructor que recibe una instancia de Cafeteria
    public Alumno(Cafeteria cafeteria) {
        Random random = new Random();  // Se crea un objeto Random (no se usa en este constructor)
        this.cafeteria = cafeteria;  // Asigna la cafetería a la variable de instancia
    }
    
    // Método que simula el consumo del alumno en la cafetería
    public void consumir() {
        Random random = new Random();  // Crea una nueva instancia de Random para generar números aleatorios
        while(true) {
            try {
                // Simula un tiempo aleatorio (0 a 4 segundos) antes de intentar entrar a la cafetería
                Thread.sleep(random.nextInt(5) * 1_000); // 0 - 4 segundos
                // Verifica si hay lugar disponible en la cafetería
                if(cafeteria.haySitio()) {
                    cafeteria.entraPersona();  // Si hay sitio, el alumno entra
                    // Simula el tiempo que pasa en la cafetería (0 a 7 segundos)
                    Thread.sleep(random.nextInt(8) * 1_000);  // 0 a 7 segundos
                    cafeteria.salePersona();  // Después de un tiempo, el alumno sale
                } else {
                    // Si la cafetería está llena, muestra un mensaje
                    System.out.println("Alumno no ha podido entrar, cafetería llena.");
                }
            } catch (InterruptedException e) {
                // Maneja cualquier interrupción durante el proceso
                e.printStackTrace();
            }
        }
    }

    // Método que se ejecuta cuando se inicia el hilo del alumno
    @Override
    public void run() {
        consumir();  // Llama al método que simula el consumo
    }
}

