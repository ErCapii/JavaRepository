package ApuntesExamen.ProblemasBasicos.SimuladorDeDescarga;

public class RDownloadSimulator implements Runnable {
    private DownloadSimulator downloadSimulator;

    public RDownloadSimulator(String archivo) {
        this.downloadSimulator = new DownloadSimulator(archivo);
    }

    @Override
    public void run() {
        downloadSimulator.simularDescarga();
    }
}

