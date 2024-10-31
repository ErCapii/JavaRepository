package Ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.Component;

public class Ejercicio2 {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField tfDia;
	private JTextField tfMes;
	private JTextField tfAño;
	private JTextField tfNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio2 window = new Ejercicio2();
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
	public Ejercicio2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 5));
		
		JPanel panelNombre = new JPanel();
		panelNombre.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panelNombre);
		panelNombre.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		panelNombre.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setColumns(10);
		panelNombre.add(tfNombre);
		
		JPanel panelDNI = new JPanel();
		panelDNI.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(panelDNI);
		panelDNI.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblDni = new JLabel("DNI:");
		panelDNI.add(lblDni);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panelDNI.add(textField_1);
		
		JPanel panelFecha = new JPanel();
		panelFecha.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(panelFecha);
		panelFecha.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblFecha = new JLabel("Fecha de Nacimiento");
		panelFecha.add(lblFecha);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panelFecha.add(panel);
		
		tfDia = new JTextField();
		tfDia.setHorizontalAlignment(SwingConstants.CENTER);
		tfDia.setColumns(2);
		panel.add(tfDia);
		
		JLabel lblBarraDivisoraDia = new JLabel("/");
		panel.add(lblBarraDivisoraDia);
		
		tfMes = new JTextField();
		tfMes.setColumns(2);
		panel.add(tfMes);
		
		JLabel lblBarraDivisoriaMes = new JLabel("/");
		panel.add(lblBarraDivisoriaMes);
		
		tfAño = new JTextField();
		tfAño.setHorizontalAlignment(SwingConstants.CENTER);
		tfAño.setColumns(2);
		panel.add(tfAño);
		
		JPanel panelBotonAceptar = new JPanel();
		panelBotonAceptar.setBackground(new Color(192, 192, 192));
		frame.getContentPane().add(panelBotonAceptar);
		panelBotonAceptar.setLayout(new GridLayout(0, 4, 0, 5));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		panel_1.setBackground(new Color(192, 192, 192));
		panelBotonAceptar.add(panel_1);
		
		JButton btnAceptar = new JButton("Aceptar");
		panelBotonAceptar.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		panelBotonAceptar.add(btnCancelar);
		
		frame.pack();
	}

}
