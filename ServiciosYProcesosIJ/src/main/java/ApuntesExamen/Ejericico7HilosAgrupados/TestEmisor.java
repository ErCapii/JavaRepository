package ApuntesExamen.Ejericico7HilosAgrupados;


public class TestEmisor {
    public static void main(String[] args) {
        // Crear un grupo de hilos
        ThreadGroup grupoEmisores = new ThreadGroup("GrupoEmisores");

        // Crear emisores de caracteres, cada uno emite un carácter por 5 segundos
        Emisor emisorA = new Emisor('A', 5);  // Emitir 'A' por 5 segundos
        Emisor emisorB = new Emisor('B', 5);  // Emitir 'B' por 5 segundos
        Emisor emisorC = new Emisor('C', 5);  // Emitir 'C' por 5 segundos
        Emisor emisorD = new Emisor('D', 5);  // Emitir 'D' por 5 segundos

        // Crear hilos y asociarlos al grupo de hilos
        Thread hiloA = new Thread(grupoEmisores, emisorA, "Hilo-A");
        Thread hiloB = new Thread(grupoEmisores, emisorB, "Hilo-B");
        Thread hiloC = new Thread(grupoEmisores, emisorC, "Hilo-C");
        // Aquí corregimos el hiloD para que también esté en el grupo de hilos
        Thread hiloD = new Thread(grupoEmisores, emisorD, "Hilo-D");

        // Iniciar los hilos
        hiloA.start();
        hiloB.start();
        hiloC.start();
        hiloD.start();

        // Mostrar el número de hilos activos en el grupo
        System.out.println("Número de hilos activos en el grupo: " + grupoEmisores.activeCount());

        // Enumerar los hilos del grupo
        Thread[] hilos = new Thread[grupoEmisores.activeCount()];
        grupoEmisores.enumerate(hilos);  // Enumerar los hilos activos en el grupo

        System.out.println("Hilos en el grupo:");
        for (Thread hilo : hilos) {
            System.out.println("- " + hilo.getName());
        }

        // Interrumpir todos los hilos del grupo después de 2 segundos
        try {
            Thread.sleep(2000);  // Esperar 2 segundos antes de interrumpir los hilos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nInterrumpiendo todos los hilos del grupo...");
        grupoEmisores.interrupt();  // Interrumpir todos los hilos en el grupo

        // Esperar a que todos los hilos del grupo terminen
        try {
            hiloA.join();
            hiloB.join();
            hiloC.join();
            hiloD.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nTodos los hilos han terminado.");
    }
}

