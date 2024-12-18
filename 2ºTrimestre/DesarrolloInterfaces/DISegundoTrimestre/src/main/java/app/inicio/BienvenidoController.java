package app.inicio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class BienvenidoController extends AppController{
		@FXML
	    void salir(ActionEvent event) {
			System.out.println("salir");
			changeScene(FXML_HOLA_MUNDO);
			System.out.println(getParam("texto"));
	    }
		@FXML
		public void initialize() {
			System.out.println("Inicializando pantalla bienvenida...");
		}
		
		public void mostrarMensaje(String mensaje) {
	    	System.out.println(mensaje);
	    }
}
