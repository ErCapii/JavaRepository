package CuentaAtras;

public class TCountDown extends Thread {
    private CountDown countDown;

    public TCountDown(int start) {
        this.countDown = new CountDown(start);
    }

    @Override
    public void run() {
        countDown.contar();
    }
}
