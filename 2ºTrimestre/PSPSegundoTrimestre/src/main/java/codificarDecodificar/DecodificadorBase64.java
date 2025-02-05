package codificarDecodificar;

import java.util.Base64;
import java.util.Scanner;

public class DecodificadorBase64 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime el texto a codificar");
		String textoSin = sc.nextLine();
		//Codificar texto
		byte[] decodeBytes = Base64.getEncoder().encode(textoSin.getBytes());
		String decodeString = new String(decodeBytes);
		System.out.println("El resultado codifciado es " + decodeString);
		//Decodificar texto
		String textoDecode = new String( Base64.getDecoder().decode(decodeBytes));
		System.out.println("Vuelta al norma " + textoDecode);
		sc.close();
	}

}
