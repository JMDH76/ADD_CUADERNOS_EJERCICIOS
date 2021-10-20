package es.florida.seccion02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio12 {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.print("12. Crea un programa que dado un fichero de texto, lea y muestre su contenido línea a línea.");
		
		String nombrefichero = args[0];
		
		File ficheroOriginal = new File(nombrefichero);
		System.out.println("Archivo: " + ficheroOriginal + "\n");
		
		FileReader fr = new FileReader(ficheroOriginal);
		BufferedReader br = new BufferedReader(fr);
		
		String linea = br.readLine();
		
		while (linea != null) {
			
			System.out.println(linea);
			linea = br.readLine();
		}
		br.close();
		fr.close();
	}

}
