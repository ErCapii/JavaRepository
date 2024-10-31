package SimuladorCajero;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class CuentaBancaria {

	private Integer saldo;
	private List<String> registroTrasacciones;

	public CuentaBancaria(Integer saldo) {
		this.saldo = saldo;
		registroTrasacciones= new ArrayList<String>();
	}

	public synchronized Boolean retirarDinero(Integer cantidad, String nombreCliente) {
		if(saldo-cantidad <= 0) {
			return false;
		}else
			saldo= saldo-cantidad;
			registrarTransaccion(nombreCliente+": "+cantidad+"€" +"/"+ saldo+"€");
			System.out.println(nombreCliente+": "+cantidad+"€" +"/"+ saldo+"€");
		return true;
	}

	public Integer obtenerSaldo() {
		return saldo;
	}

	public void registrarTransaccion(String transaccion) {
		registroTrasacciones.add(transaccion);
	}

	public void imprimirHistorialTransacciones() {
		for (String string : registroTrasacciones) {
			System.out.println(string);
		}
	}



}
