package es.florida.seccion01;

import java.io.File;

public class Ejercicio01 {
	
	public static void main(String[] args) {

		System.out.println( Color.green +
				"1. Realiza un programa que reciba como parámetro de entrada un directorio y lo muestre por pantalla.\n" + Color.reset);

		File directorio = new File(".\\src\\es\\florida\\seccion01"); 	// Creamos objeto File con la ruta relativa del// directorio															
		 					
		contenidoDirectorio(directorio);

	}
/*	Comment
	Crea y recorre la lista extrayendo los nombres del contenido de la carpeta. La condición del bucle es para formatear la salida.
	INPUT: 	Path del directorio
	OUT: 	Muestra por consola los nombres de los archivos y carpetas   */
	public static void contenidoDirectorio(File directorio) {

		String[] listaArchivos = directorio.list();								// Crea un Array con la lista del contenido del directorio
		
		System.out.println("Directorio:	" + directorio.getName() + "\n"); 	// Obtenemos el nombre del directorio
		System.out.print("Contenido:");
		int cont = 0;
		for (String archivo : listaArchivos) {
			cont++;
			if (cont == 1)
				System.out.println("	" + archivo); 
			else
				System.out.println("		" + archivo);
		}
	}
}
