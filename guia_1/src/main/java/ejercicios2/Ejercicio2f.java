package ejercicios2;

import java.io.PrintStream;

import guia_1.Utils;

public class Ejercicio2f {

	/*
	 Dados los valores de dos de los ángulos interiores de un triángulo, la computadora muestra el valor del restante.

	 */
	
	public static PrintStream ps = ps = new PrintStream(System.out);;

	public static void  ejecutar() {
		double angulo1 = Utils.leerDouble("Ingrese el valor del primer angulo: ");
		double angulo2 = Utils.leerDouble("Ingrese el valor del segundo angulo: ");
		double angulo3 = 180 - angulo1 + angulo2 ;
		
		ps.println("El valor del tercer angulo es " + angulo3);
	}
	
	
	
	
	
	
	
}
