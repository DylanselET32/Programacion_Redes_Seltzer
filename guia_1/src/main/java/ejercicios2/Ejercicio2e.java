package ejercicios2;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import guia_1.Utils;

public class Ejercicio2e {

	/*
	 Dado un tiempo en segundos, la computadora lo muestra expresado en días, horas, minutos y segundos.


	 */
	
	public static PrintStream ps = new PrintStream(System.out);

	public static void  ejecutar() {
	// Crear el ArrayList de signos zodiacales
		ArrayList<String> signosZodiacal = new ArrayList<String>(Arrays.asList(
		 "ARIES","TAURO","GÉMINIS", "CÁNCER","LEO","VIRGO","LIBRA",
		 "ESCORPIO","SAGITARIO","CAPRICORNIO","ACUARIO","PISCIS"));
		ArrayList<String> zodiacDates = new ArrayList();
		zodiacDates.add("80-110"); // Aries (21 de marzo - 19 de abril)
		zodiacDates.add("111-140"); // Tauro (20 de abril - 20 de mayo)
		zodiacDates.add("141-171"); // Géminis (21 de mayo - 20 de junio)
		zodiacDates.add("172-203"); // Cáncer (21 de junio - 22 de julio)
		zodiacDates.add("204-234"); // Leo (23 de julio - 22 de agosto)
		zodiacDates.add("235-265"); // Virgo (23 de agosto - 22 de septiembre)
		zodiacDates.add("266-295"); // Libra (23 de septiembre - 22 de octubre)
		zodiacDates.add("296-325"); // Escorpio (23 de octubre - 21 de noviembre)
		zodiacDates.add("326-355"); // Sagitario (22 de noviembre - 21 de diciembre)
		zodiacDates.add("356-19"); // Capricornio (22 de diciembre - 19 de enero)
		zodiacDates.add("20-49"); // Acuario (20 de enero - 18 de febrero)
		zodiacDates.add("50-79"); // Piscis (19 de febrero - 20 de marzo)
        String fechaNacimiento = Utils.leerR("ingrese la fecha de nacimiento(dd/mm/aaaa): ");
       	fechaNacimiento = normalizarFecha(fechaNacimiento);
        
        int codigoFecha = obtenerFechaNumerica(fechaNacimiento);
        for (int i = 0; i< zodiacDates.size(); i++) {
        	int fI = Integer.parseInt(zodiacDates.get(i).split("-")[0]) ;
        	int fF = Integer.parseInt(zodiacDates.get(i).split("-")[1]) ;
        	
        	
        	if(codigoFecha>=fI && codigoFecha<=fF) {
        		ps.println("Tu signo es: "+ signosZodiacal.get(i));
        	}
        }
        ps.println("codigo: "+codigoFecha);
        
        
	}
	
	
	public static int obtenerFechaNumerica(String fechaString) {
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate fecha = LocalDate.parse(fechaString, formato);
	    LocalDate primerDiaDelAnio = LocalDate.of(fecha.getYear(), 1, 1);
	    long diasDesdeElPrimerDiaDelAnio = fecha.toEpochDay() - primerDiaDelAnio.toEpochDay();
	    return (int)diasDesdeElPrimerDiaDelAnio +1;
	}
	
	public static String normalizarFecha(String fecha) {
		
	    String[] partesFecha = fecha.split("/");
	    int dia = Integer.parseInt(partesFecha[0]);
	    int mes = Integer.parseInt(partesFecha[1]);
	    int anio = Integer.parseInt(partesFecha[2]);
	    String diaNormalizado = (dia < 10) ? "0" + dia : String.valueOf(dia);
	    String mesNormalizado = (mes < 10) ? "0" + mes : String.valueOf(mes);
	    return diaNormalizado + "/" + mesNormalizado + "/" + anio;
	}
	
	
	
	
	
}
