package ejercicios4;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import guia_1.Utils;

public class Ejercicio4c {

	/*
	 Dada la superficie de un cuadrado (en m2), la computadora muestra su perímetro.


	 */
	
	public static PrintStream ps = ps = new PrintStream(System.out);;
	
	public static void  ejecutar() {
		List<String> dias = new ArrayList<String>(Arrays.asList("Lunes", "Martes", "Miercoles","Jueves","Viernes","Sabado","Domingo"));
		dias.set(4, "Juernes");
		List<String> listaDos = new ArrayList<String>(dias);
		ps.println("La posicion 3:"+dias.get(3));
		ps.println("La posicion 4:"+dias.get(4));
		ps.println("Primer elemento: "+dias.get(0));
		ps.println("Ultimo elemento: "+dias.get(dias.size()-1));
		
		

	}
	
	
	
	
	
	
	
}
