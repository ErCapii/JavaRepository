package Ejercicio3PagosClientes.Pago;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Data;

@Data
public class Pago {

	private BigDecimal importe;
	private Date fecha;
	
}
