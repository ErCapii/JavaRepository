package PracticasDeClase.Practica4Multihilo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SocketGestorDeProcesos extends Thread {
	
	private Socket socket;
	private OutputStream out;
	
	
	public SocketGestorDeProcesos(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void lanzarProceso() throws IOException {
		out = socket.getOutputStream();
		
		Integer tiempoEspera = new Random().nextInt(10)+1;
		try {
			TimeUnit.SECONDS.sleep(tiempoEspera);
			System.out.println("Enviando desde gestor de procesos: " +tiempoEspera);
			out.write(tiempoEspera);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			out.close();
		}
	}
	
	@Override
	public void run() {
		try {
			lanzarProceso();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
