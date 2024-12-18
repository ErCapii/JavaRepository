package Pruebas.PruebasJackSon;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.util.List;


public class AlumnosXmlService {

	public void escribirXmlAlumnos(List<Alumno> lista, String pathFile) {
		try {
			File file = new File(pathFile);
			XmlMapper xmlMapper = new XmlMapper();
			Alumnos alumnos = new Alumnos();
			alumnos.setAlumnos(lista);


			xmlMapper.writeValue(file, alumnos);

			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<Alumno> leerXmlAlumnos(String pathFile) {
		try {
			File file = new File(pathFile);
			XmlMapper xmlMapper = new XmlMapper();
			Alumnos alumnos = xmlMapper.readValue(file, Alumnos.class);
			return alumnos.getAlumnos();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Alumno> leerJsonAlumnos(String pathFile) {
		try {
			File file = new File(pathFile);
			JsonMapper jsonMapper = new JsonMapper();
			Alumnos alumnos = jsonMapper.readValue(file, Alumnos.class);
			return alumnos.getAlumnos();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
