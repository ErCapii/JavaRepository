package Ejercicio2ServicioClientes.Clientes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Cliente {
	
	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private Boolean activo;
	
}
