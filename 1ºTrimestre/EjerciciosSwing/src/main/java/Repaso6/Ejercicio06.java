package Repaso6;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio06 {

	private JFrame frame;
	private JTextField textField;
	private JLabel lbResultado ;
	private JButton btSeleccionar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio06 window = new Ejercicio06();
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
	public Ejercicio06() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(233, 98, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNueva = new JLabel("Nueva ciudad");
		lblNueva.setBounds(117, 101, 96, 13);
		frame.getContentPane().add(lblNueva);
		
		JLabel lblDestinos = new JLabel("Destinos disponibles");
		lblDestinos.setBounds(117, 139, 96, 13);
		frame.getContentPane().add(lblDestinos);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btSeleccionar.setEnabled(comboBox.getSelectedItem()!=null);
				if (comboBox.getSelectedItem()==null) {
					lbResultado.setText("");
				}
			}
		});
		comboBox.setBounds(233, 135, 96, 21);
		frame.getContentPane().add(comboBox);
		
		JButton btLimpiar = new JButton("Limpiar");
		btLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				textField.requestFocus();
			}
		});
		btLimpiar.setBounds(115, 176, 85, 21);
		frame.getContentPane().add(btLimpiar);
		
		btSeleccionar = new JButton("Seleccionar");
		btSeleccionar.setEnabled(false);
		btSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbResultado.setText("Ciudad seleccionada: " + comboBox.getSelectedItem());
			}
		});
		btSeleccionar.setBounds(210, 176, 119, 21);
		frame.getContentPane().add(btSeleccionar);
		
		lbResultado = new JLabel("");
		lbResultado.setBounds(142, 225, 187, 13);
		frame.getContentPane().add(lbResultado);
		
		
		KeyListener keyListener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// Obtener el texto del textfield
					String texto = textField.getText();
					// Añadirlo al combobox
					comboBox.addItem(texto);
					// Quitar si hay algo seleccionado en el combobox
					comboBox.setSelectedIndex(-1);
					// Borrar el contenido del textfield
					textField.setText("");
					
				}
			}
		};
		
		
		textField.addKeyListener(keyListener);
		
	}
}
