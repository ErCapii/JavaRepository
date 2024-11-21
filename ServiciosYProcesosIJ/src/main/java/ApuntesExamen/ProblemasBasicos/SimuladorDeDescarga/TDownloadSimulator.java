package ApuntesExamen.ProblemasBasicos.SimuladorDeDescarga;

public class TDownloadSimulator extends Thread {
    private DownloadSimulator downloadSimulator;

    public TDownloadSimulator(String archivo) {
        this.downloadSimulator = new DownloadSimulator(archivo);
    }

    @Override
    public void run() {
        downloadSimulator.simularDescarga();
    }
}

