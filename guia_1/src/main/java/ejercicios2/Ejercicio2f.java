package ejercicios2;

import java.io.PrintStream;

import guia_1.Utils;

public class Ejercicio2f {


	public static PrintStream ps = new PrintStream(System.out);

	public static void  ejecutar() {
		ps.println("PERSONA 1");
		String p1 = Utils.leerR("Ingrese el  \"nombre y apellido\" en ese orden: ");
		ps.println("PERSONA 2");
		String p2 = Utils.leerR("Ingrese el  \"nombre y apellido\" en ese orden: ");
		
		if(p1.split(" ")[1].length() > p2.split(" ")[1].length()) {
			ps.println(p1.split(" ")[0] + " es el que tiene el apellido mas largo");
		}else if(p1.split(" ")[1].length() < p2.split(" ")[1].length()){
			ps.println(p2.split(" ")[0] + " es el que tiene el apellido mas largo");
		}else {
			ps.println("Ambos tienen un apellido igual de largo");
		}
	
	}
	
	
	
	
	
	
	
}
