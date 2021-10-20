package es.florida.seccion03;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;

public class Ejemplo_teoria {

	public static void main(String[] args) {
		
		try {
			
			/*DOM  (Document Object Model)
			Generacion de una estructura DOM a partir de un XML. Usamos la clase abstracta DocumentBuilder.
		 	Para poder crear un objeto debemos especificar DocumentBuilderFactory y la clase Document.
		 	IMPORTANTE: debemos usar la libreria -> import org.w3c.dom.Document	
		 	"document" es un "parse" o analizador de etiquetas jerarquico (DOM - Document Object Model) 
			y lee todo el documento y lo guarda en memoria de forma jerarquica. Le pasamos el fichero con el que queremos trabajar.
			
			Pasos para crear el DOM: */
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("src\\es\\florida\\seccion03\\Canciones.xml")); //DOM al que pasamos el fichero
			
			
			Element raiz = document.getDocumentElement();	//Obtenemos el elemento raiz del documento (.xml) -> en el ejemplo "<canciones> del que cuelgan el resto
			System.out.println("Contenido XML " +  raiz.getNodeName() + ": ");  //.getNodeName() para obtener el nombre del elemento <canciones>
			
			/*Construimos una lista de nodos a partir del documento ("document"), 
			 los nodos son los que están identificados con la etiqueta ("tag") "cancion".
			 Nos devuelve los elementos que tengan como tag "cancion" y lo guardamos en una lista de nodos.*/
			NodeList nodeList = document.getElementsByTagName("cancion");  //identificamos el nodo principal dandole el nombre
			
			
			/*Recorremo la lista ".getLength()" nos da la longitud de esta */
			for (int i = 0 ; i < nodeList.getLength(); i++) {
				
				Node node = nodeList.item(i); //accedemos a cada uno de los nodos; devuelve el nodo que hay en la posicion i
				System.out.print("\n");
				
				/* hacemos un cast del objeto nodo a objeto Elemento porque vamos a usar los 
				 * metodos de la clase elemento para conseguir el contenido de cada una de las 
				 * etiquetas */
				Element eElement = (Element) node; //Elemento cancion
				System.out.println("ID cancion: " + eElement.getAttribute("id"));  //para obtener un atributo de la etiqueta
				
				/*devuelve el contenido de las etiqueta "titulo". "getTextContent()" para hacerlo todo un String*/
				System.out.println("Titulo: " + eElement.getElementsByTagName("titulo").item(0).getTextContent());	
				System.out.println("Artista: " + eElement.getElementsByTagName("artista").item(0).getTextContent());
				System.out.println("Año: " + eElement.getElementsByTagName("anyo").item(0).getTextContent());
				System.out.println("Formato: " + eElement.getElementsByTagName("formato").item(0).getTextContent());
			}
		}
		catch (SAXException | IOException | ParserConfigurationException e) {
				e.printStackTrace();
			}

	}

}
