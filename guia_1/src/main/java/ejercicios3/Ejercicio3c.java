package ejercicios3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import guia_1.Utils;

public class Ejercicio3c {

	/*
	 Dados el valor de una hora de trabajo y la cantidad de horas trabajadas,
	  la computadora muestra el valor del sueldo bruto.
	 */
	
	public static PrintStream ps = ps = new PrintStream(System.out);;

	public static void  ejecutar() {
		File file = new File("C:\\Users\\Redes-20\\Desktop\\numeros.txt");
		FileOutputStream fos;
		
		try {
			fos = new FileOutputStream(file);
			PrintStream psFile = new PrintStream(fos);
			String nombre = Utils.leerR("Ingresa tu nombre: ");
			psFile.println(nombre);
			ps.flush();

			psFile.close();

			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
		
	
}