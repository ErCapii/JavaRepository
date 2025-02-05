package ceu.dam.javafx.practica1.inicio;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ceu.dam.ad.api.user.client.ApiClient;
import ceu.dam.ad.api.user.client.api.UserApiApi;
import ceu.dam.javafx.practica1.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppController {
	
	public static final String FXML_COMBOBOX = "/inicio/Combobox.fxml";
	public static final String FXML_COLORPICKER = "/inicio/Colorpicker.fxml";
	public static final String FXML_DATEPICKER = "/inicio/Datepicker.fxml";
	public static final String FXML_SLIDER = "/inicio/Slider.fxml";
	public static final String FXML_LOGIN = "/inicio/login.fxml";
	public static final String FXML_MAIN = "/inicio/PantallaPrincipal.fxml";
	public static final String FXML_WEBVIEW = "/inicio/WebView.fxml";
	public static final String FXML_HTMLEDITOR = "/inicio/HtmlEditor.fxml";
	public static final String FXML_LINECHART = "/inicio/LineChart.fxml";
	public static final String FXML_REGISTER = "/inicio/Register.fxml";
	public UserApiApi service;
	public static Stage primaryStage;
	
	public AppController() {
		
	}
	public void initialize() {
		ApiClient client = new ApiClient();
		client.setBasePath("http://localhost:8080");
		client.setApiKey("quistian");
		service = new UserApiApi(client);
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
	
	public void addParam(String key, Object param) {
		Map<String, Object> mapa = (Map<String, Object>) primaryStage.getUserData();
		if(mapa == null) {
			mapa = new HashMap<String, Object>();
			primaryStage.setUserData(mapa);
		}
		mapa.put(key, param);
	}
	
	public Object getParam(String key) {
		Map<String, Object> mapa = (Map<String, Object>) primaryStage.getUserData();
		return mapa.get(key);
	}
	
	public void salir() {
		Alert alerta = new Alert(AlertType.CONFIRMATION);
		alerta.setTitle("Confirmar salida");
		alerta.setHeaderText(null);
		alerta.setContentText("¿Estas seguro que quieres cerrar la aplicacion?");

		ButtonType respuesta = alerta.showAndWait().orElse(ButtonType.CANCEL);

		if (respuesta == ButtonType.OK) {
			System.exit(0);
		}
	}
	public void error(String error) {
		Alert alerta = new Alert(AlertType.ERROR);
		alerta.setTitle("Error:");
		alerta.setHeaderText(null);
		String serverStatus = "down";
		if(serverStatus.equals(error)) {
			alerta.setContentText("Servidor no responde");
		}else {
			alerta.setContentText(error);			
		}
		
		ButtonType respuesta = alerta.showAndWait().orElse(ButtonType.CANCEL);
	}
	
	
}







