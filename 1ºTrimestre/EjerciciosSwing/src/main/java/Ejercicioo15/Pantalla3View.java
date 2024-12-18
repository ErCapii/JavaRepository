package Ejercicioo15;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pantalla3View extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7819758235854662421L;
	protected App appController;
	private JTextField textField;

	public Pantalla3View(App appController) {
		this.appController = appController;
		setLayout(null);
		
		JButton btnIrPantalla1 = new JButton("Ir a pantalla 1");
		btnIrPantalla1.setBounds(123, 260, 123, 21);
		add(btnIrPantalla1);
		btnIrPantalla1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appController.mostrarPantalla1(textField.getText());
			}
		});
		
		JButton btnIrAPantalla2 = new JButton("Ir a pantalla 2");
		btnIrAPantalla2.setBounds(256, 260, 123, 21);
		add(btnIrAPantalla2);
		btnIrAPantalla2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appController.mostrarPantalla2(textField.getText());
			}
		});
		JButton btnIrPantalla3 = new JButton("Ir a pantalla 3");
		btnIrPantalla3.setBounds(389, 260, 123, 21);
		add(btnIrPantalla3);
		btnIrPantalla3.setEnabled(false);
		
		textField = new JTextField();
		textField.setBounds(256, 157, 96, 19);
		add(textField);
		textField.setColumns(10);
	
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					appController.salir();
			}
		});
		btnSalir.setBounds(256, 229, 123, 21);
		add(btnSalir);
	
	
	
	}

	public void cambiarTexto(String texto) {
		textField.setText(texto);
	}
	
}