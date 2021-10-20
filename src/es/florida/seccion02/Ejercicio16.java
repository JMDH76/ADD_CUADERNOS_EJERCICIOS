package es.florida.seccion02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Ejercicio16 {

	public static void main(String[] args) throws IOException {

		System.out.println("16. Modifica el programa anterior para que el nombre  \r\n"
				+ "    del fichero incluya la fecha y la hora de creación.\r\n");

		System.out.println("Escriba un texto (teclea 'exit' para salir): \n");

		// Captura el texto de la consola, no hace falta Scanner
		InputStreamReader texto = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(texto);

		// Crea el nuevo fichero añadiendo la fecha y hora actual
		LocalDateTime now = LocalDateTime.now(); 			// Fecha y hora actual en formato: "YYYY-MM-DD-hh-mm-ss.zzz"
		DateTimeFormatter formatofechahora = DateTimeFormatter.ofPattern("yyyyMMdd_hhmmss"); // Formato que queremos representar la fecha
		String fechahora = formatofechahora.format(now); 	// Fecha actual con formato elegido

		String nuevofichero = "Texto_consola_" + fechahora + ".txt"; // Monta nombre del fichero
		File ficherocopia = new File(nuevofichero);

		// Copia el texto al nuevo fichero
		FileWriter fw = new FileWriter(ficherocopia);
		BufferedWriter bw = new BufferedWriter(fw);

		String linea = br.readLine();

		// Bucle para copiar linea a linea. Sale tecleando "exit".
		while (!linea.equals("exit")) {
			bw.write(linea);
			bw.newLine();
			linea = br.readLine();
		}
		
		bw.close();
		br.close();
		fw.close();
		
		System.out.println("\nEl texto se ha copiado correctamente en " + nuevofichero);
	}

}
