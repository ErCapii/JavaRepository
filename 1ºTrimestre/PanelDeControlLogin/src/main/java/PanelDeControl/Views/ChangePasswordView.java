package PanelDeControl.Views;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import PanelDeControl.Component.JMyPasswordField;
import PanelDeControl.Controller.Controller;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class ChangePasswordView extends View {

	private static final long serialVersionUID = 1L;
	private Controller controller;
	private JMyPasswordField pfOldPass;
	private Long id;
	private JPasswordField pfNewPass;

	/**
	 * Create the panel.
	 */
	public ChangePasswordView(Controller controller) {
		this.controller = controller;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 118, 219, 119, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblTitle = new JLabel("Cambiar Contraseña");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 19));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 0;
		add(lblTitle, gbc_lblTitle);

		JLabel lblOldPass = new JLabel("Antigua Contraseña");
		GridBagConstraints gbc_lblOldPass = new GridBagConstraints();
		gbc_lblOldPass.anchor = GridBagConstraints.EAST;
		gbc_lblOldPass.insets = new Insets(0, 0, 5, 5);
		gbc_lblOldPass.gridx = 0;
		gbc_lblOldPass.gridy = 2;
		add(lblOldPass, gbc_lblOldPass);

		pfOldPass = new JMyPasswordField();
		GridBagConstraints gbc_pfOldPass = new GridBagConstraints();
		gbc_pfOldPass.insets = new Insets(0, 0, 5, 5);
		gbc_pfOldPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfOldPass.gridx = 1;
		gbc_pfOldPass.gridy = 2;
		add(pfOldPass, gbc_pfOldPass);
		pfOldPass.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_TAB || e.getKeyCode() == KeyEvent.VK_DOWN) {
		        	pfNewPass.requestFocus();
		        }
		    }
		});

		JLabel lblNewPass = new JLabel("Nueva Contraseña");
		GridBagConstraints gbc_lblNewPass = new GridBagConstraints();
		gbc_lblNewPass.anchor = GridBagConstraints.EAST;
		gbc_lblNewPass.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewPass.gridx = 0;
		gbc_lblNewPass.gridy = 3;
		add(lblNewPass, gbc_lblNewPass);

		pfNewPass = new JMyPasswordField();
		GridBagConstraints gbc_pfNewPass = new GridBagConstraints();
		gbc_pfNewPass.insets = new Insets(0, 0, 5, 5);
		gbc_pfNewPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfNewPass.gridx = 1;
		gbc_pfNewPass.gridy = 3;
		add(pfNewPass, gbc_pfNewPass);
		pfNewPass.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		        	String oldPass = new String(pfOldPass.getPassword());
					String newPass = new String(pfNewPass.getPassword());
					controller.changePassword(oldPass, newPass);
		        }
		    }
		});

		JButton btnConfirm = new JButton("Aceptar");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldPass = new String(pfOldPass.getPassword());
				String newPass = new String(pfNewPass.getPassword());
				controller.changePassword(oldPass, newPass);
			}
		});
		GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
		gbc_btnConfirm.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirm.gridx = 1;
		gbc_btnConfirm.gridy = 4;
		add(btnConfirm, gbc_btnConfirm);

		JButton btnBack = new JButton("Atras");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.lanzarProfile();
			}
		});
		btnBack.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					controller.lanzarProfile();
				}
			}
		});
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.insets = new Insets(0, 0, 0, 5);
		gbc_btnBack.gridx = 0;
		gbc_btnBack.gridy = 9;
		add(btnBack, gbc_btnBack);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void iniForm() {
		pfOldPass.setText("");
		pfNewPass.setText("");
		pfOldPass.requestFocus();
	}

}
