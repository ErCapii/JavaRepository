package PracticasDeClase.Practica5Examen;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class SocketServerCliente1Multihilo {

	private InputStream in;
	private Socket socket;
	private String serverIp;
	private Integer port;
	
	public SocketServerCliente1Multihilo(String serverIp, Integer port) {
		this.serverIp = serverIp;
		this.port = port;
	}
	
	private void start() throws UnknownHostException, IOException {
			socket = new Socket(serverIp,port);
			in = socket.getInputStream();
	}
	
	private void stop() throws IOException {
		in.close();
		socket.close();
	}
	
	public static void main(String[] args) {
		SocketServerCliente1Multihilo cliente = new SocketServerCliente1Multihilo("localhost",8081);
		try {
			cliente.start();
			Integer datoRecibido = cliente.in.read();
			List<Integer> listaNumeros = new ArrayList<Integer>();
			Integer numeroListado = 2;
			
			if(datoRecibido == numeroListado) {
				listaNumeros.add(datoRecibido);
				numeroListado++;
				if(datoRecibido == 11) {
					listaNumeros.forEach(n -> System.out.println(n + "|"));
				}
			}
				
			System.out.println("Dato cliente recibido: " + datoRecibido);
			cliente.stop();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
