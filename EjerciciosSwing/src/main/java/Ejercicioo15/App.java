package Ejercicioo15;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class App {

	private JFrame frame;

	private Pantalla1View pantalla1;
	private Pantalla2View pantalla2;
	private Pantalla3View pantalla3;
	private PantallaBienvenida pantallaBienvenida;
	private Boolean mantenerTexto;
	
	
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
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pantalla1 = new Pantalla1View(this);
		pantalla2 = new Pantalla2View(this);
		pantalla3 = new Pantalla3View(this);
		pantallaBienvenida = new PantallaBienvenida(this);
		
		mostrarPantallaBienvenida();
	}
	public void mostrarPantallaBienvenida() {
		frame.setContentPane(pantallaBienvenida);
		frame.revalidate();
	}
	public void mostrarPantalla1(String textoPrevio) {
		frame.setContentPane(pantalla1);
		if (mantenerTexto) {
			pantalla1.cambiarTexto(textoPrevio);
		}
		frame.revalidate();
	}
	public void mostrarPantalla2(String textoPrevio) {
		frame.setContentPane(pantalla2);
		if (mantenerTexto) {
			pantalla2.cambiarTexto(textoPrevio);
		}
		frame.revalidate();
	}
	public void mostrarPantalla3(String textoPrevio) {
		frame.setContentPane(pantalla3);
		if (mantenerTexto) {
			pantalla3.cambiarTexto(textoPrevio);
		}
		frame.revalidate();
	}

	public void entrar(Integer selectedIndex, boolean mantenerTexto) {
		this.mantenerTexto = mantenerTexto;
		switch (selectedIndex) {
			case 0 -> mostrarPantalla1("");
			case 1 -> mostrarPantalla2("");
			case 2 -> mostrarPantalla3("");
		}
		
	}

	public void salir() {
		Integer option = JOptionPane.showConfirmDialog(frame, "¿Está seguro de salir?","Salir", JOptionPane.YES_NO_OPTION);
		if (option == 0) {
			System.exit(0);
		}
	}

}
