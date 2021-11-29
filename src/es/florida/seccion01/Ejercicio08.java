package es.florida.seccion01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio08 {

	public static void main(String[] args) throws IOException {
		
		System.out.println(Color.green + "8. Desarrolla un programa que dado un fichero, realice una copia del mismo (en el mismo \r\n"
				+ "   directorio y cambiándole el nombre) y lo borre después. Muestra una traza por pantalla de \r\n"
				+ "   las acciones para ver que se realizan.\n" + Color.reset);
		
		//Asignamos el nombre de fichero a copiar como argumento y lo mostramos
		String nombreFichero = "fichero_01.txt";
		System.out.println(Color.cyan + "Fichero original:	"+ Color.reset + nombreFichero );
		
		
		//Buscamos el indice donde se enccuentra el punto dentro del String para capturar el nombre y la extension
		int posicionPunto = nombreFichero.indexOf(".");
		String nombreFicheroSinExtension = nombreFichero.substring(0, posicionPunto);  	//nombre del fichero
		String extension = nombreFichero.substring(posicionPunto);						//extensión del fichero
		String nombreFicheroCopia = nombreFicheroSinExtension + "_copia" + extension; 	//nombre para la copia
		System.out.println(Color.cyan + "Fichero copia:		" + Color.reset + nombreFicheroCopia + "\n");
		
		
		//Tenemos que abrir el fichero original leerlo y copiarlo y despues copiar en el fichero copia.
		File ficheroOriginal = new File (nombreFichero);   	//Creamos para lectura
		File ficheroCopia = new File (nombreFicheroCopia);	//Creamos para escritura
		
		FileReader fr = new FileReader (ficheroOriginal); 	//Creamos objeto FileReader al que le pasamos el fichero original para leerlo
		BufferedReader br = new BufferedReader (fr);		//Para poder leer linea a linea
		
		FileWriter fw = new FileWriter(ficheroCopia);		//Creamos para escritura. Pasamos nombre fichero copia para escribirlo.
		BufferedWriter bw = new BufferedWriter(fw);			//Escribe linea a linea lo que ha leido con BufferedReader
		
		//Proceso de copia y notificacion por pantalla
		String linea = br.readLine();			//Asignamos contenido de una linea
		while(linea != null) {
			System.out.println(Color.cyan + "Copiando linea:	" + Color.reset + "	\""  + linea  + "\"" + Color.yellow +  " de " + nombreFichero + " a " + nombreFicheroCopia + Color.reset);
			bw.write(linea);					//Escribimos en el nuevo fichero
			linea = br.readLine();
		}
		br.close();
		bw.close();
		fr.close();
		fw.close();
		
		System.out.println(Color.cyan + "\nBorrando fichero: " + Color.reset + nombreFicheroCopia);
		ficheroCopia.delete();			//Borrado del fichero
		
	}
}