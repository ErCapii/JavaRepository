package PracticasDeClase.Practica3Texto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClienteTexto {

	private Socket socket;
	private InputStream in;
	private OutputStream out;
	private String address;
	private Integer port;
	private PrintWriter print;
	private InputStreamReader inputReader;
	private BufferedReader bufferReader; 
	
	public SocketClienteTexto(String address, Integer port) throws IOException {

		this.address = address;
		this.port = port;
	}

	public void start() throws IOException {
		socket = new Socket(address, port);
		in = socket.getInputStream();
		out = socket.getOutputStream();

	}

	public void stop() throws IOException {
		in.close();
		out.close();
		socket.close();
	}
	public void abrirCanalesDeTexto() {
		print = new PrintWriter(out,true);
		inputReader = new InputStreamReader(in);
		bufferReader = new BufferedReader(inputReader);
	}
	
	public void cerrarCanalesDeTexto() throws IOException {
		print.close();
		bufferReader.close();
		inputReader.close();
	}

	public static void main(String[] args) {

		try {
			SocketClienteTexto cliente = new SocketClienteTexto("localhost", 8081);
			cliente.start();
			cliente.abrirCanalesDeTexto();
			for (int i = 0; i <= 200; i++) {
				String datoEnviado = "datoenviado:" +i;
				cliente.print.println(datoEnviado);
				System.out.println("Dato cliente recibido: " + cliente.bufferReader.readLine());
			}
			cliente.print.println("fin");
			cliente.cerrarCanalesDeTexto();
			cliente.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
