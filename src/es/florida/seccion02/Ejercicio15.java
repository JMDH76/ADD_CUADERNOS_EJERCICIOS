package es.florida.seccion02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;


public class Ejercicio15 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("15. Realiza un programa que permita recibir por teclado una serie de strings por parte del \r\n"
				+ "    usuario y los vaya escribiendo en un fichero de texto. Como condición de finalización, el \r\n"
				+ "    usuario deberá escribir un string que sea “exit”.\n");
		
		System.out.print("Escriba un texto: ");
		
		//Captura el texto de la consola, no hace falta Scanner
		InputStreamReader texto = new InputStreamReader(System.in);  
		BufferedReader br = new BufferedReader(texto);
		
		//Crea el nuevo fichero
		String nuevofichero = "Texto_consola.txt";		
		File ficherocopia = new File (nuevofichero);
		
		//Copia el texto al nuevo fichero
		FileWriter fw = new FileWriter (ficherocopia); 
		BufferedWriter bw = new BufferedWriter (fw);
		
		String linea = br.readLine();
		
		//Bucle para copiar linea a linea. Sale tecleando "exit".
		while (!linea.equals("exit")) {
			bw.write(linea);
			bw.newLine();
			linea = br.readLine();			
		}
		bw.close();
		br.close();
		fw.close();

		System.out.println ("\nEl texto se ha copiado correctamente en " + nuevofichero);
	}

}
