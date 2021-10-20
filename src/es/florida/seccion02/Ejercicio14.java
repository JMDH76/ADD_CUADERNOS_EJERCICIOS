package es.florida.seccion02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio14 {

	public static void main(String[] args) throws IOException {
		
		System.out.print("14. Crea otro programa a partir del anterior que en vez de mostrar el contenido  \r\n"
				+ "    por consola lo escriba en otro fichero del mismo directorio.\n");

		String nombrefichero = args[0];
		
		int index = nombrefichero.indexOf(".");
		String nombreficherosinextension = nombrefichero.substring(0, index);
		String extension = nombrefichero.substring(index);
		String nombrecopia = nombreficherosinextension + "_copia" + extension; 
		
		System.out.print("\nArchivo original:	" + nombrefichero);
		System.out.println("\nArchivo copia:		" + nombrecopia);
		
		File ficheroOriginal = new File(nombrefichero);
		FileReader fr = new FileReader(ficheroOriginal);
		BufferedReader br = new BufferedReader(fr);
			
		File ficheroCopia = new File(nombrecopia);
		FileWriter fw = new FileWriter(ficheroCopia); // Crea fichero donde vamos a escribir
		BufferedWriter bw = new BufferedWriter(fw);

		String linea = br.readLine();

		while (linea != null) {
			bw.write(linea);
			bw.newLine();
			linea = br.readLine();
		}
		bw.close();		//primero hay que cerra los buffer y luego los files
		br.close();		
		fw.close();
		fr.close();
		System.out.println("\nProceso de copia finalizado.    " + ficheroOriginal + " --> " + ficheroCopia);
	}
}
