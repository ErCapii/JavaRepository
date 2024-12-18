package Ejercicioo10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Ejercicio10 {

	private JFrame frame;
	private JTextField campoTabulador1;
	private JTextField campoTabulador2;
	private JTextField campoTabulador3;
	private JTextField campoTabulador4;
	private JComboBox cbElegirColor;
	  private JRadioButton rbColorAzul, rbColorRojo, rbColorVerde;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio10 window = new Ejercicio10();
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
	public Ejercicio10() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] color = { "","azul", "rojo", "verde" };
		cbElegirColor = new JComboBox<>(color);
		cbElegirColor.setBounds(31, 11, 108, 27);
		cbElegirColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String colorEscogido = (String) cbElegirColor.getSelectedItem();
				Color color = obtenerColor(colorEscogido);
				cambiarColorFondo(campoTabulador1, color);
				cambiarColorFondo(campoTabulador2, color);
				cambiarColorFondo(campoTabulador3, color);
				cambiarColorFondo(campoTabulador4, color);
				seleccionarRadioButton(colorEscogido);
			}

			public Color obtenerColor(String colorEscogido) {
				switch (colorEscogido) {
				case "azul":
					return Color.BLUE;
				case "rojo":
					return Color.RED;
				case "verde":
					return Color.GREEN;
				default:
					return Color.WHITE;
				}

			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(cbElegirColor);

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

		//buttonsGroup ->
		rbColorAzul = new JRadioButton("Azul");
		rbColorAzul.addActionListener(e -> {
            cbElegirColor.setSelectedItem("azul");
            cambiarColorFondo(campoTabulador1, Color.BLUE);
            cambiarColorFondo(campoTabulador2, Color.BLUE);
            cambiarColorFondo(campoTabulador3, Color.BLUE);
            cambiarColorFondo(campoTabulador4, Color.BLUE);
        });
		buttonGroup.add(rbColorAzul);
		rbColorAzul.setBounds(30, 155, 109, 23);
		frame.getContentPane().add(rbColorAzul);
		rbColorRojo = new JRadioButton("Rojo");
		rbColorRojo.addActionListener(e -> {
            cbElegirColor.setSelectedItem("rojo");
            cambiarColorFondo(campoTabulador1, Color.RED);
            cambiarColorFondo(campoTabulador2, Color.RED);
            cambiarColorFondo(campoTabulador3, Color.RED);
            cambiarColorFondo(campoTabulador4, Color.RED);
        });
		
		buttonGroup.add(rbColorRojo);
		rbColorRojo.setBounds(29, 193, 109, 23);
		frame.getContentPane().add(rbColorRojo);
		rbColorVerde = new JRadioButton("Verde");
		rbColorVerde.addActionListener(e -> {
            cbElegirColor.setSelectedItem("verde");
            cambiarColorFondo(campoTabulador1, Color.GREEN);
            cambiarColorFondo(campoTabulador2, Color.GREEN);
            cambiarColorFondo(campoTabulador3, Color.GREEN);
            cambiarColorFondo(campoTabulador4, Color.GREEN);
        });
		buttonGroup.add(rbColorVerde);
		rbColorVerde.setBounds(29, 231, 109, 23);
		frame.getContentPane().add(rbColorVerde);
		

	};
	private void cambiarColorFondo(JTextField campo, Color color) {
		campo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				campo.setBackground(color);
			}

			@Override
			public void focusLost(FocusEvent e) {
				campo.setBackground(null);
			}
		});
	}
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
				if(obj.equals(campoTabulador4)){
					campoTabulador1.grabFocus();
				}else {
				((JTextField) e.getSource()).transferFocus();
				}
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				if(obj.equals(campoTabulador1)){
					campoTabulador4.grabFocus();
				}else {
				((JTextField) e.getSource()).transferFocusBackward();
				}
			}
		}
	};
	
	
}
