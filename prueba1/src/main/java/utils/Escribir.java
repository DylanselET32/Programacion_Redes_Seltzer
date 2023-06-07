package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Optional;

public class Escribir {

	public static void escribirFileWrite(File file,String text,boolean sobrescribir ) {
		try {
			FileWriter fw = new FileWriter(file,sobrescribir);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(text);
			pw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	} 
	
	public static void escribirFileWrite(File file,LinkedList<String> text, boolean sobrescribir ) {
		try {
			FileWriter fw = new FileWriter(file,sobrescribir);
			PrintWriter pw = new PrintWriter(fw);
			for(String e: text) {
				pw.println(e);
			}
			pw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
}
