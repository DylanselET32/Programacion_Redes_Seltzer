/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
	LinkedList<String> datos;


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
    	datos = Leer.leerFileBuffered(fileJuegosafter);
		for(String e: datos) {
			ps.println(e.replaceAll(";", " | "));
		}
    	
    }
    
    
    public void mayorCantVictorias() {
    	datos = Leer.leerFileBuffered(fileJuegosafter);
    	Map< String , Integer > meses = new HashMap<String, Integer>();
    	for(int i = 1; i<datos.size(); i++) {
    		String dato = datos.get(i);
    		String hasWon = dato.split(";")[1];
    		String fecha = dato.split(";")[0];
    		String mes = fecha.split("/")[1];
    		if(hasWon.equals("1")) {
    			if(!meses.containsKey(mes)) {
    				meses.put(mes, 1);
    			}else {
    				meses.replace(mes, meses.get(mes)+1);
    			}
    			
    		}
			
    	}
    	
    	
    	String mayorMes = "";
    	int mayorMesInt = 0;
   
    	
    	for(Map.Entry<String, Integer> item : meses.entrySet()) {
    		if(mayorMesInt  <= item.getValue()) {
    			mayorMes = item.getKey();
    			mayorMesInt = item.getValue();

    		}
    	}
    	ps.println("Mes con mayor victoria fue " + mayorMes + " obtubo "+ mayorMesInt+ " vicotorias");
			
		
    	
    }
}
