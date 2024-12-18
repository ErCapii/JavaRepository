package Test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvService {

	public List<Gato> leerCsv(String pathFile) throws CsvGatosException {
		try {
			List<Gato> lista = new ArrayList<Gato>();
			File fichero = new File(pathFile);
			Scanner sc = new Scanner(fichero);
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String[] trozos = linea.split(";");
				Gato g = new Gato();
				g.setId(Integer.parseInt(trozos[0].trim()));
				g.setNombre(trozos[1].trim());
				g.setRaza(trozos[2].trim());
				lista.add(g);
			}
			sc.close();
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CsvGatosException();
		}
	}


	public void escribirCsv(List<Gato> gatos, String pathFile) throws CsvGatosException {
		try {

			File fichero = new File(pathFile);
			FileWriter writer = new FileWriter(fichero);
			for (Gato gato : gatos) {
				writer.write(gato.getId() + "|");
				writer.write(gato.getNombre() + "|");
				writer.write(gato.getRaza() + "|");

			}
			writer.close();

		}catch (Exception e) {
			throw new CsvGatosException();
		}
	}
}
