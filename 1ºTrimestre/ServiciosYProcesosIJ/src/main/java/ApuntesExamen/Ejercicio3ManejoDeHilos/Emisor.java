package ApuntesExamen.Ejercicio3ManejoDeHilos;


//Clase que representa un emisor que imprime caracteres en la consola durante un tiempo específico
public class Emisor {
 private String nombre;  
 private char caracter;  
 private int segundos;   

 public Emisor(char caracter, int segundos) {
     this.caracter = caracter;
     this.segundos = segundos;
 }

 
 public Emisor(String nombre, char caracter, int segundos) {
     this.nombre = nombre;
     this.caracter = caracter;
     this.segundos = segundos;
 }


 public String getNombre() {
     return nombre;
 }

 // Método principal que gestiona la emisión de caracteres
 public void emite() {
     // Códigos ANSI para cambiar el color de la consola
     final String ANSI_RESET = "\u001B[0m";    // Resetea el color al predeterminado
     final String ANSI_GREEN = "\u001B[32m";   // Cambia el color a verde
     final String ANSI_RED = "\u001B[31m";     // Cambia el color a rojo

     // Cálculo del tiempo final basado en la duración configurada (en milisegundos)
     long tiempoFinal = System.currentTimeMillis() + segundos * 1000;
     long tiempoUltimaImpresion = System.currentTimeMillis();

     // Imprime el carácter inicial en color verde
     System.out.print(ANSI_GREEN + caracter + ANSI_RESET);

     // Bucle principal: se ejecuta mientras no se alcance el tiempo final
     while (System.currentTimeMillis() < tiempoFinal) {
         // Si el hilo actual ha sido interrumpido, se detiene
         if (Thread.currentThread().isInterrupted()) return;

         // Comprueba si han pasado 300 milisegundos desde la última impresión
         if (System.currentTimeMillis() - tiempoUltimaImpresion > 300) {
             System.out.print(caracter); // Imprime el carácter
             tiempoUltimaImpresion = System.currentTimeMillis(); // Actualiza el tiempo de la última impresión
         }
     }

     // Imprime el carácter final en color rojo
     System.out.print(ANSI_RED + caracter + ANSI_RESET);
 }
}

