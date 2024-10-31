package Ejercicioo14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pantalla2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfPantallas;
	private App app;

	/**
	 * Create the panel.
	 */
	public Pantalla2(App app) {
		this.app = app;
		setLayout(null);

		tfPantallas = new JTextField();
		tfPantallas.setBounds(175, 63, 86, 20);
		add(tfPantallas);
		tfPantallas.setColumns(10);

		JButton btnPantalla1 = new JButton("Pantalla 1");
		btnPantalla1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (app.getGuardarTexto()) {
					app.setJTtexto(tfPantallas.getText());
				}
				app.lanzarPantalla1();
			}
		});
		btnPantalla1.setBounds(46, 98, 89, 23);
		add(btnPantalla1);

		JButton btnPantalla2 = new JButton("Pantalla 2");
		btnPantalla2.setBounds(174, 98, 89, 23);
		btnPantalla2.setEnabled(false);
		add(btnPantalla2);

		JButton btnPantalla3 = new JButton("Pantalla 3");
		btnPantalla3.setBounds(298, 98, 89, 23);
		btnPantalla3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (app.getGuardarTexto()) {
					app.setJTtexto(tfPantallas.getText());
				}
				app.lanzarPantalla3();
			}
		});
		add(btnPantalla3);
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respuesta = JOptionPane.showConfirmDialog(Pantalla2.this, "¿Seguro que quiere salir?",
						"Aviso", JOptionPane.YES_NO_OPTION);

				if (respuesta == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					//
					System.out.println("No se cerrará la aplicación");
				}
			}
		});
		btnSalir.setBounds(172, 221, 89, 23);
		add(btnSalir);
	}

	public void cambiarTexto(String texto) {
		if (app.getGuardarTexto()) {
			tfPantallas.setText(texto);
		} else {
			tfPantallas.setText("");
		}
	}

}
