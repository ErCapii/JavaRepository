package ApuntesExamen.ConcurrenciaCoches.ConConcu;

public class Carrera {

    private Integer kmTotales;  
    private String[] podio;    
    private Integer personasEnPodio;  

    // Constructor que inicializa la carrera con el total de kilómetros y el tamaño del podio
    public Carrera(Integer kmTotales, int podioSize) {
        this.kmTotales = kmTotales;        
        podio = new String[podioSize];     
        personasEnPodio = 0;              
    }

    // Método que obtiene el total de kilómetros de la carrera
    public Integer getKmTotales() {
        return kmTotales;  
    }

    // Método que permite a un coche subir al podio
    public void subirAlPodio(String nombreCoche) {
        // Si aún hay espacio en el podio, sube al coche
        if(personasEnPodio < podio.length) {
            podio[personasEnPodio] = nombreCoche;  // Asigna el nombre del coche al siguiente lugar disponible en el podio
            personasEnPodio++;  // Incrementa el contador de coches en el podio
        }
    }

    // Método que imprime los coches que han subido al podio // EL UNICO CAMBIO ES EL synchronized 
    public synchronized  void imprimirPodio() {
        System.out.println("Podio de la carrera: ");
        // Itera sobre el array del podio e imprime el lugar y el nombre del coche correspondiente
        for (int i = 0; i < podio.length; i++) {
            System.out.printf("\tLugar %d -> %s%n", i + 1, podio[i]);  // Muestra el lugar y el nombre del coche en cada posición
        }
    }
}

