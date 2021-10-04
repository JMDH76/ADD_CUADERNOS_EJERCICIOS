package es.florida.seccion01;

import java.io.File;

public class Ejercicio02 {

	public static void main(String[] args) {
		System.out
				.print(Color.green + "2. Ampliar el programa anterior para que muestre todas las características de interés del \r\n"
						+ "   directorio, tomando como referencia la información que proporciona la clase File.\n" + Color.reset);

		File directorio = new File(".\\src\\es\\florida\\seccion01"); 		
			
		datosDirectorio(directorio);
		contenidoDirectorio(directorio);
	}	
	
/*	Comment
 	Crea y recorre la lista extrayendo los nombres del contenido de la carpeta. La condición del bucle es para formatear la salida.
	INPUT: 	Path del directorio
	OUT: 	Muestra por consola los nombres de los archivos y carpetas   */
	public static void contenidoDirectorio(File directorio) {
		
		String[] listaArchivos = directorio.list(); 
		
		System.out.print(Color.yellow + "\nContenido:" + Color.reset);		
		int cont = 0;
		for (String archivo : listaArchivos) {
			cont++;
			if (cont == 1) System.out.println("  " + archivo);	
			else System.out.println(" 	    " + archivo);
		}
	}

/*	Comment
	INPUT: 	Objeto File con la dirección del directorio
	OUT: 	Muestra por consola los datos del directorio (nombre, rutas rel y abs, tamaño, escritura o lectura)    */
	public static void datosDirectorio(File directorio) {

		System.out.println(Color.yellow + "\nDirectorio:	" + Color.reset + directorio.getName()); 
		System.out.println("Ruta rel:	" + directorio.getPath()); 
		System.out.println("Ruta abs:	" + directorio.getAbsolutePath()); 
		System.out.println("Lectura:	" + directorio.canRead()); 
		System.out.println("Escritura:	" + directorio.canWrite()); 
		System.out.println("Tamaño:		" + unidadTamaño(directorio)); 
	}
	
/* Comment
 	Elije las unidades y formatea el número según el tamaño del directorio.
 	INPUT: 	pasamos el objeto File con el path del directorio
 	OUT:  	devuelve  Strin con el tamaño y la unidad de la carpetao*/	
	public static String unidadTamaño( File directorio) {
	 	
		String tamaño = " kB";
		if (directorio.length() < 1000) tamaño = directorio.length() + " bytes";
		else if (directorio.length() >= 1000 && directorio.length() < 1000000) tamaño = directorio.length()/1000 + " kB";
		else if (directorio.length() >= 1000000) tamaño = directorio.length()/1000000 + " MB";
		return tamaño;		
	}
	
}
