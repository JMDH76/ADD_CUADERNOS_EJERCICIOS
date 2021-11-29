package es.florida.seccion03;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio21 {

	public static void main(String[] args) {

		// Creamos DOM:
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(new File("src\\es\\florida\\seccion03\\zapateria.xml"));

			Element raiz = document.getDocumentElement(); // declaramos el nodo raiz
			System.out.println("Contenido XML de " + raiz.getNodeName());

			NodeList nodelist = document.getElementsByTagName("zapato"); // nodo principal que contiene la informacion de cada objeto zapato
			
			System.out.println("El nodo principal \"" + raiz.getNodeName() + "\" contiene " + nodelist.getLength()
			+ " nodos u objetos.");
			
			System.out.println("Objetos zapato:");
			for (int i = 0; i < nodelist.getLength(); i++) {

				Node node = nodelist.item(i);
				Element eElement = (Element) node;
				String id = eElement.getAttribute("id");
				String tipo = eElement.getElementsByTagName("tipo").item(0).getTextContent();
				String marca = eElement.getElementsByTagName("marca").item(0).getTextContent();
				String modelo = eElement.getElementsByTagName("modelo").item(0).getTextContent();
				String color = eElement.getElementsByTagName("color").item(0).getTextContent();
				String talla = eElement.getElementsByTagName("talla").item(0).getTextContent();
				String precio = eElement.getElementsByTagName("precio").item(0).getTextContent();
				
				Zapato zapato = new Zapato(id, tipo, marca, modelo, color, talla, precio );
				System.out.println(zapato.getToString());
			}
			
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}