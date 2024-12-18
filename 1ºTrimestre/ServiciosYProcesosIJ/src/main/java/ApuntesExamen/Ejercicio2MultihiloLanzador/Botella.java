package ApuntesExamen.Ejercicio2MultihiloLanzador;


//Clase que representa una botella que puede vaciarse de forma controlada
public class Botella {

 private String nombre;
 private char caracter;
 private int cantidad;
 private static long milis = 300; // Tiempo de espera entre cada decremento de contenido

 // Constructor: configura la botella con los valores iniciales
 public Botella(String nombre, char caracter, int cantidad) {
     this.nombre = nombre;
     this.caracter = caracter;
     this.cantidad = cantidad;
 }

 // Método que vacía el contenido de la botella, imprimiendo un carácter por cada decremento
 public void vaciar() {
     // Bucle que continúa mientras quede contenido en la botella
     while (cantidad > 0) {
         System.out.print(caracter); 
         cantidad--;                 

         // Pausa entre cada reducción de cantidad
         try {
             Thread.sleep(milis); // Espera un tiempo definido por 'milis'
         } catch (InterruptedException e) {
             e.printStackTrace(); 
         }
     }
 } 	
}

