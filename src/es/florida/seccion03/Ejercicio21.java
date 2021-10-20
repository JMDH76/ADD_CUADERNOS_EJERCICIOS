package es.florida.seccion03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio21 {

	public static void main(String[] args) {
		
		try {
		System.out.println("Clase Zapato:\n");
		File f = new File("src\\es\\florida\\seccion03\\Zapato.java");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader (fr);
		String linea = br.readLine();
			
			while(linea != null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Comprobacion de la clase
		//Zapato zapato = new Zapato ("Deportivo", "Puma", "Gold", "Blanco", "42","59,99€" );
		//System.out.print(zapato.getToString());
	}

}
