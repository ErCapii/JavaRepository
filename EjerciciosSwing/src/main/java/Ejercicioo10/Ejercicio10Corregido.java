package Ejercicioo10;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
 
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class Ejercicio10Corregido {
 
	private JFrame frame;
	private JTextField campoTabulador1;
	private JTextField campoTabulador2;
	private JTextField campoTabulador3;
	private JTextField campoTabulador4;
	private JComboBox<String> comboBox;
	private Color[] colores = { Color.BLUE, Color.GREEN, Color.RED };
	private String[] nombreColores = { "Azul", "Verde", "Rojo" };
	private Map<String, Color> mapaColores = new HashMap<String, Color>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio10Corregido window = new Ejercicio10Corregido();
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
	public Ejercicio10Corregido() {
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
 
		campoTabulador1 = new JTextField();
		campoTabulador1.setBounds(169, 37, 86, 20);
		frame.getContentPane().add(campoTabulador1);
		campoTabulador1.setColumns(10);
 
		campoTabulador2 = new JTextField();
		campoTabulador2.setBounds(169, 68, 86, 20);
		frame.getContentPane().add(campoTabulador2);
		campoTabulador2.setColumns(10);
 
		campoTabulador3 = new JTextField();
		campoTabulador3.setBounds(169, 99, 86, 20);
		frame.getContentPane().add(campoTabulador3);
		campoTabulador3.setColumns(10);
 
		campoTabulador4 = new JTextField();
		campoTabulador4.setBounds(169, 130, 86, 20);
		frame.getContentPane().add(campoTabulador4);
		campoTabulador4.setColumns(10);
 
		comboBox = new JComboBox<String>(nombreColores);
		
		comboBox.setBounds(24, 36, 135, 22);
		frame.getContentPane().add(comboBox);
 
		JRadioButton rdbtnNegro = new JRadioButton("Azul");
		buttonGroup.add(rdbtnNegro);
		rdbtnNegro.setBounds(36, 169, 109, 23);
		frame.getContentPane().add(rdbtnNegro);
 
		JRadioButton rdbtnAzul = new JRadioButton("Verde");
		buttonGroup.add(rdbtnAzul);
		rdbtnAzul.setBounds(36, 200, 109, 23);
		frame.getContentPane().add(rdbtnAzul);
 
		JRadioButton rdbtnGris = new JRadioButton("Rojo");
		buttonGroup.add(rdbtnGris);
		rdbtnGris.setBounds(36, 231, 109, 23);
		frame.getContentPane().add(rdbtnGris);
		
		
		ActionListener cambiarSeleccion = new ActionListener() {
 
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().getClass().equals(comboBox.getClass())) {
					JComboBox<String> objeto = (JComboBox<String>) e.getSource();
					String seleccion = (String) objeto.getSelectedItem();
					for (Iterator<AbstractButton> iterator = buttonGroup.getElements().asIterator(); iterator.hasNext();) {
						JRadioButton boton = (JRadioButton) iterator.next();
						if(boton.getText().equalsIgnoreCase(seleccion)) {
								boton.setSelected(true);
						}
					}
				}else if (e.getSource() instanceof JRadioButton) {
		            JRadioButton botonSeleccionado = (JRadioButton) e.getSource();
		            String seleccionBoton = botonSeleccionado.getText();
		            
		            comboBox.setSelectedItem(seleccionBoton);
		        }
			}
			
		};
		comboBox.addActionListener(cambiarSeleccion);
		for (Iterator<AbstractButton> iterator = buttonGroup.getElements().asIterator(); iterator.hasNext();) {
		    JRadioButton boton = (JRadioButton) iterator.next();
		    boton.addActionListener(cambiarSeleccion);
		}
		
		KeyAdapter abajoKeyListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				JTextField objeto = (JTextField) e.getSource();
				if ((e.getKeyCode() == KeyEvent.VK_DOWN | e.getKeyCode() == KeyEvent.VK_ENTER) & objeto.equals(campoTabulador4)) {
					campoTabulador1.grabFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN | e.getKeyCode() == KeyEvent.VK_ENTER) {
					((JTextField) e.getSource()).transferFocus();
				}
			}
		};
		campoTabulador1.addKeyListener(abajoKeyListener);
		campoTabulador2.addKeyListener(abajoKeyListener);
		campoTabulador3.addKeyListener(abajoKeyListener);
		campoTabulador4.addKeyListener(abajoKeyListener);
 
		KeyAdapter arribaKeyListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				JTextField objeto = (JTextField) e.getSource();
				if (e.getKeyCode() == KeyEvent.VK_UP & objeto.equals(campoTabulador1)) {
					campoTabulador4.grabFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					((JTextField) e.getSource()).transferFocusBackward();
				}
			}
		};
		campoTabulador1.addKeyListener(arribaKeyListener);
		campoTabulador2.addKeyListener(arribaKeyListener);
		campoTabulador3.addKeyListener(arribaKeyListener);
		campoTabulador4.addKeyListener(arribaKeyListener);
 
		FocusListener focoListener = new FocusListener() {
 
			@Override
			public void focusLost(FocusEvent e) {
				JTextField campo = (JTextField) e.getSource();
				campo.setBackground(null);
			}
 
			@Override
			public void focusGained(FocusEvent e) {
				JTextField campo = (JTextField) e.getSource();
				String color = (String) comboBox.getSelectedItem();
				campo.setBackground(mapaColores.get(color));
			}
		};
		campoTabulador1.addFocusListener(focoListener);
		campoTabulador2.addFocusListener(focoListener);
		campoTabulador3.addFocusListener(focoListener);
		campoTabulador4.addFocusListener(focoListener);
 
		for (int i = 0; i < nombreColores.length; i++) {
			mapaColores.put(nombreColores[i], colores[i]);
		}
 
	}
}