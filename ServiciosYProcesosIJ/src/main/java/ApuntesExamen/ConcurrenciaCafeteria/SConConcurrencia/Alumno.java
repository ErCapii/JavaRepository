package ApuntesExamen.ConcurrenciaCafeteria.SConConcurrencia;

import java.util.Random;

public class Alumno implements Runnable {
    private Cafeteria cafeteria;  // Instancia de la cafetería asociada al alumno

    // Constructor que recibe la instancia de Cafeteria
    public Alumno(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;  // Inicializa el objeto cafetería
    }

    // Método que simula el comportamiento del alumno al consumir
    public void consumir() {
        Random random = new Random();  // Instancia para generar números aleatorios
        while (true) {  // Bucle infinito que simula la actividad continua del alumno
            try {
                // El alumno espera entre 0 y 4 segundos antes de intentar entrar // HA CAMBIADO DESDE AQUI EN COMPARACION CON EL SIN CONCURRENCIA
                Thread.sleep(random.nextInt(5) * 1_000);  // 0 - 4 segundos

                // Si hay espacio en la cafetería, el alumno entra
                if (cafeteria.haySitioYEntraPersona()) {
                    // Si entra, pasa un tiempo aleatorio entre 0 y 7 segundos en la cafetería
                    Thread.sleep(random.nextInt(8) * 1_000);  // 0 a 7 segundos
                    // El alumno sale después de un tiempo aleatorio
                    cafeteria.salePersona();  
                } else {
                    // Si no puede entrar porque la cafetería está llena
                    System.out.println("Alumno no ha podido entrar, cafetería llena.");
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
        consumir();  // Llama al método consumir para que el alumno intente entrar en la cafetería
    }
}

