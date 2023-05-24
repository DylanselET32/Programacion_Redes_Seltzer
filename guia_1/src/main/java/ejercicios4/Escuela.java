package ejercicios4;

import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import guia_1.Utils;

public class Escuela {
	Map< Integer , String > alumnos;
	PrintStream ps = new PrintStream(System.out);
	public Escuela() {
		alumnos =  new LinkedHashMap<Integer, String>();
		alumnos.put(1, "argentina");
		alumnos.put(2, "argentina");
		alumnos.put(3, "españa");
		alumnos.put(4, "españa");
		alumnos.put(5, "argentina");
		alumnos.put(6, "argentina");
		alumnos.put(7, "estados unidos");
		alumnos.put(8, "estados unidos");
		alumnos.put(9, "estados unidos");
		alumnos.put(9, "chile");
	}
	
	public void addAlumno() {
		int dni = Utils.leerRInt("Ingrese el DNI: ");
		String nacionalidad = Utils.leerR("Ingrese la nacionalidad: ");
		alumnos.put(dni, nacionalidad);
		ps.println("Agregado Correctamente");
	}
	
	public void showAll() {
		
		ps.println("Nacionalidades: ");
		//Muestra las distintas nacionalidades y el número de alumnos que existen por nacionalidad 
		Map< String,Integer> nacionalidades= mapCountRepeat(alumnos);
		for(Map.Entry<String, Integer> item : nacionalidades.entrySet())
        {
        	ps.println(item.getKey() + " => "+item.getValue());
        	//item.getValue();
        }
		ps.println("Cantdad de nacionalidades: "+nacionalidades.size());
	 
	}
	
	public Map< String,Integer> mapCountRepeat(Map< Integer , String > mapOrigin){
		Map<String,Integer> mapCont = new LinkedHashMap<String, Integer>();
		ps.println("A1");
		for(Map.Entry<Integer, String> item : mapOrigin.entrySet())
        {
			if(!mapCont.containsKey(item.getValue())) {
				mapCont.put(item.getValue(), 1);
			}else {
				int anterior = mapCont.get(item.getValue());
				ps.println(anterior);
				mapCont.replace(item.getValue(), anterior +1);
			}
        	
        }
		return mapCont;
	}
	
	public void removeAll() {
		alumnos.clear(); // limpia todo el diccionario
		ps.println("Se borro TODOS los alumnos");
	}
	
	public void menuEscuela() {
		int opcion = -1;
		while(opcion != 0) {
			ps.println("1- Agregar nuevo alumno");
			ps.println("2- Ver Datos");
			ps.println("3- Borrar todos los alumnos");
			ps.println("0- salir");
			opcion = Utils.leerRInt("ingrese el numero de opcion:");
			switch (opcion) {
			case 1: addAlumno();break;
			case 2: showAll();break;
			case 3: removeAll();break;
			case 4: ;break;
			default:
				ps.println("Opcion invalida");
				break;
			}
		}
		
		
	}
	
	
}
