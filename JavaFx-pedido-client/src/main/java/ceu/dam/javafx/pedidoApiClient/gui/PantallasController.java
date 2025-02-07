package ceu.dam.javafx.pedidoApiClient.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class PantallasController extends AppController{

    @FXML
    private MenuItem menuAltaCliente;

    @FXML
    private MenuItem menuAltaPedido;

    @FXML
    private MenuItem menuBuscarPedido;

    @FXML
    private MenuItem menuEdicionCliente;

    @FXML
    private MenuItem menuSalirApp;

    @FXML
    void lanzarAltaCliente(ActionEvent event) {
    	loadScene(FXML_AlTA_CLIENTE);
    }

    @FXML
    void lanzarAltaPedidos(ActionEvent event) {
    	loadScene(FXML_AlTA_PEDIDO);
    }

    @FXML
    void lanzarBuscarPedido(ActionEvent event) {
    	loadScene(FXML_BUSCAR_PEDIDO);
    }

    @FXML
    void lanzarEdicionCliente(ActionEvent event) {
    	loadScene(FXML_EDITAR_CLIENTE);
    }

    @FXML
    void lanzarSalirApp(ActionEvent event) {

    }

}
