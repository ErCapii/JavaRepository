package ApuntesExamen.ConcurrenciaCafeteria.SSinConcurrencia;

public class Cafeteria {
    private static final Integer AFORO_MAXIMO = 50;  // Aforo máximo de la cafetería
    private static Integer entradas = 0;  // Contador estático de personas que han entrado
    private static Integer salidas = 0;   // Contador estático de personas que han salido
    
    private Integer aforoActual;  // Aforo actual en la cafetería, correspondiente al número de personas dentro

    // Constructor de la clase, inicializa el aforo actual a 0
    public Cafeteria() {
        aforoActual = 0;
    }

    // Método que verifica si hay espacio disponible en la cafetería
    public boolean haySitio() {
        return aforoActual < AFORO_MAXIMO;  // Si el aforo actual es menor que el máximo, hay sitio
    }

    // Método para cuando una persona entra a la cafetería
    public void entraPersona() {
        entradas++;      // Incrementa el contador de entradas
        aforoActual++;   // Incrementa el aforo actual
        System.out.println("Entra persona. Aforo actual = " + aforoActual);  // Muestra el estado del aforo
    }

    // Método para cuando una persona sale de la cafetería
    public void salePersona() {
        salidas++;       // Incrementa el contador de salidas
        aforoActual--;   // Decrementa el aforo actual
        System.out.println("Sale persona. Aforo actual = " + aforoActual);  // Muestra el estado del aforo

        // Verifica si la diferencia entre entradas, salidas y el aforo actual no es coherente
        if (entradas - salidas - aforoActual != 0) {
            System.exit(0);  // Si no es coherente, finaliza el programa
        }
    }
}

