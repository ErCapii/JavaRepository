package SimuladorCajero;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BancoApp {

	public static void main(String[] args) {
		CuentaBancaria cuenta = new CuentaBancaria(1000);
		Cliente cliente1 = new Cliente(cuenta,"a");
		Cliente cliente2 = new Cliente(cuenta,"b");
		Cliente cliente3 = new Cliente(cuenta,"c");
		
		ExecutorService execute = Executors.newFixedThreadPool(3);
		
		while(cuenta.getSaldo()>0) {
			execute.execute(cliente1);
			execute.execute(cliente2);
			execute.execute(cliente3);
		}
	}
}
