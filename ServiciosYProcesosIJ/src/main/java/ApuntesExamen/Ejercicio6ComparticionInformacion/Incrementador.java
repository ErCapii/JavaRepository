package ApuntesExamen.Ejercicio6ComparticionInformacion;

public class Incrementador implements Runnable {
    // Atributo que hace referencia al contador compartido
    private ContadorCompartido contadorCompartido;

    // Constructor que recibe el objeto ContadorCompartido para poder incrementarlo
    public Incrementador(ContadorCompartido contadorCompartido) {
        this.contadorCompartido = contadorCompartido;
    }

    // Método run que se ejecutará cuando se inicie el hilo
    @Override
    public void run() {
        // Bucle que se ejecuta 5 veces
        for (int i = 0; i < 5; i++) {
            // Llamada al método incrementar() del ContadorCompartido
            contadorCompartido.incrementar();
            try {
                // Simula trabajo haciendo que el hilo duerma durante 500 milisegundos
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Si el hilo es interrumpido, se maneja la excepción y se interrumpe el hilo actual
                Thread.currentThread().interrupt();
            }
        }
    }
}

