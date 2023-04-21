package ejercicios2;

import java.io.PrintStream;
import guia_1.Utils;

public class Ejercicio2c {
	
	public static PrintStream ps = ps = new PrintStream(System.out);;

	public static void  ejecutar() {
		int num = Utils.leerRInt("Ingrese un numero: ");
		if(num%2 == 0) {
			ps.println(num+" es par");
		}else {
			ps.println(num+" es inpar");
		}
		

	}
	
	
	
	
	
	
	
}
