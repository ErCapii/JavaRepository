package ceu.dam.javafx.practica1.inicio;

import ceu.dam.ad.api.user.client.ApiClient;
import ceu.dam.ad.api.user.client.ApiException;
import ceu.dam.ad.api.user.client.api.UserApiApi;
import ceu.dam.ad.api.user.client.model.CreateUserRequest;
import ceu.dam.ad.api.user.client.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RegisterController extends AppController {
	
    @FXML
    private Button btnExit;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegister;

    @FXML
    private Label lblIncorrecto;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblPassword1;

    @FXML
    private Label lblUsuario;

    @FXML
    private AnchorPane panel;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfUser;

    @FXML
    private PasswordField tpPassword;

    @FXML
    void botonRegistrar(MouseEvent event) {
		try {
			CreateUserRequest userR = new CreateUserRequest();
			userR.setUsername(tfUser.getText());
			userR.setEmail(tfEmail.getText());
			userR.setPassword(new String(tpPassword.getText()));
			User user = service.crearUsario(userR);
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
    void volverLogin(ActionEvent event) {
        changeScene(FXML_LOGIN);
    }
}
