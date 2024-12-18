package ceu.dam.javafx.practica1.inicio;

import java.io.IOException;

import ceu.dam.javafx.practica1.app.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppController {
	
	public static final String FXML_COMBOBOX = "/app/inicio/ComboBoxController.fxml";
	public static final String FXML_COLORPICKER = "/app/inicio/ColorPickerController.fxml";
	public static final String FXML_DATEPICKER = "/app/inicio/DatePickerController.fxml";
	public static final String FXML_SLIDER = "/app/inicio/SliderController.fxml";
	public static final String FXML_LOGIN = "/app/inicio/LoginController.fxml";
	
	public static Stage primaryStage;
	
	public AppController() {
		
	}
	public AppController(Stage stage) {
		AppController.primaryStage = stage;
	}
	
	public AppController changeScene(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = new Scene(loader.load());
			primaryStage.setScene(scene);
			return loader.getController();
		} catch (IOException e) {
			e.printStackTrace();   
			return null;
		}
	}
	
	public Parent loadScene(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = new Scene(loader.load());
			return scene.getRoot();
		} catch (IOException e) {
			e.printStackTrace();   
			return null;
		}
	}
}







