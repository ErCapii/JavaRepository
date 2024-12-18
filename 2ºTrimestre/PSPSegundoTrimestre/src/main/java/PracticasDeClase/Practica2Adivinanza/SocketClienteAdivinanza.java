package PracticasDeClase.Practica2Adivinanza;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SocketClienteAdivinanza {

	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private String address;
	private int port;

	public SocketClienteAdivinanza(String address, int port) {
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
		SocketClienteAdivinanza cliente = new SocketClienteAdivinanza("localhost", 8081);

		try {
			cliente.start();
			for (int i = 0; i <= 10; i++) {
				int numeroPrueba = new Random().nextInt(100);
				cliente.outputStream.write(numeroPrueba);
			}
			while (true) {
				int numeroDevuelto = cliente.inputStream.read();
				if (numeroDevuelto == 1) {
					System.out.println("numero correcto");
					break;
				}
				switch (numeroDevuelto) {
				case 20 -> {
					cliente.outputStream.write(ThreadLocalRandom.current().nextInt(numeroDevuelto, 101));
				}
				case 10 -> {
					cliente.outputStream.write(ThreadLocalRandom.current().nextInt(numeroDevuelto, numeroDevuelto + 10));
				}
				case 30 -> {
					cliente.outputStream.write(ThreadLocalRandom.current().nextInt(numeroDevuelto - 10, numeroDevuelto));
				}
				case 40 -> {
					cliente.outputStream.write(ThreadLocalRandom.current().nextInt(numeroDevuelto - 20, numeroDevuelto));
				}
				}
			}
			cliente.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
