package app.inicio;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import app.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppController {

	public static final String FXML_BIENVENIDA = "/app/inicio/Bienvenida.fxml";
	public static final String FXML_HOLA_MUNDO = "/app/inicio/HolaMundo.fxml";
	public static final String FXML_PRINCIPAL = "/app/inicio/principal.fxml";
	public static final String FXML_TABLA = "/app/inicio/Tabla.fxml";
	
	protected static Stage primaryStage;
	
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
}
