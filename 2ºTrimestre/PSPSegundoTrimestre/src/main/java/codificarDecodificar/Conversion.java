package codificarDecodificar;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Conversion {

	public String decode(String s) {
		String respuesta = "error";
		respuesta = new String(Base64.getDecoder().decode(s.getBytes()));
		return respuesta;
	}

	public String encode(String s) throws UnsupportedEncodingException {
		String respuesta = "error";
		respuesta = new String(Base64.getEncoder().encode(s.getBytes()));
		return respuesta;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {

		Conversion res = new Conversion();
		String base64 = "";

		base64 = res.encode("Hola mundo");
		System.out.println(base64);

		System.out.println(res.decode(base64));

	}

}
