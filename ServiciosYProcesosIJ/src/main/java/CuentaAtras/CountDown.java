package CuentaAtras;

public class CountDown {
    private int start;

    public CountDown(int start) {
        this.start = start;
    }

    public void contar() {
        while (start >= 0) {
            System.out.printf("%d", start);
            start--;
            try {
                Thread.sleep(500); // Pausa de 500 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
