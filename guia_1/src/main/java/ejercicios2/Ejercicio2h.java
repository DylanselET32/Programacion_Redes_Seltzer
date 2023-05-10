package ejercicios2;

import java.io.PrintStream;

import guia_1.Utils;

public class Ejercicio2h {

	/*
	 Dados los valores de dos de los ángulos interiores de un triángulo, la computadora muestra el valor del restante.

	 */
	
	public static PrintStream ps = ps = new PrintStream(System.out);;

	public static void  ejecutar() {
		int n = Math.abs(Utils.leerRInt("Ingrese el valor del numero: "));
		boolean isPrimo;
		if(n == 0) {
			ps.println("El cero no es un numero Natural");
			return;
		}
		for(int i = 2; i<= n; i++) {
			
			if(n % i == 0) {
				isPrimo = false;
				break;
			}else {
				isPrimo = true;
				break;
			}

		}
		isPrimo = (n == 2);
		ps.print(n + ((isPrimo)?" es":" no es") +" un numero primo");
		
	}
	
	
	
	
	
	
	
}
