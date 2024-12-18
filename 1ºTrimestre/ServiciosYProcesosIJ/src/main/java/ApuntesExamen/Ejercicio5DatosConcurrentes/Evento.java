package ApuntesExamen.Ejercicio5DatosConcurrentes;


//Clase que representa un evento con entradas disponibles
public class Evento {
 private String nombre;  // Nombre del evento
 private int entradasDisponibles;  // Cantidad de entradas disponibles para el evento

 // Constructor que inicializa el evento con su nombre y la cantidad de entradas disponibles
 public Evento(String nombre, int entradasDisponibles) {
     this.nombre = nombre;  // Se asigna el nombre del evento
     this.entradasDisponibles = entradasDisponibles;  // Se asigna la cantidad de entradas disponibles
 }

 // Método para obtener el nombre del evento
 public String getNombre() {
     return nombre;
 }

 // Método para obtener la cantidad de entradas disponibles para el evento
 public int getEntradasDisponibles() {
     return entradasDisponibles;
 }

 // Método para reservar entradas para el evento
 // Este método es sincronizado para evitar problemas de concurrencia
 public synchronized boolean reservarEntradas(int cantidad) {
     // Si la cantidad solicitada es menor o igual que las entradas disponibles
     if (cantidad <= entradasDisponibles) {
         // Se reduce la cantidad de entradas disponibles
         entradasDisponibles -= cantidad;
         // La reserva fue exitosa, se devuelve true
         return true;
     }
     // Si no hay suficientes entradas disponibles, la reserva falla
     return false;
 }
}

