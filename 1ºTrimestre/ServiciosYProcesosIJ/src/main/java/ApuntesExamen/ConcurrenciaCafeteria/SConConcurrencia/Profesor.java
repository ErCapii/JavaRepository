package ApuntesExamen.ConcurrenciaCafeteria.SConConcurrencia;

import java.util.Random;

public class Profesor implements Runnable {
    private Cafeteria cafeteria;  // Instancia de la cafetería asociada al profesor

    // Constructor que recibe la instancia de Cafeteria
    public Profesor(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;  // Inicializa el objeto cafetería
    }

    // Método que simula el comportamiento del profesor al consumir
    public void consumir() {
        Random random = new Random();  // Instancia para generar números aleatorios
        while (true) {  // Bucle infinito que simula la actividad continua del profesor
            try {
                // El profesor espera entre 1 y 3 segundos antes de intentar entrar // HA CAMBIADO DESDE AQUI EN COMPARACION CON EL SIN CONCURRENCIA
                Thread.sleep((random.nextInt(3) + 1) * 1_000);  // 1 - 3 segundos

                // Si hay espacio en la cafetería, el profesor entra
                if (cafeteria.haySitioYEntraPersona()) {
                    // Si entra, pasa un tiempo aleatorio entre 2 y 5 segundos en la cafetería
                    Thread.sleep((random.nextInt(4) + 2) * 1_000);  // 2 a 5 segundos
                    // El profesor sale después de un tiempo aleatorio
                    cafeteria.salePersona();  
                } else {
                    // Si no puede entrar porque la cafetería está llena
                    System.out.println("Profesor no ha podido entrar, cafetería llena.");
                }
                //HASTA AQUI
            } catch (InterruptedException e) {
                // Si el hilo es interrumpido, se maneja la excepción
                e.printStackTrace();
            }
        }
    }

    // Método que se ejecuta al iniciar el hilo
    @Override
    public void run() {
        consumir();  // Llama al método consumir para que el profesor intente entrar en la cafetería
    }
}

