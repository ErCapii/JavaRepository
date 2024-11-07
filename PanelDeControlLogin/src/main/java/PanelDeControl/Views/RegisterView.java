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
import javax.swing.JPanel;
import javax.swing.JTextField;

import PanelDeControl.Component.JMyPasswordField;
import PanelDeControl.Component.JMyTextField;
import PanelDeControl.Controller.Controller;
import ejercicios.ejercicio05.service.DuplicateUserException;
import ejercicios.ejercicio05.service.UserException;
import javax.swing.JPasswordField;

public class RegisterView extends View {

	private static final long serialVersionUID = 1L;
	private JMyTextField tfName;
	private JMyTextField tfEmail;
	private Controller controller;
	private JMyPasswordField pfPassword;

	public void setTfName(JMyTextField tfName) {
		this.tfName = tfName;
	}

	public void setTfEmail(JMyTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public void setPfPassword(JMyPasswordField pfPassword) {
		this.pfPassword = pfPassword;
	}


	public RegisterView(Controller controller) {
		this.controller = controller;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 93, 251, 110, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblRegister = new JLabel("Registro");
		lblRegister.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbcLblRegister = new GridBagConstraints();
		gbcLblRegister.insets = new Insets(0, 0, 5, 5);
		gbcLblRegister.gridx = 2;
		gbcLblRegister.gridy = 0;
		add(lblRegister, gbcLblRegister);

		JLabel lblName = new JLabel("Usuario");
		GridBagConstraints gbcLblName = new GridBagConstraints();
		gbcLblName.anchor = GridBagConstraints.EAST;
		gbcLblName.insets = new Insets(0, 0, 5, 5);
		gbcLblName.gridx = 1;
		gbcLblName.gridy = 2;
		add(lblName, gbcLblName);

		tfName = new JMyTextField();
		tfName.setLimit(50);
		GridBagConstraints gbcTfName = new GridBagConstraints();
		gbcTfName.fill = GridBagConstraints.HORIZONTAL;
		gbcTfName.insets = new Insets(0, 0, 5, 5);
		gbcTfName.gridx = 2;
		gbcTfName.gridy = 2;
		add(tfName, gbcTfName);
		tfName.setColumns(10);
		tfName.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_DOWN) {
		            tfEmail.requestFocus();
		        }
		    }
		});

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbcLblEmail = new GridBagConstraints();
		gbcLblEmail.anchor = GridBagConstraints.EAST;
		gbcLblEmail.insets = new Insets(0, 0, 5, 5);
		gbcLblEmail.gridx = 1;
		gbcLblEmail.gridy = 3;
		add(lblEmail, gbcLblEmail);

		tfEmail = new JMyTextField();
		tfEmail.setLimit(50);
		GridBagConstraints gbcTfEmail = new GridBagConstraints();
		gbcTfEmail.insets = new Insets(0, 0, 5, 5);
		gbcTfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbcTfEmail.gridx = 2;
		gbcTfEmail.gridy = 3;
		add(tfEmail, gbcTfEmail);
		tfEmail.setColumns(10);
		tfEmail.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_DOWN) {
		            pfPassword.requestFocus();
		        }else if(e.getKeyCode() == KeyEvent.VK_UP) {
		        	tfName.requestFocus();
		        }
		    }
		});

		JLabel lblPassword = new JLabel("Contraseña");
		GridBagConstraints gbclblPassword = new GridBagConstraints();
		gbclblPassword.anchor = GridBagConstraints.EAST;
		gbclblPassword.insets = new Insets(0, 0, 5, 5);
		gbclblPassword.gridx = 1;
		gbclblPassword.gridy = 4;
		add(lblPassword, gbclblPassword);

		JButton btnEnter = new JButton("Registrar");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(pfPassword.getPassword());
				controller.register(tfName.getText().toString(), tfEmail.getText().toString(), pass);
			}
		});
		btnEnter.addKeyListener(new KeyAdapter(){
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		        	String pass = new String(pfPassword.getPassword());
					controller.register(tfName.getText().toString(), tfEmail.getText().toString(), pass);
		        }
		    }
		});

		pfPassword = new JMyPasswordField();
		GridBagConstraints gbc_pfPassword = new GridBagConstraints();
		gbc_pfPassword.insets = new Insets(0, 0, 5, 5);
		gbc_pfPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfPassword.gridx = 2;
		gbc_pfPassword.gridy = 4;
		add(pfPassword, gbc_pfPassword);
		pfPassword.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		        	String pass = new String(pfPassword.getPassword());
					controller.register(tfName.getText().toString(), tfEmail.getText().toString(), pass);
		        }else if(e.getKeyCode() == KeyEvent.VK_UP) {
		        	tfEmail.requestFocus();
		        }
		    }
		});
		GridBagConstraints gbcBtnEnter = new GridBagConstraints();
		gbcBtnEnter.insets = new Insets(0, 0, 5, 5);
		gbcBtnEnter.gridx = 2;
		gbcBtnEnter.gridy = 5;
		add(btnEnter, gbcBtnEnter);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.lanzarLogin();
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 6;
		add(btnAtras, gbc_btnBack);
	}

	
	public void iniForm() {
			tfEmail.setText("");
			tfName.setText("");
			pfPassword.setText("");
			tfName.requestFocus();
		}

}
