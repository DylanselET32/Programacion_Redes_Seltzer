package ejercicios2;

import java.io.PrintStream;
import guia_1.Utils;

public class Ejercicio2c {

	/*
	 Dada la superficie de un cuadrado (en m2), la computadora muestra su perímetro.


	 */
	
	public static PrintStream ps = ps = new PrintStream(System.out);;

	public static void  ejecutar() {
		double superficie = Utils.leerDouble("Ingrese la superficie del cuadrado: ");
		double perimetro = (Math.sqrt(superficie)) *4;
		
		ps.println("El valor del perimetro es " + perimetro);

	}
	
	
	
	
	
	
	
}
