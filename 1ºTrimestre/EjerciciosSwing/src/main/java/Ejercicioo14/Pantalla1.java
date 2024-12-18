package Ejercicioo14;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pantalla1 extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfPantallas;
	private App app;

	public Pantalla1(App app) {
		this.app = app;
		setLayout(null);

		tfPantallas = new JTextField();
		tfPantallas.setBounds(175, 63, 86, 20);
		add(tfPantallas);
		tfPantallas.setColumns(10);

		JButton btnPantalla1 = new JButton("Pantalla 1");
		btnPantalla1.setEnabled(false);
		btnPantalla1.setBounds(46, 98, 89, 23);
		add(btnPantalla1);

		JButton btnPantalla2 = new JButton("Pantalla 2");
		btnPantalla2.setBounds(174, 98, 89, 23);
		btnPantalla2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (app.getGuardarTexto()) {
					app.setJTtexto(tfPantallas.getText());
				}
				app.lanzarPantalla2();
			}
		});
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
				int respuesta = JOptionPane.showConfirmDialog(Pantalla1.this, "¿Seguro que quiere salir?", "Aviso",
						JOptionPane.YES_NO_OPTION);
					
				if (respuesta == 0) {
					System.exit(0);
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
