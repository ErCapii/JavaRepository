package ceu.dam.javafx.practica1.inicio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.LocalDateStringConverter;

public class DatePickerController extends AppController{
	DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
    @FXML
    private Button btnLeer;

    @FXML
    private DatePicker dpFechaSeleccionada;
   
    public void initialize() {
        dpFechaSeleccionada.setValue(LocalDate.now());
        //Sirve para formatear la fecha del datePicker, los parametros son para pasar una fecha a string y un string a una fecha
        dpFechaSeleccionada.setConverter(new LocalDateStringConverter(formatoFecha,formatoFecha));
    }
    
    @FXML
    private AnchorPane panel;

    @FXML
    private TextField tfFechaImpresa;

    @FXML
    void leerFecha(ActionEvent event) {
    	LocalDate fecha = dpFechaSeleccionada.getValue();
    	tfFechaImpresa.setText(fecha.format(formatoFecha));
    }

}