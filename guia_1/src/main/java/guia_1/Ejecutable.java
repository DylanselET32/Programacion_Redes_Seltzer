package guia_1;

import java.io.IOException;
import java.io.PrintStream;
import guia_1.Utils;
import ejercicios1.*;
import ejercicios2.*;
import ejercicios3.*;
import ejercicios4.*;


public class Ejecutable {
	
	public static PrintStream ps ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ps = new PrintStream(System.out);
		menu();
		
		
		
		
		
		
		
		
		
	}
	public static void menuEjercicio1() {
		ps.println("1 - Ejercicio A");
		ps.println("2 - Ejercicio B");
		ps.println("3 - Ejercicio C");
		ps.println("4 - Ejercicio D");
		ps.println("5 - Ejercicio E");
		ps.println("6 - Ejercicio F");
		ps.println("7 - Ejercicio G");
		ps.println("0 - Salir ");
		int opcion = Utils.leerInt("Elija una opcion: ");
		switch (opcion) {
		case 1: Ejercicio1a.ejecutar();break;
		case 2: Ejercicio1b.ejecutar();break;
		case 3: Ejercicio1c.ejecutar();break;
		case 4: Ejercicio1d.ejecutar();break;
		case 5: Ejercicio1e.ejecutar();break;
		case 6: Ejercicio1f.ejecutar();break;
		case 7: Ejercicio1g.ejecutar();break;
		case 0: menu();break;
		default: ps.println("Opcion Invalida");break;
		}
		menuEjercicio1();
		}
	
	public static void menuEjercicio2() {
		ps.println("1 - Ejercicio A");
		ps.println("2 - Ejercicio B");
		ps.println("3 - Ejercicio C");
		ps.println("4 - Ejercicio D");
		ps.println("5 - Ejercicio E");
		ps.println("6 - Ejercicio F");
		ps.println("7 - Ejercicio G");
		ps.println("8 - Ejercicio H");
		ps.println("0 - Salir ");
		int opcion = Utils.leerInt("Elija una opcion: ");
		switch (opcion) {
		case 1: Ejercicio2a.ejecutar();break;
		case 2: Ejercicio2b.ejecutar();break;
		case 3: Ejercicio2c.ejecutar();break;
		case 4: Ejercicio2d.ejecutar();break;
		case 5: Ejercicio2e.ejecutar();break;
		case 6: Ejercicio2f.ejecutar();break;
		case 7: Ejercicio2g.ejecutar();break;
		case 8: Ejercicio2h.ejecutar();break;
		case 0: menu();break;
		default: ps.println("Opcion Invalida");break;
		}
		menuEjercicio2();
		}
	
	public static void menuEjercicio3() {
		ps.println("1 - Ejercicio A");
		ps.println("2 - Ejercicio B");
		ps.println("3 - Ejercicio C");
		ps.println("4 - Ejercicio D");
		ps.println("5 - Ejercicio E");
		ps.println("6 - Ejercicio F");
		ps.println("7 - Ejercicio G");
		ps.println("0 - Salir ");
		int opcion = Utils.leerInt("Elija una opcion: ");
		switch (opcion) {
		case 1: Ejercicio3a.ejecutar();break;
		case 2: Ejercicio3b.ejecutar();break;
		case 3: Ejercicio3c.ejecutar();break;
		case 4: Ejercicio3d.ejecutar();break;
		case 5: Ejercicio3e.ejecutar();break;
		case 6: Ejercicio3f.ejecutar();break;
		case 7: Ejercicio3g.ejecutar();break;
		case 0: menu();break;
		default: ps.println("Opcion Invalida");break;
		}
		menuEjercicio3();
		}
	
	public static void menuEjercicio4() {
		ps.println("1 - Ejercicio A");
		ps.println("2 - Ejercicio B");
		ps.println("3 - Ejercicio C");
		ps.println("4 - Ejercicio D");
		ps.println("5 - Ejercicio E");
		ps.println("6 - Ejercicio F");
		ps.println("7 - Ejercicio G");
		ps.println("0 - Salir ");
		int opcion = Utils.leerInt("Elija una opcion: ");
		switch (opcion) {
		case 1: Ejercicio4a.ejecutar();break;
		case 2: Ejercicio4b.ejecutar();break;
		case 3: Ejercicio4c.ejecutar();break;
		case 4: Ejercicio4d.ejecutar();break;
		case 5: Ejercicio4e.ejecutar();break;
		case 6: Ejercicio4f.ejecutar();break;
		case 7: Ejercicio4g.ejecutar();break;
		case 0: menu();break;
		default: ps.println("Opcion Invalida");break;
		}
		menuEjercicio4();
		}
	
	public static void menu() {
			ps.println("1 - Ejercicio 1");
			ps.println("2 - Ejercicio 2");
			ps.println("3 - Ejercicio 3");
			ps.println("4 - Ejercicio 4");
			ps.println("0 - Salir ");
		int opcion = Utils.leerInt("Elija una opcion: ");
		switch (opcion) {
		case 1:
			menuEjercicio1();
			break;
		case 2:
			menuEjercicio2();
			break;
		case 3:
			menuEjercicio3();
			break;
		case 4:
			menuEjercicio4();
			break;
		case 0:
			System.exit(0);
			break;
		default:
			ps.println("Opcion Invalida");
			break;
		}
		menu();
		
	}
	
	
}
