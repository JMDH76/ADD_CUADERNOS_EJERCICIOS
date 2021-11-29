package es.florida.seccion03;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class Ejercicio23 {
	
	public static void main(String[] args) {
		
		int ultimoId = 0;
		Zapato zapato;
		ArrayList<Zapato> listazapatos = new ArrayList<Zapato>(); 
		
		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("src\\es\\florida\\seccion03\\zapateria.xml"));

			Element raiz = document.getDocumentElement();
			System.out.println("Contenido XML de " + raiz.getNodeName());

			NodeList nodelist = document.getElementsByTagName("zapato");

			int numeronodos = nodelist.getLength();

			System.out.println(
					"El nodo principal \"" + raiz.getNodeName() + "\" contiene " + numeronodos + " nodos u objetos.");

			for (int i = 0; i < numeronodos; i++) {

				Node node = nodelist.item(i);
				Element eElement = (Element) node;
				// Obtenemos y presentamos
				System.out.println("\n");
				String id = eElement.getAttribute("id");
				System.out.println("   ID zapato: " + id + "\n   ------------");

				String tipo = eElement.getElementsByTagName("tipo").item(0).getTextContent();
				System.out.println("	Tipo:	" + tipo);

				String marca = eElement.getElementsByTagName("marca").item(0).getTextContent();
				System.out.println("	Marca:	" + marca);

				String modelo = eElement.getElementsByTagName("modelo").item(0).getTextContent();
				System.out.println("	Modelo:	" + modelo);

				String color = eElement.getElementsByTagName("color").item(0).getTextContent();
				System.out.println("	Color:	" + color);

				String talla = eElement.getElementsByTagName("talla").item(0).getTextContent();
				System.out.println("	Talla:	" + talla);

				String precio = eElement.getElementsByTagName("precio").item(0).getTextContent();
				System.out.println("	Precio: " + precio);

				zapato = new Zapato(id, tipo, marca, modelo, color, talla, precio); // Creamos objeto "Zapato zapato"
				listazapatos.add(zapato); // Añadimos al ArrayList (guardado)
				ultimoId = Integer.parseInt(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("\n¿Desea añadir un zapato? (s/n) ");
			String respuesta = br.readLine().toLowerCase();
			
			while(respuesta.equals("s")) {
				System.out.print("Tipo: "); String tipo = br.readLine();
				System.out.print("Marca: "); String marca = br.readLine();
				System.out.print("Modelo: "); String modelo = br.readLine();
				System.out.print("Color: "); String color = br.readLine();
				System.out.print("Talla: "); String talla = br.readLine();
				System.out.print("Precio: "); String precio = br.readLine() + "€";
				ultimoId++;
				
				zapato = new Zapato (Integer.toString(ultimoId), tipo, marca, modelo, color, talla, precio);
				listazapatos.add(zapato);
				System.out.println("\nNuevo item guardado en la lista: " + zapato.getToString());
				System.out.print("\n¿Desea añadir un zapato? (s/n) ");
				respuesta = br.readLine().toLowerCase();
			}
			br.close();
			
			System.out.println("\nListado actualizado:\n-------------------");
			for (Zapato zap : listazapatos) {
				System.out.println(zap.getToString());
			}

		} catch ( IOException  e) {
			e.printStackTrace();
		}
	}
}
