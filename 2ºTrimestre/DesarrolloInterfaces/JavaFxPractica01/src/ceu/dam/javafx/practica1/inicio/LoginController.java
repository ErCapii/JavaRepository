
package ceu.dam.javafx.practica1.inicio;

import java.time.format.DateTimeFormatter;

import ceu.dam.ad.api.user.client.ApiClient;
import ceu.dam.ad.api.user.client.ApiException;
import ceu.dam.ad.api.user.client.api.UserApiApi;
import ceu.dam.ad.api.user.client.model.User;
import ceu.dam.javafx.practica1.modelo.Usuario;
import ceu.dam.javafx.practica1.services.LoginDenegadoException;
import ceu.dam.javafx.practica1.services.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class LoginController extends AppController {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LoginService ls = new LoginService();

	@FXML
	private Button btnExit;

	@FXML
	private Button btnRegister;

	@FXML
	private Button btnLogin;

	@FXML
	private Label lblPassword;

	@FXML
	private Label lblUsuario;

	@FXML
	private Label lblIncorrecto;

	@FXML
	private TextField tfUser;

	@FXML
	private PasswordField tpPassword;

	@FXML
	private AnchorPane panel;

	@FXML
	void btnEntrar(MouseEvent event) throws LoginDenegadoException {
		try {
			User user = service.inicarSesion(tfUser.getText(),tpPassword.getText());
			if (user != null) {
				changeScene(FXML_MAIN);
			}
		} catch (ApiException e) {
			System.out.println(e.getCode());
			System.out.println(e.getLocalizedMessage());
			if(e.getCode() == 0) {
				error("down");
			}else {
				error(e.getResponseBody());
				
			}
			
		}

	}

	@FXML
	void btnSalir(MouseEvent event) {
		salir();
	}

	@FXML
	void lanzarRegister(ActionEvent event) {
		changeScene(FXML_REGISTER);
	}

}
