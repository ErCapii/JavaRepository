package ceu.dam.javafx.practica1.inicio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.web.HTMLEditor;

public class HtmlEditorController extends AppController{

    @FXML
    private Button btnLeer;

    @FXML
    private HTMLEditor htmlComponente;

    @FXML
    private TextArea tfaHtlmImpreso;

    @FXML
    void leerHtml(ActionEvent event) {
    	tfaHtlmImpreso.setText(htmlComponente.getHtmlText());
    }

}
