package es.florida.repasoexamen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import es.florida.seccion01.FiltroExtension;

public class RepasoExamen {

	public static void main(String[] args) throws IOException {
		
		File dir = new File ("./src/es/florida/seccion01");
		String nombredirectorio = dir.getName();
		System.out.println(nombredirectorio);
		
	
		String[] archivos = dir.list();
		int contador = 0;
		for (String archivo : archivos) {
			
			File f1 = new File(archivo);
			
			System.out.print(f1.getName() + ":");
			System.out.println(f1.isDirectory());
			f1.exists();
			int pos = 1;
			
			archivos[pos] = archivo;
		}
		
		File f = new File ("./src/es/florida/seccion01/NewFile.txt");	
		
		if (f.createNewFile())
            System.out.println("File created");
        else
            System.out.println("File already exists");
				
		System.out.println(f.getParent());
		
		f.renameTo(new File ("./src/es/florida/seccion01/NewFile_rename.txt"));
		
		
	}

}
