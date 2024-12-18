package ApuntesExamen.Ejercicio6ComparticionInformacion;

public class Test {
    public static void main(String[] args) {
        // Crear un objeto de ContadorCompartido, que es el recurso compartido entre los hilos
        ContadorCompartido contadorCompartido = new ContadorCompartido();

        // Crear un hilo de tipo Incrementador, pasando el contador compartido como parámetro
        Thread incrementador = new Thread(new Incrementador(contadorCompartido), "Incrementador");
        
        // Crear un hilo de tipo Lector, pasando el contador compartido como parámetro
        Thread lector = new Thread(new Lector(contadorCompartido), "Lector");

        // Iniciar ambos hilos para que comiencen a ejecutar el código en sus respectivos métodos run()
        incrementador.start();
        lector.start();

        // Esperar a que los hilos terminen su ejecución antes de continuar
        try {
            // El hilo principal espera a que terminen los hilos incrementador y lector
            incrementador.join(); // Espera hasta que el hilo incrementador termine
            lector.join(); // Espera hasta que el hilo lector termine
        } catch (InterruptedException e) {
            // Si se interrumpe algún hilo, se maneja la excepción e imprime el stack trace
            e.printStackTrace();
        }

        // Imprimir mensaje final cuando ambos hilos hayan terminado su ejecución
        System.out.println("Ejecución completada.");
    }
}

