package ejercicios2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import guia_1.Utils;

public class Ejercicio2a {


	public static PrintStream ps = ps = new PrintStream(System.out);;

	public static void  ejecutar() {
		
		ArrayList<String> apellidos= new ArrayList();
		for(int i =0;i<3; i++) {
			String apellido = Utils.leerR("Ingrese un apellido: ");
			apellidos.add(apellido);
		}
		Collections.sort(apellidos); //ordena alfabeticamente una lista
		ps.println(apellidos);
		
	}
	
	
	
	
	
	
	
}
