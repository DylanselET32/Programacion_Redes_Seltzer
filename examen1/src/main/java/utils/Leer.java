package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.LinkedList;

public class Leer {
	
	static PrintStream ps = new PrintStream(System.out);;
	static InputStreamReader isr = new InputStreamReader( System.in );
	public static BufferedReader br = new BufferedReader( isr );

	
	public static String leer(String pregunta){
		System.out.flush();
		
		
		
		try {
			
			ps.print(pregunta);
			
			int Byte = 0;
			String cadena = "";
			while(   ( Byte = System.in.read() )  != '\n'  )
			{
				if(Byte != '\r') {
					cadena += (char)Byte;
				}
				
			}
			
			
			return cadena;
			//ps.println(  (char)System.in.read()  ) ;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}
	
	
	
	
	public static int leerInt(String pregunta){
		

			String cadena = leer(pregunta);
			int numero = Integer.parseInt(cadena);
			return numero;

	}
	
	public static Double leerDouble(String pregunta){
		

		String cadena = leer(pregunta);
		Double numero = Double.parseDouble(cadena);
		return numero;

}
	
	
	
	public static String leerR(String pregunta) {
		ps.print(pregunta);
		String cadena = null;
		try {
			cadena = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cadena;
	}
	
	public static Double leerRDouble(String pregunta){
		
		String cadena = leerR(pregunta);
		Double numero = Double.parseDouble(cadena);
		return numero;
	
	}
	
	public static int leerRInt(String pregunta){
	
		Double doubleN = leerRDouble(pregunta);
		int numero = (int) Math.floor(doubleN);
		return numero;

	}
	
	
	//files 
	
	public static LinkedList<String> leerFileBuffered(File file)
	{
		LinkedList<String> data = new LinkedList<String>() ;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader( fr );
			
			String linea = "";
			while( (linea = br.readLine() ) !=  null)
			{
				data.add(linea);
			}		
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}
	
	
	
}