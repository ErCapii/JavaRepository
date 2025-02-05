package ceu.dam.javafx.practica3.gui;

import java.util.List;

import ceu.dam.javafx.practica3.modelo.Animal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TablaController extends AppController {

	@FXML
	private ProgressBar barraTarea;

	@FXML
	private Button btnConsultar;

	@FXML
	private Button btnNuevo;

	@FXML
	private TableView<Animal> tablaDatos;

	@FXML
	private TableColumn<Animal, Integer> columnaEdad;

	@FXML
	private TableColumn<Animal, String> columnaNombre;

	@FXML
	private TableColumn<Animal, String> columnaTipo;

	private ObservableList<Animal> datos;

	@FXML
	private TextField tfConsultas;

	public TextField getTfConsultas() {
		return tfConsultas;
	}

	public void setTfConsultas(String tfConsultas) {
		this.tfConsultas.setText(tfConsultas);
	}

	@FXML
	public void initialize() {
		columnaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
		columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columnaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

		datos = FXCollections.observableArrayList();
		tablaDatos.setItems(datos);
	}

	@FXML
	void consultarTabla(ActionEvent event) {

		Task<List<Animal>> tarea = new Task<List<Animal>>() {

			@Override
			protected List<Animal> call() throws Exception {
				List<Animal> resultados = service.consultarAnimales(tfConsultas.getText());
				return resultados;
			}

			@Override
			protected void succeeded() {
				datos.setAll(getValue());
				updateProgress(1, 1);

			}

			@Override
			protected void failed() {
				datos.clear();
				updateProgress(0, 0);
				System.out.println(getException().getMessage());
			}
		};
		new Thread(tarea).start();
		barraTarea.progressProperty().bind(tarea.progressProperty());
	}

	@FXML
	void crearNuevoDato(ActionEvent event) {

		changeScene(FXML_INTRODUCIRDATOS);
	}

}
