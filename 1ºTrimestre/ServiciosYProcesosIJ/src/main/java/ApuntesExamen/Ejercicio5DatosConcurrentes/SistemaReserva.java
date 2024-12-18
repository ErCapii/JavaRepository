package ApuntesExamen.Ejercicio5DatosConcurrentes;


import java.util.concurrent.ConcurrentHashMap;  // Importa ConcurrentHashMap para manejar concurrencia

// Clase que gestiona las reservas de entradas para eventos
public class SistemaReserva {
    // Mapa concurrente para manejar las entradas disponibles para cada evento
    private ConcurrentHashMap<String, Evento> eventos = new ConcurrentHashMap<>();

    // Método para agregar un evento al sistema con el nombre y el número de entradas disponibles
    public void agregarEvento(String nombre, int entradasDisponibles) {
        // Agrega un nuevo evento al mapa de eventos
        // El evento es identificado por su nombre y tiene un número de entradas disponibles
        eventos.put(nombre, new Evento(nombre, entradasDisponibles));
    }

    // Método para intentar reservar una cierta cantidad de entradas para un evento
    public boolean reservar(String nombreEvento, int cantidad) {
        // Obtiene el evento correspondiente al nombre proporcionado
        Evento evento = eventos.get(nombreEvento);
        
        // Si el evento existe, intenta reservar las entradas
        if (evento != null) {
            return evento.reservarEntradas(cantidad);
        }
        // Si el evento no existe, devuelve false indicando que no se pudo reservar
        return false;
    }

    // Método para obtener el número de entradas restantes para un evento
    public int entradasRestantes(String nombreEvento) {
        // Obtiene el evento correspondiente al nombre proporcionado
        Evento evento = eventos.get(nombreEvento);
        
        // Si el evento existe, devuelve el número de entradas disponibles
        // Si no, devuelve 0 (indicando que no hay entradas disponibles para ese evento)
        return evento != null ? evento.getEntradasDisponibles() : 0;
    }
}

