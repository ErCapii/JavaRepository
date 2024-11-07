package Pruebas;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Croqueta {
    private Integer id;
    private String nombre;
    private String textura;
    private String tamaño;
    private String ingredientes;


    public Croqueta() {

    }
}
