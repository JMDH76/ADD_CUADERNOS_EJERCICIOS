package es.florida.seccion02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ejercicio09 {

	public static void main(String[] args) {

		System.out.println(
				 "9. Escribe un programa que reciba como par�metro de entrada la ruta de un fichero, \r\n"
						+ "   lea su contenido y lo muestre por pantalla car�cter a car�cter.\n");

		try {
			
			String nombrefichero = args[0];
			File ficheroOriginal = new File (nombrefichero);
			System.out.println("Archivo: " + ficheroOriginal + "\n");
		
			FileReader fr = new FileReader(ficheroOriginal);
			BufferedReader br = new BufferedReader(fr);
			
			int valor = br.read();
			while (valor != -1) {
				System.out.print((char) valor);
				valor = br.read();
			}
			fr.close();
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
