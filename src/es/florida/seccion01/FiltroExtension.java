package es.florida.seccion01;

import java.io.File;
import java.io.FilenameFilter;

public class FiltroExtension implements FilenameFilter{  //Interfaz de Ejercico05
	
	//constructor
	String extension;
	
	FiltroExtension (String extension) {
		this.extension = extension;
	}
	
/*	Recibe
 * 	INPUT:	?????	
 	OUTPUT:	devuelve un booleano indicando si hay archivos con esa extension en la carpeta*/
	public boolean accept ( File dir, String name) {
		return name.endsWith (extension);
	}
}
