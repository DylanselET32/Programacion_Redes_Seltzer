package ejercicios3;

import java.io.PrintStream;

import guia_1.Utils;

public class Ejercicio3e {

	/*
	 Dado un tiempo en segundos, la computadora lo muestra expresado en días, horas, minutos y segundos.


	 */
	
	public static PrintStream ps = ps = new PrintStream(System.out);;

	public static void  ejecutar() {
		double tiempoSegundos = Utils.leerDouble("Ingrese el valor del primer angulo: ");
		int dias = (int)(tiempoSegundos / 86400);
		int horas = (int)((tiempoSegundos % 86400) / 3600);
		int minutos = (int)(((tiempoSegundos % 86400) % 3600) / 60);
		int segundos = (int)(((tiempoSegundos % 86400) % 3600) % 60);
		
		
		ps.println("Dias: " + dias);
		ps.println("Horas: "+ horas);
		ps.println("Minutos: " + minutos);
		ps.println("Segundos: " + segundos);
	}
	
	
	
	
	
	
	
}
