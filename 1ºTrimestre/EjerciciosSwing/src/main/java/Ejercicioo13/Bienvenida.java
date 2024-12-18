package Ejercicioo13;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Bienvenida extends JPanel {

	private static final long serialVersionUID = 1L;
	private App app;
	private String[] pantallas = new String[] {"Pantalla 1", "Pantalla 2", "Pantalla 3"};

	/**
	 * Create the panel.
	 */
	public Bienvenida(App app) {
		this.app = app;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a mi aplicación");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(10, 11, 430, 94);
		add(lblNewLabel);
		JComboBox<String> cbPantallas = new JComboBox<String>(pantallas);
		cbPantallas.setPreferredSize(new Dimension(100, 20));
		cbPantallas.setBounds(183, 108, 89, 22);
		add(cbPantallas);
		
		JButton btnEntrar = new JButton("entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (cbPantallas.getSelectedItem().toString()) {
				case "Pantalla 1":
					app.lanzarPantalla1();
					break;
				case "Pantalla 2":
					app.lanzarPantalla2();
					break;
				case "Pantalla 3":
					app.lanzarPantalla3();
					break;
				default:
					break;
				}
				
			}
		});
		btnEntrar.setBounds(183, 154, 89, 23);
		add(btnEntrar);
		
		

	}
}
