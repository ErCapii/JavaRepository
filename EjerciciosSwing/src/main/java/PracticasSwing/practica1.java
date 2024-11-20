package PracticasSwing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class practica1 {
	private static final String AZUL = "Azul";
	private static final String ROJO = "Rojo";
	private static final String VERDE = "Verde";
	private static final String MARRON = "Marron";
	private JFrame frame;
	private JTextField tfPrimerCampo;
	private JTextField tfSegundoCampo;
	private JTextField tfTercerCampo;
	private JTextField tfCuartoCampo;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					practica1 window = new practica1();
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
	public practica1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 124, 72, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JComboBox<String> cbColores = new JComboBox();
		GridBagConstraints gbc_cbColores = new GridBagConstraints();
		gbc_cbColores.insets = new Insets(0, 0, 5, 5);
		gbc_cbColores.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbColores.gridx = 1;
		gbc_cbColores.gridy = 1;
		frame.getContentPane().add(cbColores, gbc_cbColores);
		
		cbColores.addItem(AZUL);
		cbColores.addItem(ROJO);
		cbColores.addItem(VERDE);
		cbColores.addItem(MARRON);
		cbColores.setFocusable(false);
		
		tfPrimerCampo = new JTextField();
		GridBagConstraints gbc_tfPrimerCampo = new GridBagConstraints();
		gbc_tfPrimerCampo.insets = new Insets(0, 0, 5, 5);
		gbc_tfPrimerCampo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPrimerCampo.gridx = 3;
		gbc_tfPrimerCampo.gridy = 1;
		frame.getContentPane().add(tfPrimerCampo, gbc_tfPrimerCampo);
		tfPrimerCampo.setColumns(10);
		
		JRadioButton rdbtnAzul = new JRadioButton("Azul");
		buttonGroup.add(rdbtnAzul);
		GridBagConstraints gbc_rdbtnAzul = new GridBagConstraints();
		gbc_rdbtnAzul.anchor = GridBagConstraints.WEST;
		gbc_rdbtnAzul.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAzul.gridx = 1;
		gbc_rdbtnAzul.gridy = 3;
		frame.getContentPane().add(rdbtnAzul, gbc_rdbtnAzul);
		
		tfSegundoCampo = new JTextField();
		GridBagConstraints gbc_tfSegundoCampo = new GridBagConstraints();
		gbc_tfSegundoCampo.insets = new Insets(0, 0, 5, 5);
		gbc_tfSegundoCampo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSegundoCampo.gridx = 3;
		gbc_tfSegundoCampo.gridy = 3;
		frame.getContentPane().add(tfSegundoCampo, gbc_tfSegundoCampo);
		tfSegundoCampo.setColumns(10);
		
		JRadioButton rdbtnVerde = new JRadioButton("Verde");
		buttonGroup.add(rdbtnVerde);
		GridBagConstraints gbc_rdbtnVerde = new GridBagConstraints();
		gbc_rdbtnVerde.anchor = GridBagConstraints.WEST;
		gbc_rdbtnVerde.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnVerde.gridx = 1;
		gbc_rdbtnVerde.gridy = 4;
		frame.getContentPane().add(rdbtnVerde, gbc_rdbtnVerde);
		
		JRadioButton rdbtnMarron = new JRadioButton("Marron");
		buttonGroup.add(rdbtnMarron);
		GridBagConstraints gbc_rdbtnMarron = new GridBagConstraints();
		gbc_rdbtnMarron.anchor = GridBagConstraints.WEST;
		gbc_rdbtnMarron.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnMarron.gridx = 1;
		gbc_rdbtnMarron.gridy = 5;
		frame.getContentPane().add(rdbtnMarron, gbc_rdbtnMarron);
		
		tfTercerCampo = new JTextField();
		GridBagConstraints gbc_tfTercerCampo = new GridBagConstraints();
		gbc_tfTercerCampo.insets = new Insets(0, 0, 5, 5);
		gbc_tfTercerCampo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTercerCampo.gridx = 3;
		gbc_tfTercerCampo.gridy = 5;
		frame.getContentPane().add(tfTercerCampo, gbc_tfTercerCampo);
		tfTercerCampo.setColumns(10);
		
		JRadioButton rdbtnRojo = new JRadioButton("Rojo");
		buttonGroup.add(rdbtnRojo);
		GridBagConstraints gbc_rdbtnRojo = new GridBagConstraints();
		gbc_rdbtnRojo.anchor = GridBagConstraints.WEST;
		gbc_rdbtnRojo.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnRojo.gridx = 1;
		gbc_rdbtnRojo.gridy = 6;
		frame.getContentPane().add(rdbtnRojo, gbc_rdbtnRojo);
		
		tfCuartoCampo = new JTextField();
		GridBagConstraints gbc_tfCuartoCampo = new GridBagConstraints();
		gbc_tfCuartoCampo.insets = new Insets(0, 0, 0, 5);
		gbc_tfCuartoCampo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCuartoCampo.gridx = 3;
		gbc_tfCuartoCampo.gridy = 7;
		frame.getContentPane().add(tfCuartoCampo, gbc_tfCuartoCampo);
		tfCuartoCampo.setColumns(10);
		
		KeyListener keyListener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				JTextField origen = (JTextField) e.getSource();
				if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					origen.transferFocus();
				}
				else if (e.getKeyCode() == KeyEvent.VK_UP) {
					origen.transferFocusBackward();
				}
			}
	};
			tfPrimerCampo.addKeyListener(keyListener);
			tfSegundoCampo.addKeyListener(keyListener);
			tfTercerCampo.addKeyListener(keyListener);
			tfCuartoCampo.addKeyListener(keyListener);
			
	
	
	}
}
