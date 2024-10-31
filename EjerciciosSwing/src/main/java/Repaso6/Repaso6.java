package Repaso6;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Repaso6 {

	private JFrame frame;
	private JTextField tfCiudades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Repaso6 window = new Repaso6();
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
	public Repaso6() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ArrayList<String> listaCiudades = new ArrayList<>();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		JPanel plCiudad = new JPanel();
		FlowLayout flowLayout = (FlowLayout) plCiudad.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(plCiudad);

		tfCiudades = new JTextField();
		tfCiudades.setColumns(10);
		
		plCiudad.add(tfCiudades);
		JLabel lblNuevaCiudad = new JLabel("Nueva Ciudad");
		plCiudad.add(lblNuevaCiudad);

		JPanel plComboBox = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) plComboBox.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(plComboBox);

		JComboBox<String> cbDestinos = new JComboBox();
		plComboBox.add(cbDestinos);
		cbDestinos.setPreferredSize(new Dimension(100, 20));
		JLabel lblDestinosDispo = new JLabel("Destinos disponibles\r\n");
		plComboBox.add(lblDestinosDispo);

		KeyAdapter enterPulsado = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String ciudad = tfCiudades.getText();
					if (!ciudad.isEmpty()) {
						cbDestinos.addItem(ciudad);
						cbDestinos.setSelectedItem(null);
					}
					tfCiudades.setText("");
				}
			}
		};
		tfCiudades.addKeyListener(enterPulsado);

		frame.pack();
	}

}
