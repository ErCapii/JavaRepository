package ApuntesExamen.Ejercicio5DatosConcurrentes;


public class Test {
    public static void main(String[] args) {
        // Crear una instancia del sistema de reserva de entradas
        SistemaReserva sistemaReserva = new SistemaReserva();

        // Agregar eventos al sistema con un número inicial de entradas
        sistemaReserva.agregarEvento("Concierto Rock", 10);  // Evento "Concierto Rock" con 10 entradas disponibles
        sistemaReserva.agregarEvento("Concierto Jazz", 5);   // Evento "Concierto Jazz" con 5 entradas disponibles

        // Crear hilos de usuarios que intentarán reservar entradas
        Thread usuario1 = new Thread(new Usuario(sistemaReserva, "Usuario1", "Concierto Rock", 4));  // Usuario1 reserva 4 entradas para "Concierto Rock"
        Thread usuario2 = new Thread(new Usuario(sistemaReserva, "Usuario2", "Concierto Rock", 6));  // Usuario2 reserva 6 entradas para "Concierto Rock"
        Thread usuario3 = new Thread(new Usuario(sistemaReserva, "Usuario3", "Concierto Rock", 3));  // Usuario3 reserva 3 entradas para "Concierto Rock"
        Thread usuario4 = new Thread(new Usuario(sistemaReserva, "Usuario4", "Concierto Jazz", 2));   // Usuario4 reserva 2 entradas para "Concierto Jazz"
        Thread usuario5 = new Thread(new Usuario(sistemaReserva, "Usuario5", "Concierto Jazz", 4));   // Usuario5 reserva 4 entradas para "Concierto Jazz"

        // Iniciar los hilos, es decir, los usuarios comienzan a intentar realizar las reservas
        usuario1.start();
        usuario2.start();
        usuario3.start();
        usuario4.start();
        usuario5.start();

        // Esperar a que todos los hilos terminen antes de continuar (sin esto el programa podría finalizar antes)
        try {
            usuario1.join();
            usuario2.join();
            usuario3.join();
            usuario4.join();
            usuario5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();  // En caso de que se interrumpa alguno de los hilos, se imprime el error
        }

        // Después de que todos los hilos han terminado, se muestran las entradas restantes
        System.out.println("Entradas restantes para Concierto Rock: " + sistemaReserva.entradasRestantes("Concierto Rock"));
        System.out.println("Entradas restantes para Concierto Jazz: " + sistemaReserva.entradasRestantes("Concierto Jazz"));
    }
}
