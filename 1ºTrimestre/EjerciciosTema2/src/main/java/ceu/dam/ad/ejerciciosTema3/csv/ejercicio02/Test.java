package ceu.dam.ad.ejerciciosTema3.csv.ejercicio02;

import ceu.dam.ad.ejerciciosTema3.csv.exceptions.CsvException;

public class Test {


	public static void main(String[] args) {
		Ejercicio02ServiceImp service = new Ejercicio02ServiceImp();
		try {
			service.importarUsuarioCSV("c:/temporal/users_data.csv");
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

}
