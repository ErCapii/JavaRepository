package ApuntesExamen.Ejercicio4TimerTimerTask;


//Clase que define un emisor con características básicas
public class DefinicionEmisor {
 private String nombre;  // Nombre del emisor (opcional)
 private char caracter;  // Carácter que emite el emisor
 private int pulsos;     // Número de pulsos asociados al emisor

 // Constructor que inicializa el emisor con un carácter y un número de pulsos
 public DefinicionEmisor(char caracter, int pulsos) {
     this.caracter = caracter;
     this.pulsos = pulsos;
 }

 // Constructor que inicializa el emisor con un nombre, un carácter y un número de pulsos
 public DefinicionEmisor(String nombre, char caracter, int pulsos) {
     this.nombre = nombre;
     this.caracter = caracter;
     this.pulsos = pulsos;
 }

 // Devuelve el nombre del emisor
 public String getNombre() {
     return nombre;
 }

 // Devuelve el número de pulsos configurados
 public int getPulsos() {
     return pulsos;
 }

 // Método que emite el carácter de manera unitaria
 public void emiteUnintariamente() {
     System.out.print(caracter); // Imprime el carácter configurado
 }
}

