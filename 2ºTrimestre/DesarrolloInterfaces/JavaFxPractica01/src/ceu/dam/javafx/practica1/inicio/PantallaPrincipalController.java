package ceu.dam.javafx.practica1.inicio;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class PantallaPrincipalController extends AppController{
	
	@FXML
    private BorderPane panel;

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
    void lanzarColorPicker(ActionEvent event) {
    	panel.setCenter(loadScene(FXML_COLORPICKER));
    }

    @FXML
    void lanzarComboBox(ActionEvent event) {
    	panel.setCenter(loadScene(FXML_COMBOBOX));

    }

    @FXML
    void lanzarDatePicker(ActionEvent event) {
    	panel.setCenter(loadScene(FXML_DATEPICKER));

    }

    @FXML
    void lanzarSlider(ActionEvent event) {
    	panel.setCenter(loadScene(FXML_SLIDER));

    }
    

}
