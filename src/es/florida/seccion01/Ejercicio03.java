package es.florida.seccion01;

import java.io.File;

public class Ejercicio03 {
	    
	public static void main(String[] args) {
		System.out
				.print(Color.green + "3. Introducir una comprobaci�n en el programa anterior para determinar si el directorio existe.\r\n" + Color.reset);

		File directorio = new File(".\\src\\es\\florida\\seccion01"); 
		
		directorioExist(directorio);
	}	
	
/*	Comment
 	Comprueba si el directorio existe o no. Si existe, crea la lista de su contenido y llamamos a las dem�s funciones para sacarlo por consola
 	INPUT:	Pasamos Objeto File con el path.
 	OUTPUT: Si existe devuelve contenido; si no existe, mensaje	*/
	public static void directorioExist(File directorio) {
		
		if ( directorio.exists() == true) {
			String[] listaArchivos = directorio.list();
			datosDirectorio(directorio);
			contenidoDirectorio(listaArchivos);
		} else System.out.print(Color.yellow + "\nEl directorio no existe" + Color.reset);
	}
	

/*	Comment
 			Comprueba que haya contenido dentro de la carpeta; si es as�, recorre la lista extrayendo 
			los nombres del contenido de la carpeta. La condici�n del bucle es para formatear la salida.
	INPUT: 	Lista de String con contenido del directorio
	OUT: 	Muestra por consola los nombres de los archivos y carpetas   */
	public static void contenidoDirectorio(String[] listaArchivos) {
		
		System.out.print(Color.yellow + "\nContenido:" + Color.reset);
		if (listaArchivos.length == 0)
			System.out.println( Color.cyan + "		�El directorio est� vac�o!" + Color.reset);
		else {
			int cont = 0;
			for (String archivo : listaArchivos) {
				cont++;
				if (cont == 1)
					System.out.println("  " + archivo);
				else
					System.out.println(" 	    " + archivo);
			}
		}
	}

/*	Comment
	INPUT: 	Objeto File con la direcci�n del directorio
	OUT: 	Muestra por consola los datos del directorio (nombre, rutas rel y abs, tama�o, escritura o lectura)    */
	public static void datosDirectorio(File directorio) {
		
		System.out.println(Color.yellow + "\nDirectorio:	" + Color.reset + directorio.getName()+"\n");
		System.out.println(" Ruta rel:	" + directorio.getPath()); 	
		System.out.println(" Ruta abs:	" + directorio.getAbsolutePath()); 
		System.out.println(" Lectura:	" + directorio.canRead()); 
		System.out.println(" Escritura:	" + directorio.canWrite()); 
		System.out.println(" Tama�o:	" + unidadTama�o(directorio));
	}
	
/* Comment
 	Elije las unidades y formatea el n�mero seg�n el tama�o del directorio.
 	INPUT: 	pasamos el objeto File con el path del directorio
 	OUT:  	devuelve  String con el tama�o y la unidad de la carpeta     */	
	public static String unidadTama�o( File directorio) {
	 	
		String tama�o = " kB";
		if (directorio.length() < 1000) tama�o = directorio.length() + " bytes";
		if (directorio.length() >= 1000 && directorio.length() < 1000000) tama�o = directorio.length()/1000 + " kB";
		if (directorio.length() >= 1000000) tama�o = directorio.length()/1000000 + " MB";
		return tama�o;		
	}
}

