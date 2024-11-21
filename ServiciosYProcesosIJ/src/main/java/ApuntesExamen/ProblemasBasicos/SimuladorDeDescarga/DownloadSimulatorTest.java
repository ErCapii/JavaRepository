package ApuntesExamen.ProblemasBasicos.SimuladorDeDescarga;

public class DownloadSimulatorTest {
    public static void main(String[] args) {
        // Iniciar descarga con TDownloadSimulator (Hereda Thread)
        TDownloadSimulator tDescarga1 = new TDownloadSimulator("video.mp4");
        tDescarga1.start();

        // Iniciar descarga con RDownloadSimulator (Implementa Runnable)
        Thread rDescarga1 = new Thread(new RDownloadSimulator("musica.mp3"));
        rDescarga1.start();

        // Iniciar descarga con LDownloadSimulator (Clase lanzadora)
        LDownloadSimulator lDescarga = new LDownloadSimulator();
        lDescarga.lanzarDescarga("documento.pdf");
    }
}

