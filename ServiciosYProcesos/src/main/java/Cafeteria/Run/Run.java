package Cafeteria.Run;

import Cafeteria.Alumno.Alumno;
import Cafeteria.Cafeteria.Cafeteria;
import Cafeteria.Profesor.Profesor;

public class Run {
	public static void main(String[] args) {
		
		Cafeteria cafeteria = new Cafeteria();
		
		for (int i = 0; i < 100; i++) {
			Thread alumno = new Thread(new Alumno(cafeteria));
			alumno.start();
			if (i%5 == 0) {
				Thread profesor = new Thread(new Profesor(cafeteria));
				profesor.start();
			}
			
		}
	}
}
