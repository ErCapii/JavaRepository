package PanelDeControl.Views;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import PanelDeControl.Component.JMyPasswordField;
import PanelDeControl.Component.JMyTextField;
import PanelDeControl.Controller.Controller;

public class LoginView extends View {

	private static final long serialVersionUID = 1L;
	private JMyTextField tfName;
	private JMyPasswordField tfPassword;
	private Controller controller;

	/**
	 * Create the panel.
	 */
	public LoginView(Controller controller) {
		this.controller = controller;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 138, 191, 127, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblWelcome = new JLabel("Bienvenido");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 0;
		add(lblWelcome, gbc_lblWelcome);

		JButton btnRegister = new JButton("Registrarse");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.lanzarRegister();
			}
		});

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(tfPassword.getPassword());
				controller.login(tfName.getText().toString(), pass);
			}
		});
		JLabel lblName = new JLabel("Usuario");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.WEST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 2;
		add(lblName, gbc_lblName);

		tfName = new JMyTextField();
		tfName.setLimit(50);
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.insets = new Insets(0, 0, 5, 5);
		gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfName.gridx = 1;
		gbc_tfName.gridy = 3;
		add(tfName, gbc_tfName);
		tfName.setColumns(10);
		tfName.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_DOWN) {
		            tfPassword.requestFocus();
		        }
		    }
		});


		JLabel lblPassword = new JLabel("Contraseña");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 4;
		add(lblPassword, gbc_lblPassword);

		tfPassword = new JMyPasswordField();
		GridBagConstraints gbc_pfPassword = new GridBagConstraints();
		gbc_pfPassword.insets = new Insets(0, 0, 5, 5);
		gbc_pfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfPassword.gridx = 1;
		gbc_pfPassword.gridy = 5;
		add(tfPassword, gbc_pfPassword);
		tfPassword.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		            String pass = new String(tfPassword.getPassword());
		            controller.login(tfName.getText(), pass);
		        }else if(e.getKeyCode() == KeyEvent.VK_UP) {
		        	tfName.requestFocus();
		        }
		    }
		});


		GridBagConstraints gbc_btnEnter = new GridBagConstraints();
		gbc_btnEnter.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnter.gridx = 1;
		gbc_btnEnter.gridy = 6;
		add(btnEntrar, gbc_btnEnter);
		GridBagConstraints gbcBtnRegister = new GridBagConstraints();
		gbcBtnRegister.insets = new Insets(0, 0, 5, 5);
		gbcBtnRegister.gridx = 1;
		gbcBtnRegister.gridy = 7;
		add(btnRegister, gbcBtnRegister);

	}

	@Override
	public void iniForm() {
		tfName.setText("");
		tfPassword.setText("");
		tfName.requestFocus();

	}

}
