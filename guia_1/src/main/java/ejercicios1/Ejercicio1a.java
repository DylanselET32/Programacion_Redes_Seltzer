package ejercicios1;

import java.io.PrintStream;

import guia_1.Utils;

public class Ejercicio1a {

	/*
	 Dados el valor de una hora de trabajo y la cantidad de horas trabajadas,
	  la computadora muestra el valor del sueldo bruto.
	 */
	
	public static PrintStream ps = ps = new PrintStream(System.out);;

	public static void  ejecutar() {
		int horas;
		double valorHora = 0;
		
		valorHora = Utils.leerDouble("Ingrese el valor por hora: ");
		horas = Utils.leerInt("Ingrese las horas trabajadas: ");
		double valorBruto = valorHora * horas; 
		ps.print(valorBruto);
	}
	
	
	
	
	
	
	
}
