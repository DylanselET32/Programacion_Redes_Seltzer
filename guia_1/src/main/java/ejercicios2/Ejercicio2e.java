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
		zodiacDates.add("21-132"); // Aries (21 de marzo - 19 de abril)
        zodiacDates.add("20-152"); // Tauro (20 de abril - 20 de mayo)
        zodiacDates.add("21-173"); // Géminis (21 de mayo - 20 de junio)
        zodiacDates.add("21-204"); // Cáncer (21 de junio - 22 de julio)
        zodiacDates.add("23-235"); // Leo (23 de julio - 22 de agosto)
        zodiacDates.add("23-266"); // Virgo (23 de agosto - 22 de septiembre)
        zodiacDates.add("23-296"); // Libra (23 de septiembre - 22 de octubre)
        zodiacDates.add("23-327"); // Escorpio (23 de octubre - 21 de noviembre)
        zodiacDates.add("22-357"); // Sagitario (22 de noviembre - 21 de diciembre)
        zodiacDates.add("22-20"); // Capricornio (22 de diciembre - 19 de enero)
        zodiacDates.add("20-50"); // Acuario (20 de enero - 18 de febrero)
        zodiacDates.add("19-79"); // Piscis (19 de febrero - 20 de marzo)
        
        String fechaNacimiento = Utils.leerR("ingrese la fecha de nacimiento(dd/mm/aaaa): ");
        int codigoFecha = obtenerFechaNumerica(fechaNacimiento);
        ps.println("codigo: "+codigoFecha);
        //SEGUIR CODIGO
        
	}
	
	
	public static int obtenerFechaNumerica(String fechaString) {
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate fecha = LocalDate.parse(fechaString, formato);
	    LocalDate primerDiaDelAnio = LocalDate.of(fecha.getYear(), 1, 1);
	    long diasDesdeElPrimerDiaDelAnio = fecha.toEpochDay() - primerDiaDelAnio.toEpochDay();
	    return (int)diasDesdeElPrimerDiaDelAnio;
	}
	
	
	
	
	
	
}
