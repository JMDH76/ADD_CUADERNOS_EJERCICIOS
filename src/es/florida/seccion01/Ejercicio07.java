package es.florida.seccion01;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio07 {

	public static void main(String[] args) {

		System.out.print(Color.green
				+ "7. Modifica el programa anterior para que admita como parámetros de entrada un número \r\n"
				+ "   cualquiera de extensiones, devolviendo después por pantalla todos los ficheros del \r\n"
				+ "   directorio que tengan alguna de las extensiones indicadas.\n\n" + Color.reset);

		File directorio = new File(".\\src\\es\\florida\\seccion01");
		ArrayList<String> extensiones = new ArrayList<String>();
		
		insertarExtensiones(extensiones);
		System.out.print(Color.yellow + "\nDirectorio:	" + Color.reset + directorio + Color.yellow + "\n\nContenido: " + Color.reset);
		for (String ext : extensiones) {
				contenidoFiltrado(ext, directorio);
		} 
	}
		
	
/*	Comment
 	Pide por consola las extensiones que queremos consultar y las mete en el ArrayList de extensiones.
 	Finalizará de pedir cuando pulsemos "f".
 	INPUT:	pasamos ArrayList de extensiones
 	OUTPUT: devuelve el ArrayList relleno con las extensiones*/	
	public static void insertarExtensiones(ArrayList<String> extensiones) {

		Scanner teclado = new Scanner(System.in);
		String ext = "";
		while (!ext.equals("f")) {
			System.out.print(Color.cyan + "Inserte una extension (\"f\" para finalizar): " + Color.reset);
			ext = teclado.nextLine();
			if (!ext.equals("f"))	extensiones.add(ext);
		}
		teclado.close();
	}

	/*
	Comment 
	Crea, recorre y muestra la lista objetos (ficheros) que hay dentro del
	directorio filtrados por extensión. El filtrado lo hacemos implementando el interfaz 
	FiltroExtension al que pasamos la extension que queremos filtrar. 
	INPUT: String con la extesion que queremos filtrar y Objeto directorio con el path 
	OUTPUT: muestra lista de todos los objetos del ArrayList	 */
	public static void contenidoFiltrado(String ext, File directorio) {
		
	
		String[] listaArchivos = directorio.list(new FiltroExtension(ext));
		for (String archivo : listaArchivos) {
			System.out.println("		" + archivo);
		}
	}
}