/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1;
import java.io.File;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.logging.Logger;

import utils.Escribir;
import utils.Leer;

/**
 *
 * ACA UTILIZAR COLECCIONES PARA ALMACENAR LOS DATOS Y PODER TRABAJAR CON ELLOS
 * ADEMAS PEDIR LOS DATOS UEVOS A LOS USUARIO Y CALCULAR EL MES DE MAYOR
 * VICTORIAS
 *
 * @author
 */
public class Datos {
	
	protected static PrintStream  ps = new PrintStream(System.out);
	protected static File fileJuegosbefore;
	protected static File fileJuegosafter;

	public Datos() {
		fileJuegosbefore = new File("juegos.dat");
    	fileJuegosafter = new File("juegos.scv");
    }
	
    private static final Logger LOG = Logger.getLogger(Datos.class.getName());

    public void estandarizado() {
    	LinkedList<String> datosBefore = Leer.leerFileBuffered(fileJuegosbefore);
    	for(String datoBefore : datosBefore) {
    		String dat  = datoBefore.replace("+", ";");
    		Escribir.escribirFileWrite(fileJuegosafter, dat, true);
    	}
    	fileJuegosbefore.delete();
    	fileJuegosafter = new File("juegos.scv");
    }
    
    
    
    public void mostrarDatos() {
    	LinkedList<String> dato = Leer.leerFileBuffered(fileJuegosafter);
		for(String e: dato) {
			ps.println(e.replaceAll(";", " | "));
		}
    	
    }
}
