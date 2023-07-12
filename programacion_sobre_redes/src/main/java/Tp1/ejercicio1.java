package Tp1;

import java.io.File;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;

import utils.Leer;

public  class ejercicio1 {
	 PrintStream ps = new PrintStream(System.out);
	 public LinkedList<String> list1 = new LinkedList<String>();
	 public LinkedList<Integer> list2 = new LinkedList<Integer>();
	 
	public ejercicio1() {
		File file = new File("datosEntrada.txt");
		list1 = Leer.leerFileBuffered(file);
		
	}
	
	public void leerDatos(){
		
		for (int i=0;i<5; i++) {
			try {
				int n = Leer.leerRInt("Ingrese el numero "+i+1+": ");
				list2.add(n);
			} catch (Exception e) {
				ps.println("Error al ingresar numero");
			}
			
		}
	}
	
	public void imprimirDatos1() {
		for (String i : list1) {
				ps.println(i);
		}
	}
	public void imprimirDatos2() {
		for (int i : list2) {
			ps.println(i);
		}
	}
	
	
}
