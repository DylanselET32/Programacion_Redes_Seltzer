package PlaneFile;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//file archivo = new file();
		FileBinari esrribirEnBinario = new FileBinari(); //el programa
		String bin = "DumpMemory.bin"; //archivo
		try {
			//se abre un archivo de memoria 
			esrribirEnBinario = esrribirEnBinario.deSerializar(bin);
		}catch(IOException | ClassNotFoundException ex) {
		//En caso de no haber archivo, se corre el programa principal 
			
		}finally {			
			esrribirEnBinario.ejecutarPrograma();
		}
		
		//aca se esta ejecutando el programa 
		
		//ejemple de un salir del programaVA a llegar hasta este punto
		
		try {
			esrribirEnBinario.serializar(bin);
		} catch (IOException ex) {
			PrintStream psErr = new PrintStream(System.err);
			psErr.println(ex.getMessage());
		}
		
		
	}

}
