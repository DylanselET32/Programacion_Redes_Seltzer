package ejercicios2;

import java.io.PrintStream;

import guia_1.Utils;

public class Ejercicio2d {

	/*
	 Dada una temperatura en grados Fahrenheit, la computadora la muestra en grados centígrados.

		C = (F - 32) * 5/9

	 */
	
	public static PrintStream ps = ps = new PrintStream(System.out);;

	public static void  ejecutar() {
		double fah = Utils.leerDouble("Ingrese los grados Fahrenheit: ");
		double  cen= (fah - 32) * 5/9 ;
		
		ps.printf("La temperatura en grados Celsius es: %.2f\n", cen);
		
	}
	
	
	
	
	
	
	
}
