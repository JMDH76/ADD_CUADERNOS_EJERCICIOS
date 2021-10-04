package es.florida.seccion02;

import java.io.FileReader;
import es.florida.seccion01.Color;

public class Ejercicio09 {

	public static void main(String[] args) {

		System.out.println(
				Color.green + "9. Escribe un programa que reciba como par�metro de entrada la ruta de un fichero, \r\n"
						+ "   lea su contenido y lo muestre por pantalla car�cter a car�cter.\n" + Color.reset);

		try {
			//FileReader fr = new FileReader("C:\\Users\\josem\\eclipse-workspace\\ADD\\CUADERNO_EJERCICIOS\\CuadernoEjerciciosT01\\src\\es\\florida\\seccion02\\Archivos\\Texto_Quijote.txt");
			FileReader fr = new FileReader("Texto_Quijote.txt");
			int valor = fr.read();
			while (valor != -1) {

				System.out.print((char) valor);
				valor = fr.read();
				Thread.sleep(10);
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
