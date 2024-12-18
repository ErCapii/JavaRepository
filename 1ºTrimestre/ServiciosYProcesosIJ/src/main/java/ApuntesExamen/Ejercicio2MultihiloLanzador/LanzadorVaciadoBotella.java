package ApuntesExamen.Ejercicio2MultihiloLanzador;


import java.util.Arrays; 

// Clase que extiende Thread para gestionar el vaciado de botellas en hilos separados
public class LanzadorVaciadoBotella extends Thread {
    private Botella botella; 

    // Constructor: inicializa el hilo con una botella específica
    public LanzadorVaciadoBotella(Botella botella) {
        this.botella = botella;
    }
    
    // Método run: lógica que se ejecuta cuando el hilo se inicia
    @Override
    public void run() {
        botella.vaciar(); // Llama al método vaciar de la botella asociada
    }
    
    // Método main: punto de entrada al programa
    public static void main(String[] args) {
        
        Botella b1 = new Botella("B-1", '*', 10);
        // Crea un hilo para vaciar la botella y lo inicia
        LanzadorVaciadoBotella lanzador1 = new LanzadorVaciadoBotella(b1);
        lanzador1.start();

        
        Botella b2 = new Botella("B-2", '-', 6);
        // Inicia directamente un hilo para vaciar la segunda botella
        new LanzadorVaciadoBotella(b2).start();
    }
}

