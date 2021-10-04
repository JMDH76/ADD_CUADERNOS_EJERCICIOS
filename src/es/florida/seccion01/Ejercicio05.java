package es.florida.seccion01;

import java.io.File;

public class Ejercicio05 {

	public static void main(String[] args) {

		System.out.print(Color.green + "5. Realiza un programa que reciba como parámetros de entrada un directorio y una extensión \r\n"
				+ "   de fichero (por ejemplo .txt) y devuelva por pantalla todos los ficheros del directorio que \r\n"
				+ "   cumplan el criterio\n\n"+ Color.reset);
		
		String ext = ".txt";
		//String ext = ".exe";
		File directorio = new File(".\\src\\es\\florida\\seccion01");

		contenidoFiltrado(ext, directorio);
	}

	/*Comment
	 Crea, recorre y muestra la lista objetos (ficheros) que hay dentro de un directorio filtrados por extensión.
	 El filtrado lo hacemos implementando el interfaz FiltroExtension al que pasamos la extension que queremos filtrar.
	 INPUT:		String con la extesion que queremos filtrar y Objeto directorio con el path
	 OUTPUT:	muestra lists de todos los objetos del ArrayList 		 */
	public static void contenidoFiltrado(String ext, File directorio) {

		String[] listaArchivos = directorio.list(new FiltroExtension(ext)); 
		System.out.print(Color.yellow + "Directorio:	" + Color.reset + directorio + Color.yellow + "\n\nContenido: "+ Color.reset);
		for (String archivo : listaArchivos) {
				System.out.println("		" + archivo);
		}
	}
}
