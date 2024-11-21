package ApuntesExamen.ProblemasBasicos.CuentaAtras;

public class LCountDown {
    public void lanzarCuentaAtras(int start) {
        Runnable cuentaAtrasRunnable = new Runnable() {
            @Override
            public void run() {
                CountDown countDown = new CountDown(start);
                countDown.contar();
            }
        };
        Thread hilo = new Thread(cuentaAtrasRunnable);
        hilo.start();
    }
}
