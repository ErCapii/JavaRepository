package ceu.dam.ad.tema3.ejercicios.ejercicio04bien.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ceu.dam.ad.tema3.ejercicios.ejercicio04bien.modelo.PedidoB;
import ceu.dam.ad.tema3.ejercicios.ejercicio04bien.modelo.PedidoLineaB;
import ceu.dam.ad.tema3.ejercicios.ejercicio04bien.service.PedidoException;
import ceu.dam.ad.tema3.ejercicios.ejercicio04bien.service.PedidoNotFoundException;
import ceu.dam.ad.tema3.ejercicios.ejercicio04bien.service.PedidosServiceB;


@Component
public class TestEj4Bien {
    @Autowired
    private PedidosServiceB service;

    public void test() {
        PedidoB pedido = new PedidoB();
        pedido.setFechaPedido(LocalDate.now());
        pedido.setFechaEntrega(LocalDate.of(2024, 12, 1));
        pedido.setCliente("Lucas Cangrejo");
        pedido.setLineas(new ArrayList<PedidoLineaB>());

        for (int j = 1; j <= 3; j++) {
            PedidoLineaB linea = new PedidoLineaB();
            linea.setArticulo("Artículo " + j);
            linea.setNumLinea(j);
            linea.setPrecio(new BigDecimal(938));
            linea.setPedido(pedido);
            pedido.getLineas().add(linea);
        }

        try {
            Long idPedido = service.crearPedido(pedido);
            System.out.println("Pedido registrado con id: " + idPedido);

            PedidoB consultado = service.consultarPedido(idPedido);
            System.out.println(consultado);
        } catch (PedidoException e) {
            e.printStackTrace();
        } catch (PedidoNotFoundException e) {
            System.out.println(e);
        }
    }
}

