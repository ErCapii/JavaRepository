
package ceu.dam.javafx.practica1.inicio;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

public class LoginController {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LoginService ls = new LoginService();

    @FXML
    private Button btnExit;

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
    private CheckBox ckbModoOscuro;
    
    @FXML
    private AnchorPane panel;

    @FXML
    void btnEntrar(MouseEvent event) {
    	try {
			Usuario user = ls.login(tfUser.getText().toString(), new String(tpPassword.getText()));
			lblIncorrecto.setVisible(true);
			lblIncorrecto.setText(user.getNombre());
		} catch (LoginDenegadoException e) {
			lblIncorrecto.setVisible(true);
			lblIncorrecto.setText(e.getMessage());
		}
    }

    @FXML
    void btnSalir(MouseEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void modoOscuro(ActionEvent event) {
        if (ckbModoOscuro.isSelected()) {
        	panel.getStylesheets().add("/app/inicio/LoginModoOscuro.css");
        } else {
        	panel.getStylesheets().clear();
        	panel.getStylesheets().add("/app/inicio/login.css");
        }

    }

}


