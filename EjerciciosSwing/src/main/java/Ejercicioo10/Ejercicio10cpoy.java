package Ejercicioo10;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ejercicio10cpoy {

	private JFrame frame;
	private JTextField campoTabulador1;
	private JTextField campoTabulador2;
	private JTextField campoTabulador3;
	private JTextField campoTabulador4;
	private JComboBox cbElegirColor;
	private Color[] colores = { Color.blue, Color.red, Color.green };
	private String[] nombreColores = { "Azul", "Rojo", "Verde" };
	private JRadioButton rbColorAzul, rbColorRojo, rbColorVerde;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio10cpoy window = new Ejercicio10cpoy();
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
	public Ejercicio10cpoy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cbElegirColor = new JComboBox<>(nombreColores);
		cbElegirColor.setBounds(31, 11, 108, 27);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(cbElegirColor);
		// Campos textfield ->
		campoTabulador1 = new JTextField();
		campoTabulador1.setBounds(156, 11, 108, 27);
		campoTabulador1.addKeyListener(keyListener);
		frame.getContentPane().add(campoTabulador1);
		campoTabulador1.setColumns(1);

		campoTabulador2 = new JTextField();
		campoTabulador2.setBounds(156, 49, 108, 27);
		campoTabulador2.addKeyListener(keyListener);
		frame.getContentPane().add(campoTabulador2);
		campoTabulador2.setColumns(1);

		campoTabulador3 = new JTextField();
		campoTabulador3.setBounds(156, 87, 108, 27);
		campoTabulador3.addKeyListener(keyListener);
		frame.getContentPane().add(campoTabulador3);
		campoTabulador3.setColumns(1);

		campoTabulador4 = new JTextField();
		campoTabulador4.setBounds(156, 125, 108, 27);
		campoTabulador4.addKeyListener(keyListener);
		frame.getContentPane().add(campoTabulador4);
		campoTabulador4.setColumns(1);

		// buttonsGroup ->
		rbColorAzul = new JRadioButton("Azul");
		buttonGroup.add(rbColorAzul);
		rbColorAzul.setBounds(30, 155, 109, 23);
		frame.getContentPane().add(rbColorAzul);

		rbColorRojo = new JRadioButton("Rojo");
		buttonGroup.add(rbColorRojo);
		rbColorRojo.setBounds(29, 193, 109, 23);
		frame.getContentPane().add(rbColorRojo);

		rbColorVerde = new JRadioButton("Verde");
		buttonGroup.add(rbColorVerde);
		rbColorVerde.setBounds(29, 231, 109, 23);
		frame.getContentPane().add(rbColorVerde);

		FocusListener focusL = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				JTextField campo = (JTextField) e.getSource();
				campo.setBackground(null);
			}

			@Override
			public void focusGained(FocusEvent e) {
				JTextField campo = (JTextField) e.getSource();
				String color = (String) cbElegirColor.getSelectedItem();
				switch (color) {
				case "azul":
					campo.setBackground(colores[0]);
					break;
				case "rojo":
					campo.setBackground(colores[1]);
					break;
				case "verde":
					campo.setBackground(colores[2]);
					break;
				default:
					buttonGroup.clearSelection();
					break;
				}
			}
		};
		campoTabulador1.addFocusListener(focusL);
		campoTabulador2.addFocusListener(focusL);
		campoTabulador3.addFocusListener(focusL);
		campoTabulador4.addFocusListener(focusL);

	};

//	private void cambiarColorFondo(JTextField campo, Color color) {
//		campo.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusGained(FocusEvent e) {
//			}
//
//			@Override
//			public void focusLost(FocusEvent e) {
//				campo.setBackground(null);
//			}
//		});
//	}
	private void seleccionarRadioButton(String colorEscogido) {
		switch (colorEscogido) {
		case "azul":
			rbColorAzul.setSelected(true);
			break;
		case "rojo":
			rbColorRojo.setSelected(true);
			break;
		case "verde":
			rbColorVerde.setSelected(true);
			break;
		default:
			buttonGroup.clearSelection();
			break;
		}
	}

	private KeyAdapter keyListener = new KeyAdapter() {
		@Override

		public void keyPressed(KeyEvent e) {
			JTextField obj = (JTextField) e.getSource();

			if (e.getKeyCode() == KeyEvent.VK_DOWN | e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (obj.equals(campoTabulador4)) {
					campoTabulador1.grabFocus();
				} else {
					((JTextField) e.getSource()).transferFocus();
				}
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (obj.equals(campoTabulador1)) {
					campoTabulador4.grabFocus();
				} else {
					((JTextField) e.getSource()).transferFocusBackward();
				}
			}
		}
	};

}
