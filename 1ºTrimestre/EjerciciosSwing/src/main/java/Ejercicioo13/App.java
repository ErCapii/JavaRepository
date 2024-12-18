package Ejercicioo13;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App {

	private JFrame frame;
	private Bienvenida bienvenida;
	private Pantalla1 pantalla1;
	private Pantalla2 pantalla2;
	private Pantalla3 pantalla3;
	private String texto;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		pantalla1 = new Pantalla1(this); 
		pantalla2 = new Pantalla2(this); 
		pantalla3 = new Pantalla3(this);
		bienvenida = new Bienvenida(this);
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(bienvenida);
	}
	public void lanzarBienvenida() {
		frame.setContentPane(bienvenida);
		frame.revalidate();
	}
	
	public void lanzarPantalla1(){
		frame.setContentPane(pantalla1);
		pantalla1.cambiarTexto(getJTtexto());
		frame.revalidate();
	}
	public void lanzarPantalla2(){
		frame.setContentPane(pantalla2);
		pantalla2.cambiarTexto(getJTtexto());
		frame.revalidate();
	}
	public void lanzarPantalla3(){
		frame.setContentPane(pantalla3);
		pantalla3.cambiarTexto(getJTtexto());
		frame.revalidate();
	}
	public String getJTtexto() {
		return texto;
	}

	public void setJTtexto(String texto) {
		this.texto = texto;
	}
	
}
