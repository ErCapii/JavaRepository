package ceu.dam.javafx.practica1.inicio;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

public class LineChartController {

    @FXML
    private LineChart<Integer, Integer> lineChart;
    
    @FXML
    private void inicialize() {
	lineChart.setTitle("Ejemplo");
	Random rd = new Random();
	
	Series<Integer, Integer> serie1 = lineChart.getData().get(0);
	serie1.getData().clear();
	for (int x = 1; x < 10; x++) {
		Integer y = rd.nextInt(10,80);
		serie1.getData().add(new Data<>(x,y));
	}
	Series<Integer, Integer> serie2 = lineChart.getData().get(0);
	serie2.getData().clear();
	for (int x = 1; x < 10; x++) {
		Integer y = rd.nextInt(10,80);
		serie2.getData().add(new Data<>(x,y));
	}

	} 

}
