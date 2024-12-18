package PracticasDeClase.Practica1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class SocketClienteNumerico {

	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private String address;
	private int port;

	public SocketClienteNumerico(String address, int port) {

		this.address = address;
		this.port = port;
	}

	public void start() throws UnknownHostException, IOException {
		System.out.println("[Client] Lanzando peticion al server...");
		socket = new Socket(address, port);
		is = socket.getInputStream();
		os = socket.getOutputStream();
		System.out.println("[Client] Conexion establecida");

	}

	public void stop() throws IOException {
		System.out.println("[Client] Parando conexion con " + address + " " + port);
		is.close();
		os.close();
		socket.close();
		System.out.println("[Client] Conexion cerrada");
	}

	public static void main(String[] args) {
		SocketClienteNumerico cliente = new SocketClienteNumerico("localhost", 8081);

		try {
			cliente.start();
			for (int i = 0; i < 254; i++) {
				int datoAEnviar = i;
				System.out.printf("[Client] Enviando %d a %s:%d.%n", datoAEnviar, cliente.address, cliente.port);
				cliente.os.write(datoAEnviar);
				int datoRecibido = cliente.is.read();
				System.out.printf("[Client] Recibido %s %d de %s:%d.%n",
						datoRecibido - datoAEnviar == 1 ? "bien" : "mal", datoRecibido, cliente.address, cliente.port);
			}
			cliente.stop();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
