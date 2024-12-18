package PracticasDeClase.Practica1Repaso;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SckServerNumerico {

	private ServerSocket serverSocket;
	private Socket socket;
	private InputStream inputStream;
	private OutputStream outputStream;
	private int port;
	
	

	public SckServerNumerico(int port) throws IOException {
		this.serverSocket = new ServerSocket(port);
		this.port = port;
	}

	public void start() throws IOException {

		socket = serverSocket.accept();
		inputStream = socket.getInputStream();
		outputStream = socket.getOutputStream();
	}
	
	public void stop() throws IOException {
		inputStream.close();
		outputStream.close();
		socket.close();
			
		
	}
	public static void main(String[] args) {
		SckServerNumerico server;
		
		try {
			server = new SckServerNumerico(8081);
			server.start();
			while(true) {
				int datoLeido = server.inputStream.read();
				if(datoLeido == -1) {
					break;
				}
				System.out.println("[Server] Dato recibido " + datoLeido);
				int datoDevuelto = ++datoLeido;
				server.outputStream.write(datoDevuelto);
				System.out.println("[Server] Dato devuelto " + datoLeido);
				server.stop();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
