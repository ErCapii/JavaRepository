package PracticasDeClase.Practica1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerNumerico {

	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream is;
	private OutputStream os;
	private int port;

	public SocketServerNumerico(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		this.port = port;
	}

	public void start() throws IOException {
		System.out.println("[Servidor] Esperando conexion...");
		socket = serverSocket.accept();
		System.out.println("[Servidor] Conexion establecida");
		is = socket.getInputStream();
		os = socket.getOutputStream();
	}

	public void stop() throws IOException {
		System.out.println("[Servidor] Parando conexion...");
		is.close();
		os.close();
		socket.close();
		serverSocket.close();
		System.out.println("[Servidor] Conexion cerrada");
	}

	public static void main(String[] args) {
		SocketServerNumerico server;

		try {
			server = new SocketServerNumerico(8081);
			server.start();
			while (true) {
				int datoLeido = server.is.read();
				if (datoLeido == -1)
					break;
				System.out.printf("[Server] Dato recibido: %d %n", datoLeido);
				int datoADevolver = ++datoLeido;
				server.os.write(datoADevolver);
				System.out.printf("[Server] Dato enviado: %d %n", datoLeido);
			}
			server.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
