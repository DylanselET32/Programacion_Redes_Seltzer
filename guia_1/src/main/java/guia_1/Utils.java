package guia_1;

import java.io.IOException;
import java.io.PrintStream;

public class Utils {
	
	public static PrintStream ps = ps = new PrintStream(System.out);;


	
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
	
	
	
	public static String LeerR(String pregunta) {
		ps.print(pregunta);
		String cadena = "aca va el codigo de render";
		return cadena;
		
	}
	
	
	
}
