package app;

import app.inicio.AppController;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		AppController app = new AppController(primaryStage);
		app.changeScene(AppController.FXML_PRINCIPAL);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
	}
	

}
