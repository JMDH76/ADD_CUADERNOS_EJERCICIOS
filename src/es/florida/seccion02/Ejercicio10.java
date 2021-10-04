package es.florida.seccion02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Ejercicio10 {

	public static void main(String[] args) {
		System.out
				.println("10. Introduce una modificación en el programa anterior para que admita otro parámetro de \r\n"
						+ "    entrada adicional que permita especificar la velocidad a la que se muestren los caracteres.\r\n");

		try {
			
			String nombrefichero = args[0];
			int velocidad = Integer.parseInt(args[1]);
			
			File ficheroOriginal = new File(nombrefichero);
			
			System.out.println("Archivo: " + ficheroOriginal);
			System.out.println("Velocidad " + velocidad + " ms\n" );

			FileReader fr = new FileReader(ficheroOriginal);
			BufferedReader br = new BufferedReader(fr);
		
			int valor = fr.read();
			while (valor != -1) {
				System.out.print((char) valor);
				valor = br.read();
				Thread.sleep(velocidad);
			}
			fr.close();
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

