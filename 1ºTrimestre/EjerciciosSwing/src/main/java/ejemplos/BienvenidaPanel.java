package ejemplos;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BienvenidaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private AppEjemplos app;

	/**
	 * Create the panel.
	 */
	public BienvenidaPanel(AppEjemplos app) {
		this.app = app;
		setLayout(null);
		
		JLabel lblwelcome = new JLabel("welcome");
		lblwelcome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblwelcome.setBounds(38, 98, 237, 82);
		add(lblwelcome);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.abrirLogin();
			}
		});
		btnSalir.setBounds(10, 11, 89, 23);
		add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("ja");
		lblNewLabel.setBounds(20, 45, 46, 14);
		add(lblNewLabel);

	}

}
