package ApuntesExamen.Ejericico7HilosAgrupados;


public class Emisor implements Runnable{
    private String nombre;     // Nombre del emisor (opcional)
    private char caracter;     // El carácter a emitir
    private int segundos;      // La cantidad de segundos durante los cuales se emite el carácter

    // Constructor que recibe los parámetros para el carácter, la duración en segundos y el nombre
    public Emisor(char caracter, int segundos, String nombre) {
        this.caracter = caracter;
        this.segundos = segundos;
        this.nombre = nombre;
    }

    // Constructor que recibe solo el carácter y la duración en segundos
    public Emisor(char caracter, int segundos) {
        this.caracter = caracter;
        this.segundos = segundos;
    }

    // Método para obtener el nombre del emisor
    public String getNombre() {
        return nombre;
    }

    // Método que realiza la emisión del carácter
    public void emite() {
        // Definición de los códigos de colores ANSI para modificar el color de la salida en consola
        final String ANSI_RESET = "\u001B[0m";    // Resetea el color
        final String ANSI_GREEN = "\u001B[32m";   // Color verde para indicar que comienza la emisión
        final String ANSI_RED = "\u001B[31m";     // Color rojo para indicar que termina la emisión
        
        // Calcula el tiempo final cuando debe dejar de emitir
        long tiempoFinal = System.currentTimeMillis() + (segundos * 1000);  // Tiempo de finalización
        long tiempoUltimaImpresion = System.currentTimeMillis();  // Marca de tiempo de la última impresión
        
        // Emite el primer carácter en color verde
        System.out.printf(ANSI_GREEN + "%c" + ANSI_RESET, caracter);  // Empezando a emitir
        
        // Bucle que mantiene el hilo activo durante el tiempo indicado
        while (System.currentTimeMillis() < tiempoFinal) {
            long tiempoActual = System.currentTimeMillis();  // Obtiene el tiempo actual
            if(Thread.currentThread().isInterrupted()) {
                return;  // Si el hilo ha sido interrumpido, termina la emisión
            }
            // Si han pasado 300 milisegundos desde la última impresión
            if (tiempoActual - tiempoUltimaImpresion >= 300) {
                // Emite el carácter
                System.out.print(caracter);  
                tiempoUltimaImpresion = tiempoActual;  // Actualiza el tiempo de la última impresión
            }
            // La CPU sigue trabajando aquí realizando iteraciones hasta que pasen los 300 ms.
        }
        
        // Una vez transcurrido el tiempo, emite el último carácter en color rojo
        System.out.printf(ANSI_RED + "%c" + ANSI_RESET, caracter);  // Terminando de transmitir
    }

    // Método que se ejecuta cuando el hilo es iniciado
    @Override
    public void run() {
        emite();  // Llama al método que emite el carácter
    }
}

