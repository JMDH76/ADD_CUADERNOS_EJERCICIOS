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

public class Ejercicio18 {

	public static void main(String[] args) {

		// Creamos DOM:
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document;

			document = dBuilder.parse(new File("src\\es\\florida\\seccion03\\zapateria.xml"));
			Element raiz = document.getDocumentElement(); // declaramos el nodo raiz
			System.out.println("Contenido XML de " + raiz.getNodeName());

			NodeList nodelist = document.getElementsByTagName("zapato"); // nodo principal que contiene la informacion d
																			// ecada objeto zapato
			for (int i = 0; i < nodelist.getLength(); i++) {

				Node node = nodelist.item(i);
				System.out.println("\n");

				Element eElement = (Element) node;
				System.out.println("   ID zapato: " + eElement.getAttribute("id") + "\n   ------------");

				System.out.println("	Tipo:	" + eElement.getElementsByTagName("tipo").item(0).getTextContent());
				System.out.println("	Marca:	" + eElement.getElementsByTagName("marca").item(0).getTextContent());
				System.out.println("	Modelo:	" + eElement.getElementsByTagName("modelo").item(0).getTextContent());
				System.out.println("	olor" + eElement.getElementsByTagName("color").item(0).getTextContent());
				System.out.println("	Talla: " + eElement.getElementsByTagName("talla").item(0).getTextContent());
				System.out.print("	Precio: " + eElement.getElementsByTagName("precio").item(0).getTextContent());
			}

		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}
