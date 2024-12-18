package PracticasDeClase.Practica3Texto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTexto {
	
	private ServerSocket srSocket;
	private Socket socket;
	private InputStream in;
	private OutputStream out;
	private Integer port;
	private PrintWriter print;
	private InputStreamReader inputReader;
	private BufferedReader bufferReader; 
	
	
	public SocketServerTexto(Integer port) throws IOException {
		
		this.srSocket = new ServerSocket(port);
		this.port = port;
	}



	public void start() throws IOException {
		socket = srSocket.accept();
		in = socket.getInputStream();
		out = socket.getOutputStream();
		
	}
	
	public void stop() throws IOException {
		in.close();
		out.close();
		socket.close();
		srSocket.close();
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
			SocketServerTexto server = new SocketServerTexto(8081);
			server.start();
			server.abrirCanalesDeTexto();
			while(true) {
			String datoLeido = server.bufferReader.readLine();
			if(datoLeido.equalsIgnoreCase("fin")) {
				break;
			}
			System.out.println("Dato server recibido: " + datoLeido);
			server.print.println(datoLeido.toUpperCase());
			}
			server.cerrarCanalesDeTexto();
			server.stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
