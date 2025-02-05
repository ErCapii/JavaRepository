package ceu.dam.javafx.practica1.inicio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ComboBoxController extends AppController {

	@FXML
	private Button btnImprimir;

	@FXML
	private Button btnLimpiar;

	@FXML
	private Button btnSlider;

	@FXML
	private ComboBox<String> cbNombres;

	public void initialize() {
		cbNombres.getItems().addAll("Mariflo", "Mondongo", "Pipote");

	}

	@FXML
	private AnchorPane panel;

	@FXML
	private TextField tfNombreImpreso;

	@FXML
	void imprimirNombre(ActionEvent event) {
		tfNombreImpreso.setText(cbNombres.getValue());
	}

	@FXML
	void limpiarTexto(ActionEvent event) {
		cbNombres.getSelectionModel().clearSelection();
		tfNombreImpreso.setText("");
	}

	@FXML
	void lanzarSlider(ActionEvent event) {
		BorderPane panel = (BorderPane) getParam("panel");
		panel.setCenter(loadScene(FXML_SLIDER));
	}

}
