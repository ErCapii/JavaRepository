package PanelDeControl.Controller;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import PanelDeControl.Views.ChangePasswordView;
import PanelDeControl.Views.LoginView;
import PanelDeControl.Views.ProfileView;
import PanelDeControl.Views.RegisterView;
import ceu.dam.ad.ejerciciosTema3.csv.ejercicio02.Ejercicio02ServiceImp;
import ceu.dam.ad.ejerciciosTema3.csv.exceptions.CsvException;
import ejercicios.ejercicio05.model.User;
import ejercicios.ejercicio05.service.DuplicateUserException;
import ejercicios.ejercicio05.service.NoValidDataException;
import ejercicios.ejercicio05.service.UserException;
import ejercicios.ejercicio05.service.UserNotFoundException;
import ejercicios.ejercicio05.service.UserServiceImpl;
import ejercicios.ejercicio05.service.UserUnauthorizedException;

public class Controller {

	private JFrame frame;
	private ChangePasswordView changePassword;
	private LoginView login;
	private ProfileView profile;
	private RegisterView register;
	private UserServiceImpl sr;
	private User user;
	private static final Logger log = LoggerFactory.getLogger(Controller.class);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller window = new Controller();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Controller() {
		changePassword = new ChangePasswordView(this);
		login = new LoginView(this);
		profile = new ProfileView(this);
		register = new RegisterView(this);
		sr = new UserServiceImpl();
		user = new User();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(login);
	}

	public void lanzarChangePassword() {
		changePassword.iniForm();
		changePassword.setId(user.getId());
		frame.setContentPane(changePassword);
		frame.revalidate();
	}

	public void lanzarLogin() {
		login.iniForm();
		frame.setContentPane(login);
		frame.revalidate();
	}

	public void lanzarProfile() {
		profile.setLblNombreSQL(user.getUsername());
		profile.setLblEmailSQL(user.getEmail());
		profile.setLblFechaIngresoSQL(user.getCreatedDate().toString());
		frame.setContentPane(profile);
		frame.revalidate();
	}

	public void lanzarRegister() {
		register.iniForm();
		frame.setContentPane(register);
		frame.revalidate();
	}

	public void register(String name, String email, String password) {
			
		try {
			log.debug("Creando usuario");
			if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
				log.warn("Campo vacio");
				throw new NoValidDataException("El campo no puede estar vacio");
			}
			user = sr.createUser(new User(name, email, password));
			lanzarLogin();
		} catch (NoValidDataException | DuplicateUserException | UserException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void login(String username, String password) {
		
		try {
			log.debug("Iniciando sesion");

			if (username.isEmpty() || password.isEmpty()) {
				log.warn("Campo vacio");
				throw new NoValidDataException("El campo no puede estar vacio");
			}
			user = sr.login(username, password);
			lanzarProfile();
		} catch (NoValidDataException | UserNotFoundException | UserUnauthorizedException | UserException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void changePassword(String oldPass, String newPass) {
		try {
			log.debug("Cambiando password");

			if (oldPass.isEmpty() || newPass.isEmpty()) {
				log.warn("Campo vacio");
				throw new NoValidDataException("El campo no puede estar vacio");
			}
			sr.changePassword(user.getId(), oldPass, newPass);
			lanzarProfile();
		} catch (NoValidDataException | UserNotFoundException | UserUnauthorizedException | UserException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public User profile() {
		try {
			log.debug("Mostrando perfil");
			return sr.getUser(user.getId());
		} catch (UserNotFoundException | UserException e) {

		}
		return null;

	}
	
	public void importUser() {
		try {
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Selecciona un archivo");
		Integer seleccion = chooser.showOpenDialog(frame);
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichero XML", "xml", "csv");
		chooser.setFileFilter(filter);
		File fichero =null;
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			fichero = chooser.getSelectedFile();
			System.out.println(fichero.getAbsolutePath());
		}else {
			System.out.println("no va");	
			throw new CsvException("No se a encontrado el fichero");
		}
		Ejercicio02ServiceImp service = new Ejercicio02ServiceImp();
			service.importarUsuarioCSV(fichero.getAbsolutePath());
		} catch (CsvException e) {
			e.printStackTrace();
		}
		
	}

}
