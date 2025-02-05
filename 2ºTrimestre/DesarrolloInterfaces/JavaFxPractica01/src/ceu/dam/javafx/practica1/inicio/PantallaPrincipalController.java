package ceu.dam.javafx.practica1.inicio;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class PantallaPrincipalController extends AppController {

	@FXML
	private Label lblOpcion;
	
    @FXML
    private MenuItem menuLineChart;

	@FXML
	private MenuItem menuCerrarSesion;

	@FXML
	private MenuItem menuColorPicker;

	@FXML
	private MenuItem menuComboBox;

	@FXML
	private MenuItem menuDatePicker;

	@FXML
	private MenuItem menuSalir;

	@FXML
	private MenuItem menuSlider;

	@FXML
	private BorderPane panel;
	
    @FXML
    private MenuItem menuHtmlEditor;

    @FXML
    private MenuItem menuWebView;

	@FXML
	void lanzarColorPicker(ActionEvent event) {
		
		Task<Long> task = new Task<Long>() {
			
			@Override
			protected Long call() throws Exception {
				Long x = 0L;
				for (Long i = 0L; i < 1000000000; i++) {
					x+=i;
				}
				return x;
			}
			@Override
			protected void succeeded() {
				System.out.println(getValue());
				
			}
			
			@Override
			protected void failed() {
				System.out.println(getException().getMessage());
			}
		};
		new Thread(task).start();
		
		
		
		//panel.setCenter(loadScene(FXML_COLORPICKER));
	}

	@FXML
	void lanzarComboBox(ActionEvent event) {
		panel.setCenter(loadScene(FXML_COMBOBOX));
		addParam("panel", panel);

	}

	@FXML
	void lanzarDatePicker(ActionEvent event) {
		panel.setCenter(loadScene(FXML_DATEPICKER));

	}

	@FXML
	void lanzarSlider(ActionEvent event) {
		panel.setCenter(loadScene(FXML_SLIDER));

	}

	@FXML
	void lanzarLogin(ActionEvent event) {
		changeScene(FXML_LOGIN);
	}

	@FXML
	void lanzarSalir(ActionEvent event) {
		salir();
		
	}
	
	@FXML
    void lanzarWebView(ActionEvent event) {
		panel.setCenter(loadScene(FXML_WEBVIEW));

    }
	
	@FXML
    void lanzarHtmlEditor(ActionEvent event) {
		panel.setCenter(loadScene(FXML_HTMLEDITOR));

    }

	@FXML
    void lanzarLineChart(ActionEvent event) {
		panel.setCenter(loadScene(FXML_LINECHART));
    }
}
