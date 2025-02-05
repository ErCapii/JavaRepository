package app.inicio;

import java.util.List;

import app.model.Gato;
import app.service.GatoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TablaController {

    @FXML
    private TableView<Gato> tablaGatos;

    @FXML
    private TableColumn<Gato, Integer> columnaEdad;

    @FXML
    private TableColumn<Gato, String> columnaNombre;

    @FXML
    private TableColumn<Gato, String> columnaRaza;
    
    private ObservableList<Gato> datosTabla;
    private GatoService service;
    @FXML
    private void initialize() {
    	service = new GatoService();
    	columnaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
    	columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	columnaRaza.setCellValueFactory(new PropertyValueFactory<>("raza"));
    	
    	datosTabla= FXCollections.observableArrayList();
    	tablaGatos.setItems(datosTabla);
	}
    
    @FXML
    public void buscarGatos(ActionEvent event) {

    	List<Gato> listaGatos = service.consultarGatos();
    	datosTabla.addAll(listaGatos);
    }

}
