package BarraDePrograso;

public class ProgressBar {
    private int start;

        public ProgressBar(int start) {
            this.start = start;
        }

        public void avanzar() {
            while (start <= 100) {
                System.out.printf("%d%%\n", start);
                start= start + 10;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
