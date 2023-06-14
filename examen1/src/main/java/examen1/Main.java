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
 * @author 
 */
public class Main {
    
    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    
    /**
     * SOLO PREPARAR EL ARCHIVO (CON ORIENCION A OBJETOS) Y LUEGO LLAMAR AL FUNCIONAMIENTO DEL PROGRAMA
     * @param args 
     */
    public static PrintStream  ps = new PrintStream(System.out);
	static File fileJuegosbefore;
	static File fileJuegosafter;
    public static void main(String[] args) {
    	
        Programa programa = new Programa();
        programa.iniciar();
        
        
    }
    
   
    
    
   
    
    
    

    
    
    
}
