package PruebasStream.PruebaModelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Articulo {

	private String codArticulo;
	private String desArticulo;
	private Integer stock;
	private Double precio;

	/*public static Articulo createRandom() {
		Random random = new Random();
		String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Integer tamañoNombre = random.nextInt(6, 20);
		Integer codigoAleatorio = random.nextInt(1000, 9999);
		String nombreAleatorio = "";

		nombreAleatorio += Stream.generate(() -> random.nextInt(alfabeto.length())).limit(tamañoNombre)
				.map(i -> String.valueOf(alfabeto.charAt(i))).collect(Collectors.joining());
		return new Articulo(codigoAleatorio.toString(), nombreAleatorio, random.nextInt(20),
				random.nextDouble(10.0, 100.0));
	}

	public static List<Articulo> createRandomList(Integer tamaño) {

		return Stream.generate(() -> createRandom()).limit(tamaño).toList();

	}*/

}
