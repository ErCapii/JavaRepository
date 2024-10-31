package Ejercicio7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ejercicio7 {

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
					Ejercicio7 window = new Ejercicio7();
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
	public Ejercicio7() {
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
		campoTabulador1.setColumns(1);

		campoTabulador2 = new JTextField();
		frame.getContentPane().add(campoTabulador2);
		campoTabulador2.addKeyListener(keyListener);
		campoTabulador2.setColumns(1);

		campoTabulador3 = new JTextField();
		frame.getContentPane().add(campoTabulador3);
		campoTabulador3.addKeyListener(keyListener);
		campoTabulador3.setColumns(1);

		campoTabulador4 = new JTextField();
		frame.getContentPane().add(campoTabulador4);
		campoTabulador4.addKeyListener(keyListener);
		campoTabulador4.setColumns(1);
		

        frame.getContentPane().add(campoTabulador4);
	}

	private KeyAdapter keyListener = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				((JTextField) e.getSource()).transferFocus();

			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				((JTextField) e.getSource()).transferFocusBackward();
			}
		}
	};
}
