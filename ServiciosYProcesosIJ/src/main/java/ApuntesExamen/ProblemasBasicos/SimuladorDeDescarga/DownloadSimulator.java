package ApuntesExamen.ProblemasBasicos.SimuladorDeDescarga;

public class DownloadSimulator {
    private String archivo;

    public DownloadSimulator(String archivo) {
        this.archivo = archivo;
    }

    public void simularDescarga() {
        int progreso = 0;

        // Simulación de la descarga
        while (progreso <= 100) {
            System.out.printf("Descarga de archivo \"%s\": %d%% completada%n", archivo, progreso);
            progreso += 10;
            try {
                Thread.sleep(200); // Pausa de 200 ms entre cada incremento
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

