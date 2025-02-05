package ceu.dam.javafx.practica3.gui;

import ceu.dam.javafx.practica3.modelo.Animal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NuevosDatos extends AppController {

	@FXML
	private Button btnContinuar;

	@FXML
	private Button btnGuardar;

	@FXML
	private Label lblEdad;

	@FXML
	private Label lblNombre;

	@FXML
	private Label lblTipo;

	@FXML
	private TextField tfEdad;

	@FXML
	private TextField tfNombre;

	@FXML
	private TextField tfTipo;

	@FXML
	void guardarDatos(ActionEvent event) {

		try {
			//Pendiente el comprobar el tipo si es vacio
			String tipo = tfTipo.getText();
			String nombre = tfNombre.getText();
			Integer edad = Integer.parseInt(tfEdad.getText());
			Animal animal = new Animal(tipo, nombre, edad);
			service.addAnimal(animal);
			TablaController controller = (TablaController) changeScene(FXML_TABLA);
			controller.setTfConsultas(tipo);
			controller.consultarTabla(event);

		} catch (NumberFormatException e) {
			System.err.println("Error: La edad debe ser un número entero válido.");
		}
	}

	@FXML
	void ocultarTipo(ActionEvent event) {

		btnContinuar.setVisible(false);
		lblTipo.setVisible(false);
		tfTipo.setVisible(false);
		btnGuardar.setVisible(true);
		lblEdad.setVisible(true);
		lblNombre.setVisible(true);
		tfEdad.setVisible(true);
		tfNombre.setVisible(true);
	}

}
