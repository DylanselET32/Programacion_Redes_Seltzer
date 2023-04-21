package guia_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Utils {
	
	static PrintStream ps = ps = new PrintStream(System.out);;
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
	
	public static int leerRInt(String pregunta){
	
		String cadena = leerR(pregunta);
		int numero = Integer.parseInt(cadena);
		return numero;

	}
	
	public static Double leerRDouble(String pregunta){
		
		String cadena = leerR(pregunta);
		Double numero = Double.parseDouble(cadena);
		return numero;
	
	}

	
	
	
}
