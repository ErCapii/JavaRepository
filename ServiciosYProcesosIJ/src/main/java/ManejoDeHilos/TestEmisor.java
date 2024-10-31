package ManejoDeHilos;

public class TestEmisor {

    public static void main(String[] args) {
        ThreadGroup grupo = new ThreadGroup("Grupo de Emisores");
        Emisor emisor1 = new Emisor('A', 1);
        Emisor emisor2 = new Emisor('B', 2);
        Emisor emisor3 = new Emisor('C', 3);
        Emisor emisor4 = new Emisor('D', 4);
        Thread hilo1 = new Thread(grupo, emisor1);
        Thread hilo2 = new Thread(grupo, emisor2);
        Thread hilo3 = new Thread(grupo, emisor3);
        Thread hilo4 = new Thread(grupo, emisor4);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        grupo.enumerate(new Thread[grupo.activeCount()]);
        grupo.interrupt();
        System.out.println("Hilos activos: " + grupo.activeCount());

    }
}
