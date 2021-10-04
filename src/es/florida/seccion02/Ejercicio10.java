package es.florida.seccion02;

import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		System.out.println("10. Introduce una modificación en el programa anterior para que admita otro parámetro de \r\n"
				+ "    entrada adicional que permita especificar la velocidad a la que se muestren los caracteres.\r\n");

		System.out.print("Indica a que velocidad (en segundos) quieres que se imprima por pantalla el texto: ");
		
		Scanner teclado = new Scanner(System.in);
		double velocidad = teclado.nextDouble();
		
		try {
			
			FileReader fr = new FileReader("Texto_Quijote.txt");
			int valor = fr.read();
			while (valor != -1) {

				System.out.print((char) valor);
				valor = fr.read();
				Thread.sleep((long) (velocidad*1000));
			}
			fr.close();
			teclado.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

