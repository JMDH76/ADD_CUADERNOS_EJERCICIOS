package es.florida.seccion02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Ejercicio11 {

	public static void main(String[] args) {

		System.out.print("11. Realiza otro programa que muestre un número determinado de caracteres por pantalla  \r\n"
				+ "    (por ejemplo 100), espere a que el usuario presione alguna tecla, muestre otro bloque de \r\n"
				+ "    caracteres, vuelva a esperar, y así sucesivamente hasta mostrar todo el contenido.\r\n\n");

		try {

			String nombrefichero = args[0];
			int velocidad = Integer.parseInt(args[1]);
			
			File ficheroOriginal = new File(nombrefichero);
			System.out.println("Archivo: " + ficheroOriginal + "\n");

			FileReader fr = new FileReader(ficheroOriginal);
			BufferedReader br = new BufferedReader(fr);

			int cont = 0;
			int valor = fr.read();
			while (valor != -1) {
				cont++;
				Thread.sleep(velocidad);
				System.out.print((char) valor);
				valor = br.read();
				if (cont >= 100) {
					System.out.println("\nContador: " + cont + " caracteres");
					System.out.println("--------------------------------------------------------");
					System.in.read();	//Retorno de carro, pausa y se activa cuando pulsamos "Enter".
					cont = 0;
				}
			}
			fr.close();
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}


