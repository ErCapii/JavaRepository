package ceu.dam.javafx.practica1.inicio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class WebViewController extends AppController{

    @FXML
    private Button btnConsultar;

    @FXML
    private TextField tfUrl;

    @FXML
    private WebView webPanel;

    @FXML
    void consultarWeb(ActionEvent event) {
    	webPanel.getEngine().load(tfUrl.getText());
    }

}

