package Ejercicioo15;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PantallaBienvenida extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7819758235854662421L;
	protected App appController;
	private JComboBox<String> comboBox;
	private JCheckBox checkboxMantener;

	
	public PantallaBienvenida(App appController) {
		this.appController = appController;
		setLayout(null);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBounds(213, 198, 123, 21);
		add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appController.entrar(comboBox.getSelectedIndex(), checkboxMantener.isSelected());
			}
		});
		
		JLabel lbBienvenida = new JLabel("BIENVENIDO/A");
		lbBienvenida.setForeground(new Color(0, 0, 255));
		lbBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		lbBienvenida.setFont(new Font("Showcard Gothic", Font.PLAIN, 24));
		lbBienvenida.setBounds(123, 117, 276, 43);
		add(lbBienvenida);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(213, 165, 123, 22);
		comboBox.addItem("Pantalla 1");
		comboBox.addItem("Pantalla 2");
		comboBox.addItem("Pantalla 3");
		add(comboBox);
		
		checkboxMantener = new JCheckBox("Copiar texto");
		checkboxMantener.setSelected(true);
		checkboxMantener.setBounds(274, 270, 170, 23);
		add(checkboxMantener);
	}
}
