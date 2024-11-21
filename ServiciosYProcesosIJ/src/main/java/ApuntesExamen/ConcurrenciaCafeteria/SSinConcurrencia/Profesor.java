package ApuntesExamen.ConcurrenciaCafeteria.SSinConcurrencia;

import java.util.Random;

public class Profesor implements Runnable {
    private Cafeteria cafeteria;  // Referencia a la cafetería compartida
    
    // Constructor que recibe una instancia de Cafeteria
    public Profesor(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;  // Asigna la cafetería a la variable de instancia
    }
    
    // Método que simula el consumo del profesor en la cafetería
    public void consumir() {
        Random random = new Random();  // Crea una nueva instancia de Random para generar números aleatorios
        while(true) {
            try {
                // Simula un tiempo aleatorio (1 a 3 segundos) antes de intentar entrar a la cafetería
                Thread.sleep((random.nextInt(3) + 1) * 1_000); // 1 - 3 segundos
                // Verifica si hay lugar disponible en la cafetería
                if(cafeteria.haySitio()) {
                    cafeteria.entraPersona();  // Si hay sitio, el profesor entra
                    // Simula el tiempo que pasa en la cafetería (2 a 5 segundos)
                    Thread.sleep((random.nextInt(4) + 2) * 1_000);  // 2 a 5 segundos
                    cafeteria.salePersona();  // Después de un tiempo, el profesor sale
                } else {
                    // Si la cafetería está llena, muestra un mensaje
                    System.out.println("Profesor no ha podido entrar, cafetería llena.");
                }
            } catch (InterruptedException e) {
                // Maneja cualquier interrupción durante el proceso
                e.printStackTrace();
            }
        }
    }

    // Método que se ejecuta cuando se inicia el hilo del profesor
    @Override
    public void run() {
        consumir();  // Llama al método que simula el consumo
    }
}

