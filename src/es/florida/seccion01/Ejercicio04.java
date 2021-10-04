package es.florida.seccion01;

import java.io.File;

public class Ejercicio04 {
	
	public static void main(String[] args) {

		System.out.print(Color.green + "4. Realizar un programa que dado un directorio, compruebe si existe y devuelva \r\n"
				+ "   un mensaje de confirmación si existe o una alerta en caso contrario.\n" + Color.reset);
		
		File directorio = new File(".\\src\\es\\florida\\seccion01\\Nueva carpeta");  	//Existe
		//File directorio = new File(".\\sc\\es\\florida\\seccion01\\Nueva carpeta");	//No existe (para probarlo)
		
		System.out.println("\n" + existeDirectorio(directorio));
		}
	
/*		Comment
	  	Comprueba si existe el directorio
	 	INPUT: 	Objeto File con path del directorio
	 	OUTPUT: String con mensaje y resultado de la comprobación	*/
		public static String existeDirectorio(File directorio) {
			String mensaje;
			if (directorio.exists() == true) {
				mensaje = Color.green + "   El directorio existe"+ Color.reset;
			} else
				mensaje =  Color.yellow + "   ¡El directorio no existe!" + Color.reset;
			return mensaje;
		}
}