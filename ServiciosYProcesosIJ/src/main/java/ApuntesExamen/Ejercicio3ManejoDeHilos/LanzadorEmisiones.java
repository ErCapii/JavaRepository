package ApuntesExamen.Ejercicio3ManejoDeHilos;


//Clase que extiende Thread para gestionar y describir la ejecución de un emisor
public class LanzadorEmisiones extends Thread {
 private String nombre;  
 private Emisor emisor;  

 
 public LanzadorEmisiones(String nombre, Emisor emisor) {
     this.nombre = nombre;
     this.emisor = emisor;
 }

 // Método toString: devuelve una descripción detallada del lanzador y su hilo
 @Override
 public String toString() {
     StringBuilder sb = new StringBuilder(); // Se utiliza StringBuilder para crear la descripción
     sb.append("Lanzador de emisiones:\n");
     sb.append("======================\n");
     sb.append("- Nombre: " + nombre + "\n");             // Nombre del lanzador
     sb.append("- Emisor: " + emisor.getNombre() + "\n"); // Nombre del emisor asociado
     sb.append("- Hilo:\n");
     sb.append("    - name: " + getName() + "\n");        // Nombre del hilo (Thread)
     sb.append("    - id: " + getId() + "\n");            // Identificador único del hilo
     sb.append("    - alive?: " + isAlive() + "\n");      // ¿El hilo está activo?
     sb.append("    - state: " + getState() + "\n");      // Estado actual del hilo (NEW, RUNNABLE, etc.)
     sb.append("    - prioridad: " + getPriority() + "\n"); // Prioridad del hilo
     sb.append("    - interrumpido?: " + isInterrupted() + "\n"); // ¿El hilo ha sido interrumpido?
     sb.append("    - threadGroup: " + getThreadGroup() + "\n");  // Grupo de hilos al que pertenece
     return sb.toString();
 }

 // Método run: lógica que se ejecuta cuando el hilo se inicia
 @Override
 public void run() {
     emisor.emite(); // Llama al método emite del emisor asociado
 }
}

