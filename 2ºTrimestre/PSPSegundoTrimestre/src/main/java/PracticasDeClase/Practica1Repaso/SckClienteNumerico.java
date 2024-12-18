package PracticasDeClase.Practica1Repaso;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SckClienteNumerico {

	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private String address;
	private int port;

	public SckClienteNumerico(String address, int port) {
		this.address = address;
		this.port = port;
	}

	public void start() throws UnknownHostException, IOException {
		socket = new Socket(address, port);
		inputStream = socket.getInputStream();
		outputStream = socket.getOutputStream();
	}

	public void stop() throws IOException {
		inputStream.close();
		outputStream.close();
		socket.close();
	}

	public static void main(String[] args) {

		SckClienteNumerico cliente = new SckClienteNumerico("localhost", 8081);

		try {
			cliente.start();
			for (int i = 0; i < 254; i++) {
				int datoEnviar = i;
				System.out.println("[Cliente] Enviando " + datoEnviar + " direccion " + cliente.address + " puerto " + cliente.port);
				cliente.outputStream.write(datoEnviar);
				int datoRecibido = cliente.inputStream.read();
				System.out.println("[Cliente] Enviando " + datoRecibido + " direccion " + cliente.address + " puerto " + cliente.port);
				
			}
			cliente.stop();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
