package SimuladorCajero;

import java.util.Random;

import lombok.Data;

@Data

public class Cliente implements Runnable {

	private CuentaBancaria cuentaBancaria;
	private String nombreCliente;
	Random random = new Random();
	public Cliente(CuentaBancaria cuentaBancaria, String nombreCliente) {
		this.cuentaBancaria = cuentaBancaria;
		this.nombreCliente = nombreCliente;
	}
	

	@Override
	public void run() {
	      Integer rm = random.nextInt(50,200);
	      cuentaBancaria.retirarDinero(rm, nombreCliente);
			
	}

	
	
}
