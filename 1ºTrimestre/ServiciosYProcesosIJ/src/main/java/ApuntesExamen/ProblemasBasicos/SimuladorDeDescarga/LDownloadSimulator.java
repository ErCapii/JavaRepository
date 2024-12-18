package ApuntesExamen.ProblemasBasicos.SimuladorDeDescarga;

public class LDownloadSimulator {
    public void lanzarDescarga(String archivo) {
        Runnable descargaRunnable = new Runnable() {
            @Override
            public void run() {
                DownloadSimulator downloadSimulator = new DownloadSimulator(archivo);
                downloadSimulator.simularDescarga();
            }
        };
        Thread hilo = new Thread(descargaRunnable);
        hilo.start();
    }
}

