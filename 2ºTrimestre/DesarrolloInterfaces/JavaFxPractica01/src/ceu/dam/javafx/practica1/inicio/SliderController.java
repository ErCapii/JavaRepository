package ceu.dam.javafx.practica1.inicio;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SliderController extends AppController{

    @FXML
    private Button btnLeerNumero;

    @FXML
    private AnchorPane panel;

    @FXML
    private Slider slBarraNumerica;

    @FXML
    private TextField tfImpresionNumero;

    @FXML
    void leeNumeroSlider(ActionEvent event) {
    
    	BigDecimal valor = new BigDecimal(slBarraNumerica.getValue());
    	valor = valor.setScale(2, RoundingMode.HALF_UP);
    	tfImpresionNumero.setText(valor.toString());
    }

}
