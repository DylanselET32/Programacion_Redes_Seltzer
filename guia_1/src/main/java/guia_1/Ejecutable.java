package guia_1;

import java.io.IOException;
import java.io.PrintStream;
import guia_1.Utils;
import ejercicios1.*;


public class Ejecutable {
	
	public static PrintStream ps ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ps = new PrintStream(System.out);
		menu();
		
		
		
		
		
		
		
		
		
	}
	
	public static void menu() {
			ps.println("1 - Ejercicio 1");
			ps.println("2 - Ejercicio 2");
			ps.println("3 - Ejercicio 3");
			ps.println("4 - Ejercicio 4");
			ps.println("5 - Ejercicio 5");
			ps.println("6 - Ejercicio 6");
			ps.println("7 - Ejercicio 7");
			ps.println("0 - Salir ");
		int opcion = Utils.leerInt("Elija una opcion: ");
		switch (opcion) {
		case 1:
			Ejercicio1a.ejecutar();
			break;
		case 2:
			Ejercicio1a.ejecutar();
			break;
		case 3:
			Ejercicio1a.ejecutar();
			break;
		case 4:
			Ejercicio1a.ejecutar();
			break;
		case 5:
			Ejercicio1a.ejecutar();
			break;
		case 6:
			Ejercicio1a.ejecutar();
			break;
		case 7:
			Ejercicio1a.ejecutar();
			break;
		
		}
		
	}
	
	

}
