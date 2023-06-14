/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen1;
import java.io.PrintStream;
import java.util.logging.Logger;

import utils.Leer;

/**
 * REALIZAR EL MENU INFINITO CON LAS OPCIONES PARA EL USUARIO QUE LLEVEN A CADA ACCION 
 * 
 * @author 
 */
public class Programa {
    
    private static final Logger LOG = Logger.getLogger(Programa.class.getName());
    public static PrintStream  ps = new PrintStream(System.out);
    protected Datos datos = new Datos();
    
    /**
     * 
     */
    public Programa() {
    	
    }
    
    /**
     * 
     */
    public void iniciar() {
    	//datos.estandarizado();
    	menu();
        
    }

	public  void menu() {
		ps.println("-------------MENU--------------");
		ps.println("1-Leer datos");
		ps.println("2-Leer Mayor cantidad de victorias por mes");
		ps.println("0-Cerrar Programa");
		int eleccion = Leer.leerRInt("Ingresa el numero elegido: ");
		switch(eleccion) {
		case 1:
			ps.println("--------Leer datos----------");
			datos.mostrarDatos();
			break;
		case 2:
			ps.println("--------Leer Mayor cantidad de victorias por mes----------");
			datos.mayorCantVictorias();
			break;
		case 3:
			ps.println("--------Agregar datos----------");
			break;
		case 4:
			ps.println("--------Eliminar datos----------");
			break;
		case 0:
			ps.println("Hasta pronto!!");
			System.exit(0);
			break;
		default:
			ps.println("opcion invalida");
		}
		menu();
	}
    
    
    
}
