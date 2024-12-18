package ApuntesExamen.ConcurrenciaCafeteria.SConConcurrencia;

import ApuntesExamen.ConcurrenciaCafeteria.SSinConcurrencia.Alumno;
import ApuntesExamen.ConcurrenciaCafeteria.SSinConcurrencia.Cafeteria;
import ApuntesExamen.ConcurrenciaCafeteria.SSinConcurrencia.Profesor;

public class Run {
    public static void main(String[] args) {
        
        // Crea una nueva instancia de la cafetería
        Cafeteria cafeteria = new Cafeteria();
        
        // Inicia 100 hilos para los alumnos
        // Cada hilo representa a un alumno que intentará entrar a la cafetería
        for (int i = 0; i < 100; i++) {
            new Thread(new Alumno(cafeteria)).start();  // Crea y arranca un hilo de Alumno
        }
        
        // Inicia 20 hilos para los profesores
        // Cada hilo representa a un profesor que intentará entrar a la cafetería
        for (int i = 0; i < 20; i++) {
            new Thread(new Profesor(cafeteria)).start();  // Crea y arranca un hilo de Profesor
        }
    }
}
