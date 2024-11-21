package ApuntesExamen.Ejercicio6ComparticionInformacion;

public class Lector implements Runnable {
    // Atributo que hace referencia al contador compartido
    private ContadorCompartido contadorCompartido;

    // Constructor que recibe el objeto ContadorCompartido para leer su valor
    public Lector(ContadorCompartido contadorCompartido) {
        this.contadorCompartido = contadorCompartido;
    }

    // Método run que se ejecutará cuando se inicie el hilo
    @Override
    public void run() {
        // Bucle que se ejecuta 5 veces
        for (int i = 0; i < 5; i++) {
            // Llamada al método obtenerValor() del ContadorCompartido para obtener el valor actual
            int valor = contadorCompartido.obtenerValor();
            // Imprimir el valor del contador leído
            System.out.println(Thread.currentThread().getName() + " leyó el valor del contador: " + valor);
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

