package ApuntesExamen.ConcurrenciaCafeteria.SConConcurrencia;

public class Cafeteria {
    private static final Integer AFORO_MAXIMO = 50;  // Capacidad máxima de la cafetería
    private static Integer entradas = 0;  // Contador de las personas que han entrado
    private static Integer salidas = 0;   // Contador de las personas que han salido
    
    private Integer aforoActual;  // Variable que mantiene el número actual de personas dentro de la cafetería
    
    // Constructor de la clase Cafeteria
    public Cafeteria() {
        aforoActual = 0;  // Inicializa el aforo actual a 0 al crear la cafetería
    }
    
    // Método sincronizado que permite verificar si hay espacio y dejar entrar a una persona // HA CAMBIADO DESDE AQUI EN COMPARACION CON EL SIN CONCURRENCIA
    public synchronized boolean haySitioYEntraPersona() {
        // Verifica si hay espacio en la cafetería
        if (aforoActual < AFORO_MAXIMO) {
            aforoActual++;  // Incrementa el aforo actual, ya que entra una persona
            entradas++;     // Incrementa el contador de entradas
            // Imprime el estado actual de la cafetería
            System.out.println("Entra persona. Aforo actual = " + aforoActual);
            return true;  // La persona pudo entrar
        } else {
            return false;  // La cafetería está llena, no puede entrar
        }
    }
    //HASTA AQUI 
    
    // Método sincronizado que permite que una persona salga de la cafetería // Y AQUI A PUESTO SYNCHRONIZED
    public synchronized void salePersona() {
        aforoActual--;  // Decrementa el aforo actual, ya que una persona sale
        salidas++;      // Incrementa el contador de salidas
        // Imprime el estado actual de la cafetería
        System.out.println("Sale persona. Aforo actual = " + aforoActual);
        
        // Verifica que el número de entradas, salidas y el aforo actual son consistentes
        if(entradas - salidas - aforoActual != 0) {
            System.exit(0);  // Si hay una inconsistencia en los números, termina el programa
        }
    }
}

