package ejercicios2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;

import guia_1.Utils;

public class Ejercicio2b {


	public static PrintStream ps = ps = new PrintStream(System.out);;

	public static void  ejecutar() {
		ArrayList<Integer> numeros= new ArrayList();
		for(int i =1;i<=4; i++) {
			int num = Utils.leerRInt("Ingrese el numero "+i+": ");
			numeros.add(num);
		}
		Collections.sort(numeros); //ordena el arraylist acendentemente
		ps.println("El menor es: "+numeros.get(0));

	}
	
	
	
	
	
	
	
}
