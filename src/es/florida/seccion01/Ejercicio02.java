package es.florida.seccion01;

import java.io.File;

public class Ejercicio02 {

	public static void main(String[] args) {
		System.out
				.print(Color.green + "2. Ampliar el programa anterior para que muestre todas las caracter�sticas de inter�s del \r\n"
						+ "   directorio, tomando como referencia la informaci�n que proporciona la clase File.\n" + Color.reset);

		File directorio = new File(".\\src\\es\\florida\\seccion01"); 		
			
		datosDirectorio(directorio);
		contenidoDirectorio(directorio);
	}	
	
/*	Comment
 	Crea y recorre la lista extrayendo los nombres del contenido de la carpeta. La condici�n del bucle es para formatear la salida.
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
	INPUT: 	Objeto File con la direcci�n del directorio
	OUT: 	Muestra por consola los datos del directorio (nombre, rutas rel y abs, tama�o, escritura o lectura)    */
	public static void datosDirectorio(File directorio) {

		System.out.println(Color.yellow + "\nDirectorio:	" + Color.reset + directorio.getName()); 
		System.out.println("Ruta rel:	" + directorio.getPath()); 
		System.out.println("Ruta abs:	" + directorio.getAbsolutePath()); 
		System.out.println("Lectura:	" + directorio.canRead()); 
		System.out.println("Escritura:	" + directorio.canWrite()); 
		System.out.println("Tama�o:		" + unidadTama�o(directorio)); 
	}
	
/* Comment
 	Elije las unidades y formatea el n�mero seg�n el tama�o del directorio.
 	INPUT: 	pasamos el objeto File con el path del directorio
 	OUT:  	devuelve  Strin con el tama�o y la unidad de la carpetao*/	
	public static String unidadTama�o( File directorio) {
	 	
		String tama�o = " kB";
		if (directorio.length() < 1000) tama�o = directorio.length() + " bytes";
		else if (directorio.length() >= 1000 && directorio.length() < 1000000) tama�o = directorio.length()/1000 + " kB";
		else if (directorio.length() >= 1000000) tama�o = directorio.length()/1000000 + " MB";
		return tama�o;		
	}
	
}
