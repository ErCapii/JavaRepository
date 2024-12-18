package app.inicio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class HolaMundoController extends AppController{

    @FXML
    private TextField tfAlgo;

    @FXML
    void imprimir(ActionEvent event) {
    		System.out.println(tfAlgo.getText());
    	
    }
    
    @FXML
    void entrar(ActionEvent event) {
    		System.out.println("entrar");
    		BienvenidoController controller = (BienvenidoController) changeScene(FXML_BIENVENIDA);
    		controller.mostrarMensaje("Hola");
    		addParam("texto", tfAlgo.getText());
    }
    
    

}