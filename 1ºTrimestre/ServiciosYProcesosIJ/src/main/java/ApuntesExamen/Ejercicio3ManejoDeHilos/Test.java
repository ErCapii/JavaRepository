package ApuntesExamen.Ejercicio3ManejoDeHilos;


//Clase Test para probar la funcionalidad de LanzadorEmisiones y Emisor
public class Test {
 public static void main(String[] args) {
     // Crea un LanzadorEmisiones con un Emisor asociado
     LanzadorEmisiones l1 = new LanzadorEmisiones("L-1", new Emisor("E-1", '*', 5));
     
     // Imprime el estado del hilo antes de iniciarlo
     System.out.println("ANTES DE START");
     System.out.println(l1); // Llama al método toString de LanzadorEmisiones
     
     // Inicia el hilo (comienza la emisión del carácter)
     l1.start();
     
     // Imprime el estado del hilo inmediatamente después de iniciarlo
     System.out.println("DESPUÉS DE START");
     System.out.println(l1);

     // Cambia la prioridad del hilo a la máxima (10)
     l1.setPriority(10);
     
     // Pausa el hilo principal por 2 segundos para observar la ejecución del hilo lanzador
     try {
         Thread.sleep(2000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }

     // Imprime el estado del hilo mientras se encuentra en ejecución
     System.out.println("DURANTE EJECUCIÓN");
     System.out.println(l1);

     // Interrumpe el hilo lanzador
     l1.interrupt();

     // Imprime el estado del hilo tras ser interrumpido
     System.out.println("TRAS INTERRUPCIÓN");
     System.out.println(l1);

     // Espera a que el hilo finalice antes de continuar
     try {
         l1.join(); // join asegura que el hilo principal espere la finalización de l1
     } catch (InterruptedException e) {
         e.printStackTrace();
     }

     // Imprime el estado del hilo después de su ejecución completa
     System.out.println("TRAS EJECUCIÓN");
     System.out.println(l1);
 }
}
