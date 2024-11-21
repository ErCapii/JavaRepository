package Ejercicioo11;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ejercicio11 {

	private static final String AZUL = "Azul";
	private static final String ROJO = "Rojo";
	private static final String AMARILLO = "Amarillo";
	private static final String VERDE = "Verde";
	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio11 window = new Ejercicio11();
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
	public Ejercicio11() {
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
		
		textField1 = new JTextField();
		textField1.setBounds(94, 66, 96, 19);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(94, 106, 96, 19);
		frame.getContentPane().add(textField2);
		
		textField3 = new JTextField();
		textField3.setColumns(10);
		textField3.setBounds(94, 154, 96, 19);
		frame.getContentPane().add(textField3);
		
		textField4 = new JTextField();
		textField4.setColumns(10);
		textField4.setBounds(94, 195, 96, 19);
		
		frame.getContentPane().add(textField4);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(272, 66, 96, 21);
		frame.getContentPane().add(comboBox);
		
		comboBox.addItem(VERDE);
		comboBox.addItem(AMARILLO);
		comboBox.addItem(ROJO);
		comboBox.addItem(AZUL);
		comboBox.setFocusable(false);
		
		JRadioButton rdbtnRojo = new JRadioButton(ROJO);
		rdbtnRojo.setBounds(265, 106, 103, 21);
		frame.getContentPane().add(rdbtnRojo);
		
		JRadioButton rdbtnVerde = new JRadioButton(VERDE);
		rdbtnVerde.setBounds(265, 129, 103, 21);
		frame.getContentPane().add(rdbtnVerde);
		
		JRadioButton rdbtnAmarillo = new JRadioButton(AMARILLO);
		rdbtnAmarillo.setBounds(265, 153, 103, 21);
		frame.getContentPane().add(rdbtnAmarillo);
		
		JRadioButton rdbtnAzul = new JRadioButton(AZUL);
		rdbtnAzul.setBounds(265, 176, 103, 21);
		frame.getContentPane().add(rdbtnAzul);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnAzul);
		grupo.add(rdbtnVerde);
		grupo.add(rdbtnAmarillo);
		grupo.add(rdbtnRojo);
		
		
		KeyListener keyListener = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				JTextField origen = (JTextField) e.getSource();
				if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					origen.transferFocus();
				}
				else if (e.getKeyCode() == KeyEvent.VK_UP) {
					origen.transferFocusBackward();
				}
			}
		};
		
		
		
		textField1.addKeyListener(keyListener);
		textField2.addKeyListener(keyListener);
		textField3.addKeyListener(keyListener);
		textField4.addKeyListener(keyListener);
		
		
		ItemListener itemListener = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				rdbtnRojo.setSelected(comboBox.getSelectedItem().equals(ROJO));
				rdbtnVerde.setSelected(comboBox.getSelectedItem().equals(VERDE));
				rdbtnAzul.setSelected(comboBox.getSelectedItem().equals(AZUL));
				rdbtnAmarillo.setSelected(comboBox.getSelectedItem().equals(AMARILLO));
			}
		};
		
		comboBox.addItemListener(itemListener);
		
		ActionListener actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton origen = (JRadioButton) e.getSource();
				comboBox.setSelectedItem(origen.getText());
			}
		};
		
		rdbtnAmarillo.addActionListener(actionListener);
		rdbtnVerde.addActionListener(actionListener);
		rdbtnRojo.addActionListener(actionListener);
		rdbtnAzul.addActionListener(actionListener);
				
		FocusListener focusListener = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				JTextField origen = (JTextField) e.getSource();
				origen.setBackground(Color.WHITE);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				JTextField origen = (JTextField) e.getSource();
				if (comboBox.getSelectedItem().equals(VERDE)) {
					origen.setBackground(Color.GREEN);
				}
				else if (comboBox.getSelectedItem().equals(AMARILLO)) {
					origen.setBackground(Color.YELLOW);
				}
				else if (comboBox.getSelectedItem().equals(ROJO)) {
					origen.setBackground(Color.RED);
				}
				else {
					origen.setBackground(Color.CYAN);
				}
				
				
				
			}
				
		};
		
		textField1.addFocusListener(focusListener);
		textField2.addFocusListener(focusListener);
		textField3.addFocusListener(focusListener);
		textField4.addFocusListener(focusListener);
		
		
	}
}





