package flujo_de_datos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

public class pruebasReader {

	public pruebasReader() {

		PrintStream ps = new PrintStream(System.out);
		ps.println("Escriba algo:");

		Reader obj = new InputStreamReader(System.in); //no vamos a usar este objeto, pero vamos a usar el de abajo 
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr); 
		try {
			ps.println((char) isr.read()); //lee un bite
			ps.println(br.readLine());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
