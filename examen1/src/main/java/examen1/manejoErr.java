package examen1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class manejoErr {

	File archivo = new File("errores.log");
	FileOutputStream fos;
	PrintStream psfos; 
	
	
	public manejoErr(){
		try {
			fos = new FileOutputStream(archivo, true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		psfos = new PrintStream(fos);
		System.setErr(psfos);
		

	}
	
	public void errPersonalizado(String err) {
		Logger.getLogger(manejoErr.class.getName()).log(Level.SEVERE, err);
		try {
			fos.close();
			psfos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
}
