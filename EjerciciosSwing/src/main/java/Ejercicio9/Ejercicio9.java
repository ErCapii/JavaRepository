package Ejercicio9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Ejercicio9 {

	private JFrame frame;
	private JTextField campoTabulador1;
	private JTextField campoTabulador2;
	private JTextField campoTabulador3;
	private JTextField campoTabulador4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio9 window = new Ejercicio9();
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
	public Ejercicio9() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		campoTabulador1 = new JTextField();
		frame.getContentPane().add(campoTabulador1);
		campoTabulador1.addKeyListener(keyListener);
		cambiarColorFondo(campoTabulador1);
		campoTabulador1.setColumns(1);

		campoTabulador2 = new JTextField();
		frame.getContentPane().add(campoTabulador2);
		campoTabulador2.addKeyListener(keyListener);
		cambiarColorFondo(campoTabulador2);
		campoTabulador2.setColumns(1);

		campoTabulador3 = new JTextField();
		frame.getContentPane().add(campoTabulador3);
		campoTabulador3.addKeyListener(keyListener);
		cambiarColorFondo(campoTabulador3);
		campoTabulador3.setColumns(1);

		campoTabulador4 = new JTextField();
		frame.getContentPane().add(campoTabulador4);
		campoTabulador4.addKeyListener(keyListener);
		cambiarColorFondo(campoTabulador4);
		campoTabulador4.setColumns(1);
	}

	private void cambiarColorFondo(JTextField campo) {
		campo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				campo.setBackground(Color.cyan);
			}

			@Override
			public void focusLost(FocusEvent e) {
				campo.setBackground(null);
			}
		});
	}

	private KeyAdapter keyListener = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN | e.getKeyCode() == KeyEvent.VK_ENTER) {
				((JTextField) e.getSource()).transferFocus();

			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				((JTextField) e.getSource()).transferFocusBackward();
			}
		}
	};
}
