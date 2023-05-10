package ejercicios2;

import java.io.PrintStream;

import guia_1.Utils;

public class Ejercicio2g {

	/*
	 Dados los valores de dos de los ángulos interiores de un triángulo, la computadora muestra el valor del restante.

	 */
	
	public static PrintStream ps = ps = new PrintStream(System.out);;

	public static void  ejecutar() {
		int n = Math.abs(Utils.leerRInt("Ingrese el valor del numero: "));
		for(int i = 0; i<= 10; i++) {
			ps.println(n+" X "+i+" = " + n*i); 
		}
		
		
	}
	
	
	
	
	
	
	
}
