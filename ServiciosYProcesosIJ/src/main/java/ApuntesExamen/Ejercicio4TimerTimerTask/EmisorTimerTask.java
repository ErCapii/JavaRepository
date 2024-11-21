package ApuntesExamen.Ejercicio4TimerTimerTask;

import java.util.TimerTask;

// Clase que extiende TimerTask para emitir caracteres en intervalos específicos
public class EmisorTimerTask extends TimerTask {
    private DefinicionEmisor definicionEmisor;  // El emisor asociado a esta tarea
    private int pulsos;  // Número de pulsos restantes

    // Constructor que inicializa la tarea con un emisor específico
    public EmisorTimerTask(DefinicionEmisor definicionEmisor) {
        this.definicionEmisor = definicionEmisor;  // Asocia el emisor a la tarea
        this.pulsos = definicionEmisor.getPulsos();  // Establece el número de pulsos a emitir
    }

    // Método que se ejecuta cuando la tarea es activada por el Timer
    @Override
    public void run() {
        // Si quedan pulsos por emitir, se emite un carácter
        if (pulsos > 0) {
            definicionEmisor.emiteUnintariamente();  // Emite un carácter
            pulsos--;  // Decrementa el contador de pulsos
        } else {
            cancel();  // Si no quedan pulsos, cancela la tarea (finaliza la emisión)
        }
    }
}

