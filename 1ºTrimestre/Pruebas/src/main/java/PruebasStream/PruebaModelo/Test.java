package PruebasStream.PruebaModelo;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		/*
		List<Articulo> articulos = Articulo.createRandomList(20);
		System.out.println(articulos);

		List<Articulo> artStockMay10 = articulos.stream().filter(a -> a.getStock() > 10).toList();
		Long cantidad = articulos.stream().filter(a -> a.getStock() > 10).count();
		List<String> codigos = articulos.stream().filter(a -> a.getStock() > 10).map(a -> a.getCodArticulo()).sorted()// PARA ORDENAR
																											.toList();
			
		Articulo art = articulos.stream().filter(a -> a.getStock() > 10)
				.sorted((a1, a2) -> a1.getPrecio().compareTo(a2.getPrecio()))// PARA ORDENAR
				.findFirst().orElse(null);// o .get()

		if (articulos.stream().anyMatch(a -> a.getStock() > 10)) {
			// Alguno cumple la funcion
			System.out.println("Existe algun articulo con stock mayor a 10");
		}
		if (articulos.stream().allMatch(a -> a.getStock() > 10)) {
			System.out.println("Todos los articulos tienen stock mayor a 10");
		}

		Articulo x = articulos.stream().filter(a -> a.getStock() > 10)
				.max((a1, a2) -> a2.getPrecio().compareTo(a1.getPrecio())).get();
		articulos.forEach(a -> a.setPrecio(0.));// el 0. o 0.0 o 0D es para indicar un double
		articulos.forEach(a -> System.out.println(a));

		System.out.println(artStockMay10);
		System.out.println(cantidad);
		System.out.println(codigos);
		System.out.println(art);
	}

		 */
}}