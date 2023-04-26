package PlaneFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class file {

	File error;
	FileWriter fw;

	public file() {
		error = new File("errores.log");
		try {
			fw = new FileWriter(error, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// this.CrearConPrintStream();
		// this.CrearConPrinter();
		this.CrearConBuffered();
	}

	public void CrearConPrintStream() {
		try {
			FileOutputStream fos = new FileOutputStream(error);
			// fos.write(null); - System.out....

			PrintStream ps = new PrintStream(fos, true);
			ps.println("Hello Word desde java con PrintStream");
			ps.flush();
			ps.close();
			fos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CrearConPrinter() {

		PrintWriter pw = new PrintWriter(fw);
		pw.println("Hello Word desde java con Printer");
		pw.close();
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void CrearConBuffered() {

		BufferedWriter bw = new BufferedWriter(fw);

		try {
			bw.write("Hello Word desde java con Buffered");
			bw.newLine();
			bw.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) { // valido los datos para que no se cierre archivos si ya estan cerrados
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



public void LeerConBuffered() {
	String texto = "";
	try {
		FileReader fr = new FileReader(error);
		BufferedReader br = new BufferedReader(fr);
		String linea ="";
		while((linea = br.readLine()) != null) {
			texto += "\n" + linea;
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}
}