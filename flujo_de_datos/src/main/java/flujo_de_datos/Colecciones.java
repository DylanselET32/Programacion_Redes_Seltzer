package flujo_de_datos;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Colecciones {
	PrintStream ps = new PrintStream(System.out); 
	
	
	public Colecciones(){
		//Tipos de colleciones: 
		
		//ArrayList
		//Es muy rapido pero poco eficiente con la memoria ram
		//Para procesamiento rapido 
		ArrayList<String> frutas2 = new ArrayList<String>();
		frutas2.add("Manzana");
		frutas2.add("Banana");
		frutas2.add("Pera");
		
		//LinkedList 
		//Es medio lento pero optimiza la memoria
		//usado para grandes cantidades de agregacion y eliminacion
		LinkedList<String> animales = new LinkedList<String>();
		
		
		//List es una forma generica para guardar
		List<String> frutas3 = new ArrayList<String>();
		List<String> verduras3 = new LinkedList<String>();
		
		
		//Diccionarios K Key, V value
		Map< String, String> inglesEspañol = new HashMap<String, String>();
		
		
		inglesEspañol.put("Hello", "Hola");
		inglesEspañol.put("bye", "chau");
		
		ps.println(inglesEspañol.get("Hello"));    
		ps.println(inglesEspañol.get("bye"));    
		//Maneras de iterar o recorrer
		
		//for tradicional
		ps.println("POR FOR TRADICIONAL");
		for(int i = 0; i< frutas2.size() ; i++) {
			ps.println(frutas2.get(i));
		}
		//for each
		ps.println("POR FOR EACH");
		for(String el : frutas2) {
			ps.println(el);
		}
		
		//Por Iterator
		ps.println("POR ITERATOR");
		Iterator i = frutas2.iterator();
		while (i.hasNext()) {
			ps.println(i.next());
			
		}
		
		
		
		//Como iterar un Hashmap - MAP
		Iterator map = inglesEspañol.keySet().iterator();
		while(map.hasNext()) {
			String key = (String)map.next();
			String value = inglesEspañol.get(key);
		}
		
		
		
		
		
		
		
	}
	
}
