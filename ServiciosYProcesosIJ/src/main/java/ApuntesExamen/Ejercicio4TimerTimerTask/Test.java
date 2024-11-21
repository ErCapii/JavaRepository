package ApuntesExamen.Ejercicio4TimerTimerTask;


import java.util.Timer;  // Importa la clase Timer para programar tareas

// Clase de prueba para verificar la emisión del carácter mediante TimerTask
public class Test {
    public static void main(String[] args) {
        // Crea un objeto de DefinicionEmisor que emite el carácter '*' 5 veces
        DefinicionEmisor de1 = new DefinicionEmisor('*', 5);

        // Crea una instancia de Timer, que se usará para programar tareas
        Timer t1 = new Timer();

        // Crea un objeto de EmisorTimerTask que se encargará de ejecutar la emisión de pulsos
        EmisorTimerTask tt1 = new EmisorTimerTask(de1);

        // Imprime un mensaje indicando que se iniciará la emisión
        System.out.print("Iniciando emisión ...");

        // Programa la tarea (tt1) para que se ejecute a intervalos regulares
        // El primer parámetro (0) significa que la tarea empieza inmediatamente
        // El segundo parámetro (500) es el intervalo en milisegundos entre ejecuciones
        t1.scheduleAtFixedRate(tt1, 0, 500);  
    }
}

