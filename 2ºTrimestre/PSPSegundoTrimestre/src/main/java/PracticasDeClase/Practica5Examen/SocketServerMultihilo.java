package PracticasDeClase.Practica5Examen;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerMultihilo {

	private ServerSocket srSocket;
	
	SocketServerMultihilo(int puerto) throws IOException{
		srSocket = new ServerSocket(puerto);
		while(true) {
			Socket socket = srSocket.accept();
			System.out.println("(Server) conexion establecida");
			new SocketGestorDeProcesos(socket).start();
		}
	}
	
	public void stop() throws IOException {
		srSocket.close();
	}
	
	public static void main(String[] args) {
		try {
			SocketServerMultihilo server = new SocketServerMultihilo(8081);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
