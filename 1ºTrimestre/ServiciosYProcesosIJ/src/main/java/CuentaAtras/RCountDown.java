package CuentaAtras;

public class RCountDown implements Runnable {
    private CountDown countDown;

    public RCountDown(int start) {
        this.countDown = new CountDown(start);
    }

    @Override
    public void run() {
        countDown.contar();
    }
}
