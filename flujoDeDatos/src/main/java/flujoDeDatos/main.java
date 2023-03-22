package flujoDeDatos;

import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String nombre = "Dylan";
		int edad = 19;
		
		System.out.printf("Mi nombre es %S y tengo %D", nombre,edad);
		System.out.append("Este codigo se ingresa seguido al anterior")
		System.out.flush(); // limpia el flujo de datos
		
		System.out.write(64); //el write agrega al flujo de datos un caracter con el 
		System.out.write(10); //10 en el codigo ascii, significa que envia el flujo de datos a la consola
		
		//enviar varios codigos con un array, dice "hola mundo"
		byte[] array = {72,111,108,97, 32 ,109,117,110,100,111}; //array de bytes del codigos ASCII

		//manejos de errores
		try {
			System.out.write(array); //imprimo 
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		Logger.getLogger(main.class.getName()).log(Level.SEVERE, "Error Severo, EROR CRITICO");
		PrintStream err = new PrintStream(System.err);
		PrintStream ps = new PrintStream(System.out);
		ps.println("Holaa");
		
		
		
		
	}

}
