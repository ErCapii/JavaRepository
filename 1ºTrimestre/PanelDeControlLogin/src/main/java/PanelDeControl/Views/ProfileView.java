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
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PanelDeControl.Controller.Controller;

public class ProfileView extends View {

	private static final long serialVersionUID = 1L;
	private Controller controller;
	private JLabel lblNombreSQL = new JLabel();
	private JLabel lblEmailSQL = new JLabel();
	private JLabel lblFechaIngresoSQL = new JLabel();

	/**
	 * Create the panel.
	 */
	public ProfileView(Controller controller) {
		this.controller = controller;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 135, 174, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblPerfil = new JLabel("Perfil");
		lblPerfil.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblPerfil = new GridBagConstraints();
		gbc_lblPerfil.insets = new Insets(0, 0, 5, 0);
		gbc_lblPerfil.gridx = 2;
		gbc_lblPerfil.gridy = 0;
		add(lblPerfil, gbc_lblPerfil);

		JLabel lblNombre = new JLabel("Usuario");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		add(lblNombre, gbc_lblNombre);

		GridBagConstraints gbc_lblNombreSQL = new GridBagConstraints();
		gbc_lblNombreSQL.insets = new Insets(0, 0, 5, 0);
		gbc_lblNombreSQL.gridx = 2;
		gbc_lblNombreSQL.gridy = 2;
		add(lblNombreSQL, gbc_lblNombreSQL);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 3;
		add(lblEmail, gbc_lblEmail);

		GridBagConstraints gbc_lblEmailSQL = new GridBagConstraints();
		gbc_lblEmailSQL.insets = new Insets(0, 0, 5, 0);
		gbc_lblEmailSQL.gridx = 2;
		gbc_lblEmailSQL.gridy = 3;
		add(lblEmailSQL, gbc_lblEmailSQL);

		JLabel lblFechaDeRegistro = new JLabel("Fecha de ingreso");
		GridBagConstraints gbc_lblFechaDeRegistro = new GridBagConstraints();
		gbc_lblFechaDeRegistro.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeRegistro.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeRegistro.gridx = 1;
		gbc_lblFechaDeRegistro.gridy = 4;
		add(lblFechaDeRegistro, gbc_lblFechaDeRegistro);

		GridBagConstraints gbc_lblFechaIngresoSQL = new GridBagConstraints();
		gbc_lblFechaIngresoSQL.insets = new Insets(0, 0, 5, 0);
		gbc_lblFechaIngresoSQL.gridx = 2;
		gbc_lblFechaIngresoSQL.gridy = 4;
		add(lblFechaIngresoSQL, gbc_lblFechaIngresoSQL);

		JLabel lblContraseña = new JLabel("Contraseña");
		GridBagConstraints gbc_lblContraseña = new GridBagConstraints();
		gbc_lblContraseña.anchor = GridBagConstraints.EAST;
		gbc_lblContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_lblContraseña.gridx = 1;
		gbc_lblContraseña.gridy = 6;
		add(lblContraseña, gbc_lblContraseña);

		JButton btnCambiarContraseña = new JButton("Cambiar contraseña");
		btnCambiarContraseña.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.lanzarChangePassword();
			}
		});
		GridBagConstraints gbc_btnCambiarContraseña = new GridBagConstraints();
		gbc_btnCambiarContraseña.insets = new Insets(0, 0, 5, 0);
		gbc_btnCambiarContraseña.gridx = 2;
		gbc_btnCambiarContraseña.gridy = 6;
		add(btnCambiarContraseña, gbc_btnCambiarContraseña);

		JButton btnLogOut = new JButton("Cerrar Sesion");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.lanzarLogin();
			}
		});
		
		JButton btnImportUser = new JButton("Importar Usuario");
		btnImportUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.importUser();
			}
		});
		GridBagConstraints gbc_btnImportUser = new GridBagConstraints();
		gbc_btnImportUser.insets = new Insets(0, 0, 0, 5);
		gbc_btnImportUser.gridx = 1;
		gbc_btnImportUser.gridy = 9;
		add(btnImportUser, gbc_btnImportUser);
		GridBagConstraints gbc_btnBack = new GridBagConstraints();
		gbc_btnBack.gridx = 2;
		gbc_btnBack.gridy = 9;
		add(btnLogOut, gbc_btnBack);
	}

	public void setLblNombreSQL(String lblNombreSQL) {
		this.lblNombreSQL.setText(lblNombreSQL);
	}

	public void setLblEmailSQL(String lblEmailSQL) {
		this.lblEmailSQL.setText(lblEmailSQL);
	}

	public void setLblFechaIngresoSQL(String lblFechaIngresoSQL) {
		this.lblFechaIngresoSQL.setText(lblFechaIngresoSQL);
	}
}
