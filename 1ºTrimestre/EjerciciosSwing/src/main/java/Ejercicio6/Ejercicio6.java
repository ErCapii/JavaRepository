package Ejercicio6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ejercicio6 {

	private JFrame frame;
	private JTextField tfResultado;

	public Ejercicio6(JTextField tfResultado) {
		super();
		this.tfResultado = tfResultado;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio6 window = new Ejercicio6();
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
	public Ejercicio6() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnSumar = new JButton("Sumar");
		tfResultado = new JTextField();
		frame.getContentPane().add(tfResultado);
		tfResultado.setColumns(10);
		frame.getContentPane().add(btnSumar);
		tfResultado.setText("0");

		btnSumar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String lblString = tfResultado.getText();
					Integer numero = Integer.parseInt(lblString);
					numero = numero + 1;
					tfResultado.setText(numero.toString());
				} catch (NumberFormatException ex) {
					tfResultado.setText("0");
					JOptionPane.showMessageDialog(frame, "Tiene que introducir un valor numérico", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		frame.getContentPane().add(tfResultado);
	}

}
