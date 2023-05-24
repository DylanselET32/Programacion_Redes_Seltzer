package ejercicios4;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import guia_1.Utils;

public class Ejercicio4a {

	/*
	 Dados el valor de una hora de trabajo y la cantidad de horas trabajadas,
	  la computadora muestra el valor del sueldo bruto.
	 */
	
	public static PrintStream ps = ps = new PrintStream(System.out);;
	public static List<Integer> numeros;

	public static void  ejecutar() {
		numeros = new LinkedList<Integer>();
		leerValores();
		mostrarResultados();
		
	}
	
	public static void  leerValores() {
		int num = 0;
		while (num != -99) {
			num = Utils.leerRInt("Ingrese un numero entero: ");
			if(num==-99){
				break;
			}else {
				numeros.add(num);
			}
			
		}
	}
	
	
	public static int  calcularSuma(List<Integer> listNumeros) {
		int sumaN = 0;
		for(int i : listNumeros) {
			sumaN += i; 
		}
		return sumaN;
	}
	
	public static int  calcularMayoresMedia(List<Integer> listNumeros) {
		int media = calcularSuma(listNumeros) / numeros.size();
		int sumaN = 0;
		for(int i : listNumeros) {
			if(i>media) {
				sumaN++;
			}
		}
		return sumaN;
	}
	
	public static void  mostrarResultados() {
		int suma = calcularSuma(numeros);
		int media = suma / numeros.size();
		int nMayoresMedia = calcularMayoresMedia(numeros);
		ps.println("Numeros leidos: "+numeros.size());
		ps.println("La suma es: "+suma);
		ps.println("Media (promedio): "+ media);
		ps.println("Cantidad de numeros mayores a la media: "+ nMayoresMedia);
	}
	
	
	
	
	
	
	
	
	
}
