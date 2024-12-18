package Ejercicioo12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pantalla3 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfPantallas;
	private App app;

	/**
	 * Create the panel.
	 */
	public Pantalla3(App app) {
		this.app = app;
		setLayout(null);

		tfPantallas = new JTextField();
		cambiarTexto(app.getJTtexto());
		tfPantallas.setBounds(175, 63, 86, 20);
		add(tfPantallas);
		tfPantallas.setColumns(10);

		JButton btnPantalla1 = new JButton("Pantalla 1");
		btnPantalla1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.setJTtexto(tfPantallas.getText());
				app.lanzarPantalla1();
			}
		});
		btnPantalla1.setBounds(46, 98, 89, 23);
		add(btnPantalla1);

		JButton btnPantalla2 = new JButton("Pantalla 2");
		btnPantalla2.setBounds(174, 98, 89, 23);
		btnPantalla2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.setJTtexto(tfPantallas.getText());
				app.lanzarPantalla2();
			}
		});
		add(btnPantalla2);

		JButton btnPantalla3 = new JButton("Pantalla 3");
		btnPantalla3.setBounds(298, 98, 89, 23);
		btnPantalla3.setEnabled(false);
		add(btnPantalla3);

	}
	public void cambiarTexto(String texto) {
		tfPantallas.setText(texto);
	}
}