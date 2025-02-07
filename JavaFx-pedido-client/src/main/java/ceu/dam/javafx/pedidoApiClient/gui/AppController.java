package ceu.dam.javafx.pedidoApiClient.gui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.ClienteApiServiceApi;
import org.openapitools.client.api.PedidoApiServiceApi;

import ceu.dam.javafx.pedidoApiClient.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AppController {
	
	public static final String FXML_MENU= "/Menu.fxml";
	public static final String FXML_AlTA_CLIENTE = "/AltaCliente.fxml";
	public static final String FXML_EDITAR_CLIENTE = "/EditarCliente.fxml";
	public static final String FXML_AlTA_PEDIDO = "/AltaPedido.fxml";
	public static final String FXML_BUSCAR_PEDIDO = "/BuscarPedido.fxml";
	
	protected static Stage primaryStage;
	
	protected static PedidoApiServiceApi apiPedido;
	
	protected static ClienteApiServiceApi apiCliente;
	
	public AppController() {
		
	}
	
	public AppController(Stage stage){
		primaryStage = stage;
		crearClientesApi();
	}
	
	public AppController changeScene(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = new Scene(loader.load());
			primaryStage.setScene(scene);
			return loader.getController();
		}
		catch(IOException e) {
			throw new RuntimeException("Error cambiando escena.", e);
		}
	}
	
	public Parent loadScene(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = new Scene(loader.load());
			return scene.getRoot();
		}
		catch(IOException e) {
			throw new RuntimeException("Error cambiando escena.", e);
		}
	}
	
	public void addParam(String key, Object param) {
		Map<String, Object> mapa = (Map<String, Object>) primaryStage.getUserData();
		if (mapa == null) {
			mapa = new HashMap<String, Object>();
			primaryStage.setUserData(mapa);
		}
		mapa.put(key, param);
	}
	
	public Object getParam(String key) {
		Map<String, Object> mapa = (Map<String, Object>) primaryStage.getUserData();
		return mapa.get(key);
	}
	
	
	public void mostrarError(String mensaje) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setTitle("Error");
		alert.setContentText(mensaje);
		alert.showAndWait();
	}
	
	public void mostrarMensaje(String mensaje) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Confirmación");
		alert.setContentText(mensaje);
		alert.showAndWait();
	}
	
	public void crearClientesApi() {
		ApiClient client = new ApiClient();
		
		client.setBasePath("http://localhost:8080");
		
		AppController.apiCliente = new ClienteApiServiceApi(client);
		
		AppController.apiPedido = new PedidoApiServiceApi(client);
	}
 
}
