package PracticasDeClase.Practica2Adivinanza;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class SocketServerAdivinanza {

	private ServerSocket srSocket;
	private Socket socket;
	private InputStream in;
	private OutputStream out;
	private int port;

	public SocketServerAdivinanza(int port) throws IOException {
		this.srSocket = new ServerSocket(port);
		this.port = port;
	}

	public void start() throws IOException {
		System.out.println("Aceptando servidor");
		socket = srSocket.accept();
		System.out.println("Servidor Aceptado");
		in = socket.getInputStream();
		out = socket.getOutputStream();
	}

	public void stop() throws IOException {
		System.out.println("Cerrando servicios");
		in.close();
		out.close();
		socket.close();
		System.out.println("Servicios cerrados");
	}

	public static void main(String[] args) {
		try {
			SocketServerAdivinanza server = new SocketServerAdivinanza(8081);
			server.start();
			int contador = 0;
			int numeroAdivinar = new Random().nextInt(100);
			while (true) {
				int datoRecibido = server.in.read();
				if (datoRecibido == numeroAdivinar) {
					System.out.println("El numero " + datoRecibido + " es correcto intentos " + contador);
					break;
				}
				switch (Integer.compare(numeroAdivinar, datoRecibido)) {
				case 1 -> {
					if (numeroAdivinar - 20 > datoRecibido) {
						System.out.println("El numero " + datoRecibido + " es demasiado bajo");
						server.out.write(20);
					} else {
						System.out.println("El numero " + datoRecibido + " esta un poco bajo");
						server.out.write(10);
					}
				}
				case -1 -> {
					if (numeroAdivinar + 20 < datoRecibido) {
						System.out.println("El numero " + datoRecibido + " es demasiado alto");
						server.out.write(40);
					} else {
						System.out.println("El numero " + datoRecibido + " esta un poco alto");
						server.out.write(30);
					}
				}

				}
				contador++;
				

			}
			server.stop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
