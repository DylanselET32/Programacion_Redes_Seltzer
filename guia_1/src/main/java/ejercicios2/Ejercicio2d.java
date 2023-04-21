package ejercicios2;

import java.io.PrintStream;

import guia_1.Utils;

public class Ejercicio2d {

	
	
	public static PrintStream ps = ps = new PrintStream(System.out);;

	public static void  ejecutar() {
		double num1 = Utils.leerRDouble("Ingrese un numero: ");
		double num2 = Utils.leerRDouble("Ingrese otro numero: ");
		double numMayor;
		double numMenor;
		
		if(num1>num2) {
			numMayor = num1;
			numMenor = num2;
		}else{
			numMayor = num2;
			numMenor = num1;
		}
		
		if(numMayor%numMenor == 0) {
			ps.printf("El %.2f es divisible por %.2f",numMayor,numMenor);
		}else {
			ps.printf("El %.2f NO es divisible por %.2f",numMayor,numMenor);
		}
		
		
	}
	
	
	
	
}
