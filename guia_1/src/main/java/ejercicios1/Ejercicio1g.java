package ejercicios1;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import guia_1.Utils;

public class Ejercicio1g {

	/*
	 Dados los valores de dos de los ángulos interiores de un triángulo, la computadora muestra el valor del restante.

	 */
	
	public static PrintStream ps = ps = new PrintStream(System.out);;

	public static void  ejecutar() {
		String signo = Utils.leer("Ingrese su signo sodiacal: ");

		// Crear el ArrayList de signos zodiacales
		 ArrayList<String> signosZodiacal = new ArrayList<String>(Arrays.asList(
				 "ARIES","TAURO","GÉMINIS", "CÁNCER","LEO","VIRGO","LIBRA",
				 "ESCORPIO","SAGITARIO","CAPRICORNIO","ACUARIO","PISCIS"));
		 ArrayList<String> fechasSignos = new ArrayList<String>(Arrays.asList(
				 "Marzo 21 - Abril 19","Abril 20 - Mayo 20","Mayo 21 - Junio 20", "Junio 21 - Julio 22","Julio 23 - Agosto 22","Agosto 23 - Septiembre 22","Septiembre 23 - Octubre 22",
				 "Octubre 23 - Noviembre 21","Noviembre 22 - Diciembre 21","Diciembre 22 - Enero 19","Enero 20 - Febrero 18","Febrero 19 - Marzo 20"));
		
		for(int i = 0; i < signosZodiacal.size(); i++) {
			if(signosZodiacal.get(i).equals(signo.toUpperCase())) {
				ps.println("Tu cumpleaños aproximado es en: "+fechasSignos.get(i));
			}
		}
	}
	
	
	
	
	
	
	
}
