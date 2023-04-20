package ejercicios1;

import java.io.PrintStream;

import guia_1.Utils;

public class Ejercicio1f {

	/*
	 Dados los valores de dos de los ángulos interiores de un triángulo, la computadora muestra el valor del restante.

	 */
	
	public static PrintStream ps = ps = new PrintStream(System.out);;

	public static void  ejecutar() {
		double precio = Utils.leerDouble("Ingrese el precio del producto: ");
		
		
		ps.println("\nPLAN 1");
		double p1 = precio*0.9; 
		ps.println("Pagando al contado se hace 10% de descuento pagando en total: "+p1);
		
		ps.println("\nPLAN 2");
		double p2 = (precio*1.10)/2;
		double p3 = p2/2;
		ps.printf("Pagando el 50%% ( %.2f ) al contado y el resto en 2 cuotas de: %.2f \n", p2,p3);
		
		ps.println("\nPLAN 3");
		double p4 = (precio*1.10)/4;
		double p5 = (p2*3)/5;
		ps.printf("Pagando el 25%% ( %.2f ) al contado y el resto en 5 cuotas iguales de: %.2f \n", p4,p5);
		
		ps.println("\nPLAN 4");
		double t4 = (precio*1.25);
		double p6 = (t4*0.60)/4;
		double p7 = (t4*0.40)/4;
		ps.printf("Completamente financiado en 8 cotas:\n\t4 cuotas iguales de: %.2f \n\t4 cuotas iguales de: %.2f \n", p6,p7);
		
		
	
	}
	
	
	
	
	
	
	
}
