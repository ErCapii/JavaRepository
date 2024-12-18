package ApuntesExamen.Ejercicio6ComparticionInformacion;


public class ContadorCompartido {
    // Variable que mantiene el valor del contador
    private int contador = 0;

    // Método sincronizado para incrementar el contador
    public synchronized void incrementar() {
        // Incrementa el valor del contador
        contador++;
        // Muestra el valor actualizado del contador con el nombre del hilo que lo incrementó
        System.out.println(Thread.currentThread().getName() + " incrementó el contador a: " + contador);
    }

    // Método sincronizado para obtener el valor actual del contador
    public synchronized int obtenerValor() {
        // Devuelve el valor del contador
        return contador;
    }
}

