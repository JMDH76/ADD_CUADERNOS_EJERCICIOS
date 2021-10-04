package es.florida.seccion01;

import java.io.File;

public class Ejercicio06 {

		public static void main(String[] args) {

			System.out.print(Color.green + "6. Modifica el programa anterior para que tenga en cuenta que si no se le pasa ninguna \r\n"
					+ "   extensión como parámetro muestre todo el contenido del directorio.\n\n"+ Color.reset);
			
			String ext="";
			File directorio = new File(".\\src\\es\\florida\\seccion01");
			
			contenidoFiltrado(ext, directorio);
		}

/*		Comment
		Crea, recorre y muestra la lista objetos (ficheros) que hay dentro de un directorio filtrados por extensión; si no 
		se pasa extension saca toda la lista.
	 	El filtrado lo hacemos implementando el interfaz FiltroExtension al que pasamos la extension que queremos filtrar.
		INPUT:		String con la extesion que queremos filtrar y Objeto directorio con el path
		OUTPUT:		muestra lists de todos los objetos del ArrayList 		 */
		public static void contenidoFiltrado(String ext, File directorio) {
			
			String[] listaArchivos;
			
			if (ext == null) listaArchivos = directorio.list();	
			else listaArchivos = directorio.list(new FiltroExtension(ext));
				
			System.out.print(Color.yellow + "Directorio:	" + Color.reset + directorio + Color.yellow + "\n\nContenido: "+ Color.reset);
			for (String archivo : listaArchivos) {
					System.out.println("		" + archivo);
			}
		}
	}