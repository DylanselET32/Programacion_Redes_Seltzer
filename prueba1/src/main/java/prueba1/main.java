package prueba1;

import utils.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.LinkedList;

public class main {
	/*
	1;Dylan;Sel;19;6to 1°;ET32
	2;Emily;Thompson;21;3°;ET27
	3;Sophia;Lopez;25;6°;ET18
	4;Jackson;Smith;22;4°;ET29
	5;Olivia;Johnson;20;2°;ET12
	6;Aiden;Williams;18;5°;ET15
	7;Emma;Brown;23;5°;ET21
	8;Lucas;Garcia;24;6°;ET17
	9;Isabella;Martinez;19;6°;ET19
	10;Mason;Lee;20;6°;ET25
	*/
	public static PrintStream  ps = new PrintStream(System.out);
	static File file = new File("data.txt");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/*
		LinkedList<String> leido= Leer.leerFileBuffered(file);
		
		for(String e:leido) {
			ps.println(e);
		}
		
		
		Escribir.escribirFileWrite(file, "PRUEBAAAAA", true);
		Escribir.escribirFileWrite(file, "PRUEBAAAAA2", true);
		
		*/
		menu();
		
	}
	
	
	public static void menu() {
		ps.println("---------MENU--------------");
		ps.println("1-Leer datos");
		ps.println("2-Editar datos");
		ps.println("3-Agregar datos");
		ps.println("4-Eliminar datos");
		ps.println("0-Leer datos");
		int eleccion = Leer.leerRInt("Ingresa el numero elegido: ");
		switch(eleccion) {
		case 1:
			ps.println("--------Leer datos----------");
			leerDatos();
			break;
		case 2:
			ps.println("--------Editar datos----------");
			break;
		case 3:
			ps.println("--------Agregar datos----------");
			AgregarDatos();
			break;
		case 4:
			ps.println("--------Eliminar datos----------");
			break;
		case 0:
			ps.println("Hasta pronto!!");
			System.exit(0);
			break;
		default:
			ps.println("opcion invalida");
		}
		menu();
	}


	private static void leerDatos() {
		LinkedList<String> dato = Leer.leerFileBuffered(file);
		for(String e: dato) {
			ps.println(e.replaceAll(";", " | "));
		}
		
	}
	private static void AgregarDatos() {
		LinkedList<String> dato = Leer.leerFileBuffered(file);
		String id = dato.getLast().split(";")[0]+1;
		String nombre = Leer.leerR("Ingrese el nombre: ");
		String apellido = Leer.leerR("Ingrese el apellido: ");
		String edad = Leer.leerR("Ingrese la edad: ");
		String anio = Leer.leerR("Ingrese el Año: ");
		String escuela = Leer.leerR("Ingrese la escuela: ");
		String datos = id+";"+nombre+";"+apellido+";"+edad+";"+anio+";"+escuela;
		Escribir.escribirFileWrite(file, datos, true);
		
	}
	

	
	
	
	

}
