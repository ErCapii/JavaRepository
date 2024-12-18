package ejemplos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private AppEjemplos app;

	/**
	 * Create the panel.
	 */
	public LoginPanel(AppEjemplos app) {
		this.app = app;
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(108, 15, 32, 14);
		add(lblLogin);
		
		JButton JbEntrar = new JButton("Enter");
		JbEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				app.abrirBienvenida();
			}
		});
		JbEntrar.setBounds(10, 11, 89, 23);
		add(JbEntrar);
		
		JLabel lblNewLabel = new JLabel("ja");
		lblNewLabel.setBounds(10, 46, 46, 14);
		add(lblNewLabel);

	}
}
