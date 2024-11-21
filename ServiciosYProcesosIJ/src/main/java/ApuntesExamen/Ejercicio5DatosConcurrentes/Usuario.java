package ApuntesExamen.Ejercicio5DatosConcurrentes;


//Clase que representa un usuario que intenta realizar una reserva de entradas
//Implementa la interfaz Runnable para poder ejecutarse en un hilo
public class Usuario implements Runnable {
 private SistemaReserva sistemaReserva;  // Referencia al sistema de reservas
 private String nombreUsuario;           // Nombre del usuario que realiza la reserva
 private String nombreEvento;            // Nombre del evento para el cual se desea hacer la reserva
 private int cantidadEntradas;           // Número de entradas que el usuario desea reservar

 // Constructor que inicializa el usuario con el sistema de reservas, nombre del usuario, evento y cantidad de entradas
 public Usuario(SistemaReserva sistemaReserva, String nombreUsuario, String nombreEvento, int cantidadEntradas) {
     this.sistemaReserva = sistemaReserva;  // Se asigna la referencia al sistema de reservas
     this.nombreUsuario = nombreUsuario;    // Se asigna el nombre del usuario
     this.nombreEvento = nombreEvento;      // Se asigna el nombre del evento
     this.cantidadEntradas = cantidadEntradas;  // Se asigna la cantidad de entradas que se desean reservar
 }

 // Método que se ejecutará en el hilo cuando se invoca
 @Override
 public void run() {
     // Se intenta realizar la reserva de entradas a través del sistema
     boolean exito = sistemaReserva.reservar(nombreEvento, cantidadEntradas);
     
     // Si la reserva fue exitosa, se imprime un mensaje confirmando la reserva
     if (exito) {
         System.out.println(nombreUsuario + " reservó " + cantidadEntradas + " entradas para el evento " + nombreEvento);
     } 
     // Si no fue exitosa, se imprime un mensaje indicando que no hay suficientes entradas disponibles
     else {
         System.out.println(nombreUsuario + " no pudo reservar " + cantidadEntradas + " entradas para el evento " + nombreEvento + " (No hay suficientes entradas disponibles).");
     }
 }
}
